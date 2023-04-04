package prog46equals.case3;

import prog46equals.case3.Person;
import prog46equals.case3.PersonWithJob;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void isEqual(){
        GregorianCalendar calendar = new GregorianCalendar(1, 1, 2020);
        GregorianCalendar calendar2 = new GregorianCalendar(1, 1, 2020);

        Person person1 = new Person("HMS", calendar);
        Person person2 = new Person("HMS", calendar);
        PersonWithJob personwj1 = new PersonWithJob("HMS2", calendar2, 1000);
        PersonWithJob personwj2 = new PersonWithJob("HMS2", calendar2, 1000);

        assertEquals(person1.equals(person2), true);
        assertEquals(personwj1.equals(personwj2), true);
        assertEquals(person1.equals(personwj1), false);
        assertEquals(personwj2.equals(person2), false);
    }
}
