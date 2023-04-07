package probC;

public class Hourly extends Employee{
    private double hourlyWage;
    private double hoursPerWeek;

    public Hourly(double hourlyWage, double hoursPerWeek){
        this.hoursPerWeek = hoursPerWeek;
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlyWage * ( hoursPerWeek * 4);
    }
}
