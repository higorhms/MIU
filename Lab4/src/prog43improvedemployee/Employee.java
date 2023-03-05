package prog43improvedemployee;

import java.time.LocalDate;

public class Employee {
        private AccountList accounts;
        private String name;
        private LocalDate hireDate;

        public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
            this.name = name;
            this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
            this.accounts = new AccountList();
        }

            public String getName(){
                return this.name;
            }

            public LocalDate gethireDate(){
                return this.hireDate;
            }

    public AccountList getAccounts() {
        return accounts;
    }

    public void createNewChecking (double startAmount){
                this.accounts.add( new CheckingAccount(this, startAmount));
            }

            public void createNewSavings ( double startAmount){
                this.accounts.add(new SavingsAccount(this, startAmount));
            }
            public void createNewRetirement ( double startAmount){
                this.accounts.add(new RetirementAccount(this, startAmount));
            }

            public void deposit (int accIndex,double amt){
                Account selectedAcc = this.accounts.get(accIndex);
                selectedAcc.makeDeposit(amt);
            }
            public boolean withdraw (int accIndex, double amt){
                Account selectedAcc = this.accounts.get(accIndex);
                return selectedAcc.makeWithdrawal(amt);
            }

            public String getFormattedAcctInfo () {
                String aux =
                        "\nACCOUNT INFO FOR " + this.getName() + ":\n"
                ;

                for(int index = 0 ; index < this.accounts.size() ; index++){
                    Account a = this.accounts.get(index);

                    aux += a.toString();
                }

                return aux;
            }
        }
