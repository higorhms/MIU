package probC;

public abstract class Employee {
    private int empId;

    public void print() {
        System.out.println(String.format("{ \n  empId: \"%s\"\n}"));
    }

    public Paycheck calcCompensation(int month, int year) {
        double salary = this.calcGrossPay(month, year);

        Paycheck pay = new Paycheck(
                salary,
                salary * Taxes.FICA,
                salary * Taxes.STATE,
                salary * Taxes.LOCAL,
                salary * Taxes.MEDICARE,
                salary * Taxes.SOCIAL_SECURITY);

        return pay;
    }

    public abstract double calcGrossPay(int month, int year);

}
