package prog43improvedemployee;

public abstract class Account {
    private final static double DEFAULT_BALANCE = 0.0;
    private double balance;
    private Employee employee;

    public abstract AccountType getAcctType();

    public Account(Employee emp, double balance) {
        this.employee = emp;
        this.balance = balance;
    }

    public Account(Employee emp) {
        this(emp, DEFAULT_BALANCE);
    }

    public String toString() {
        String result = String.format("Current bal: " + this.balance + "\n");

        return result;
    }

    public void makeDeposit(double deposit) {
        if (deposit > 0) {
            this.balance += deposit;
        }
    }

    public boolean makeWithdrawal(double amount) {
        if (this.balance - amount < 0){
            System.out.println("Insufficient balance");
            return false;
        };
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }
}