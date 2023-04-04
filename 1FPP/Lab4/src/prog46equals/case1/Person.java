package prog46equals.case1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private String name;
    private GregorianCalendar dateOfBirth;

    Person(String name, GregorianCalendar dob) {
        this.name = name;
        dateOfBirth = dob;
    }

    public String getName() {
        return name;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Person)) return false;
        Person person = (Person) obj;

        if(!this.name.equals(((Person) obj).getName())) return false;

        int year1 = this.getDateOfBirth().get(Calendar.YEAR);
        int month1 = this.getDateOfBirth().get(Calendar.MONTH);
        int day1 = this.getDateOfBirth().get(Calendar.DAY_OF_MONTH);

        int year2 = person.getDateOfBirth().get(Calendar.YEAR);
        int month2 = person.getDateOfBirth().get(Calendar.MONTH);
        int day2 = person.getDateOfBirth().get(Calendar.DAY_OF_MONTH);

        return (year1 == year2 && month1 == month2 && day1 == day2);

    }
}