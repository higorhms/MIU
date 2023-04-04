package prog41department;

import java.time.LocalDate;

public class DeptEmployee {
    private String name;
    private double salary;
    private LocalDate hireDate;

    public double computeSalary(){
        return this.salary;
    }

    public DeptEmployee(String name, double salary, int day, int month, int year) {
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(LocalDate date) {
        this.hireDate = date;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nSalary: %.2f", this.name, this.salary);
    }
}
