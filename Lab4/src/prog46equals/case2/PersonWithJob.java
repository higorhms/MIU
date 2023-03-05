package prog46equals.case2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
    private double salary;

    PersonWithJob(String n, GregorianCalendar dob, double s) {
        super(n, dob);
        this.salary = s;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof PersonWithJob)) return false;
        PersonWithJob person = (PersonWithJob) obj;

        if(!this.getName().equals(((Person) obj).getName())) return false;

        int year1 = this.getDateOfBirth().get(Calendar.YEAR);
        int month1 = this.getDateOfBirth().get(Calendar.MONTH);
        int day1 = this.getDateOfBirth().get(Calendar.DAY_OF_MONTH);

        int year2 = person.getDateOfBirth().get(Calendar.YEAR);
        int month2 = person.getDateOfBirth().get(Calendar.MONTH);
        int day2 = person.getDateOfBirth().get(Calendar.DAY_OF_MONTH);

        if(year1 != year2 && month1 != month2 && day1 != day2) return false;

        return this.getSalary() == person.getSalary();

    }
}