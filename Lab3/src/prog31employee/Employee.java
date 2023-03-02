package prog31employee;

import prog31account.AccountType;

import java.time.LocalDate;

public class Employee {
        private Account savingsAcct;
        private Account checkingAcct;
        private Account retirementAcct;
        private String name;
        private LocalDate hireDate;

        public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
            this.name = name;
            //Replace these lines with LocalDate references
            // GregorianCalendar cal =
            // new GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire);
            // hireDate = cal.getTime();
            }

            public String getName(){
                return this.name;
            }

            public LocalDate gethireDate(){
                return this.hireDate;
            }

            public void createNewChecking (double startAmount){
                this.checkingAcct = new Account(this, AccountType.CHECKING, startAmount);
            }

            public void createNewSavings ( double startAmount){
                this.savingsAcct = new Account(this, AccountType.SAVINGS, startAmount);
            }
            public void createNewRetirement ( double startAmount){
                this.retirementAcct = new Account(this, AccountType.RETIREMENT, startAmount);
            }
            public void deposit (AccountType acctType,double amt){
                switch (acctType) {
                    case CHECKING:
                       this.checkingAcct.makeDeposit(amt);
                        break;
                    case SAVINGS:
                        this.savingsAcct.makeDeposit(amt);
                        break;
                    default:
                        this.retirementAcct.makeDeposit(amt);
                        break;
                }
            }
            public boolean withdraw (AccountType acctType,double amt){
                switch (acctType) {
                    case CHECKING:
                        return this.checkingAcct.makeWithdrawal(amt);
                    case SAVINGS:
                        return this.savingsAcct.makeWithdrawal(amt);
                    default:
                        return this.retirementAcct.makeWithdrawal(amt);
                }
            }

            public String getFormattedAcctInfo () {   // implement
                return String.format(
                        "\nACCOUNT INFO FOR %s: \n\n" +
                                "%s" +
                                "%s" +
                                "%s",
                        this.name,
                        this.checkingAcct == null ? "" : this.checkingAcct.toString(),
                        this.savingsAcct == null ? "" : this.savingsAcct.toString(),
                        this.retirementAcct == null ? "" : this.retirementAcct.toString()
                );
            }
        }
