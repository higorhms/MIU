package prog46equals.case3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PersonWithJob {
    private double salary;
    private Person person;

    PersonWithJob(String n, GregorianCalendar dob, double s) {
        this.person = new Person(n, dob);
        this.salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public Person getPerson(){
        return this.person;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof PersonWithJob)) return false;
        PersonWithJob receivedPerson = (PersonWithJob) obj;

        if(!this.person.getName().equals(receivedPerson.getPerson().getName())) return false;

        int year1 = this.person.getDateOfBirth().get(Calendar.YEAR);
        int month1 = this.person.getDateOfBirth().get(Calendar.MONTH);
        int day1 = this.person.getDateOfBirth().get(Calendar.DAY_OF_MONTH);

        int year2 = receivedPerson.getPerson().getDateOfBirth().get(Calendar.YEAR);
        int month2 = receivedPerson.getPerson().getDateOfBirth().get(Calendar.MONTH);
        int day2 = receivedPerson.getPerson().getDateOfBirth().get(Calendar.DAY_OF_MONTH);

        if(year1 != year2 && month1 != month2 && day1 != day2) return false;

        return this.getSalary() == receivedPerson.getSalary();
    }
}