package prog43improvedemployee;

public class SavingsAccount extends Account{

    private final double READ_FEE = 0.25;
    public SavingsAccount(Employee emp, double balance) {
        super(emp, balance);
    }

    public AccountType getAcctType() {
        return AccountType.SAVINGS;
    }

    @Override
    public double getBalance() {
        double baseBalance = super.getBalance();
        double interest = (this.READ_FEE / 100) * baseBalance;
        return baseBalance + interest;
    }
}
