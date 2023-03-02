package prog31;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private final String name;
    private String nickName;
    private double salary;
    private final Date hireDay;
    private final String format = "name = %s, salary = %.2f, hireDay = %s";

    public Employee(String aName, String aNickName, double aSalary, int aYear, int aMonth, int aDay) {
        name = aName;
        nickName = aNickName;
        salary = aSalary;
        GregorianCalendar cal = new GregorianCalendar(aYear, aMonth - 1, aDay);
        Date time = cal.getTime();
        hireDay = time;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String aNickName) {
        this.nickName = aNickName;
    }

    public double getSalary() {
        return salary;
    }

    // needs to be improved
    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        this.salary += raise;
    }

    public String toString() {
        return String.format(format, name, salary, Util.dateAsString(hireDay));
    }
}