package prog41department;

public class Secretary extends DeptEmployee {
    private double overtimeHours;
    public Secretary(String name, double salary, int day, int month, int year){
        super(name, salary, day, month, year);
    }

    @Override
    public double computeSalary(){
        double aux = overtimeHours * 12.0;
        return this.getSalary() + aux;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}
