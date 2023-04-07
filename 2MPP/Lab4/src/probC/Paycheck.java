package probC;

public class Paycheck {
    private double grossPay;
    private double fica;
    private double state;
    private double local;
    private double medicare;
    private double socialSecurity;

    public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    public void print() {
    }

    public double getNetPay() {
        return this.grossPay - this.fica - this.state - this.local - this.medicare - this.socialSecurity;
    }

    @Override
    public String toString() {
        return String.format("{\n" +
                "  grossPay: \"%s\"\n" +
                "  fica: \"%s\"\n" +
                "  state: \"%s\"\n" +
                "  local: \"%s\"\n" +
                "  medicare: \"%s\"\n" +
                "  socialSecurity: \"%s\"\n" +
                "  netPay: \"%s\"\n}",
                this.grossPay,
                this.fica,
                this.state,
                this.local,
                this.medicare,
                this.socialSecurity,
                this.getNetPay()
        );
    }
}
