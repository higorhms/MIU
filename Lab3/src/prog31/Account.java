package prog31;

public class Account {
    private final static double DEFAULT_BALANCE = 0.0;
    private double balance;
    private AccountType acctType;
    private Employee employee;

    public Account(Employee emp, AccountType acctType, double balance){
        this.employee = emp;
        this.acctType = acctType;
        this.balance = balance;
    }
    public Account(Employee emp, AccountType acctType){
        this(emp, acctType, DEFAULT_BALANCE);
    }

    public String toString() {
        return "type = " + acctType + ", balance = " + balance;
    }

    public void makeDeposit(double deposit) {
        if(deposit > 0){
            this.balance += deposit;
        }
    }

    public boolean makeWithdrawal(double amount) {
        if(this.balance - amount < 0) return false;
        this.balance -= amount;
        return true;
    }

    public AccountType getAcctType(){
        return this.acctType;
    }

    public double getBalance(){
        return this.balance;
    }
}