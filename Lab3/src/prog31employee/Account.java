package prog31employee;

import prog31account.AccountType;

public class Account {
    private final static double DEFAULT_BALANCE = 0.0;
    private double balance;
    private AccountType acctType;
    private Employee employee;

    public Account(Employee emp, AccountType acctType, double balance) {
        this.employee = emp;
        this.acctType = acctType;
        this.balance = balance;
    }

    public Account(Employee emp, AccountType acctType) {
        this(emp, acctType, DEFAULT_BALANCE);
    }

    public String toString() {
        String result = String.format(
                "Account type: %s \n" +
                "Current bal: " + this.balance+ "\n"
        , this.getAcctType().toString());

        return result;
    }

    public void makeDeposit(double deposit) {
        if (deposit > 0) {
            this.balance += deposit;
        }
    }

    public boolean makeWithdrawal(double amount) {
        if (this.balance - amount < 0) return false;
        this.balance -= amount;
        return true;
    }

    public AccountType getAcctType() {
        return this.acctType;
    }

    public double getBalance() {
        return this.balance;
    }
}