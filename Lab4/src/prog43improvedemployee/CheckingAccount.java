package prog43improvedemployee;

public class CheckingAccount extends Account {
    public final double SERVICE_FEE = 5.0;
    public CheckingAccount(Employee emp, double balance) {
        super(emp, balance);
    }

    public AccountType getAcctType() {
        return AccountType.CHECKING;
    }

    @Override
    public double getBalance() {
        if(!this.makeWithdrawal(SERVICE_FEE)) System.exit(0);

        return super.getBalance();
    }
}
