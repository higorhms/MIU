package probC;

public class Salaried extends Employee{
    private double salary;

    public Salaried(double salary){
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return this.salary;
    }
}
