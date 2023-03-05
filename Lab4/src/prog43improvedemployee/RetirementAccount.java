package prog43improvedemployee;

public class RetirementAccount extends Account {

    private final double WITHDRAW_FEE = 2.0;
    public RetirementAccount(Employee emp, double balance) {
        super(emp, balance);
    }

    public AccountType getAcctType() {
        return AccountType.RETIREMENT;
    }

    @Override
    public boolean makeWithdrawal(double amount) {
        double baseBalance = this.getBalance();
        double penalty = (WITHDRAW_FEE / 100) * baseBalance;

        return super.makeWithdrawal(amount + penalty);
    }
}
