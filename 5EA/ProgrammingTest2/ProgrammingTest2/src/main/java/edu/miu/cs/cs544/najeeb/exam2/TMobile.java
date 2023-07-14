package edu.miu.cs.cs544.najeeb.exam2;

public class TMobile {

    int balance;
    String accountName;

    public TMobile(int balance, String accountName) {
        this.balance = balance;
        this.accountName = accountName;
    }

    boolean hasSufficientBalance() {
        if (0 < balance) {
            return true;
        } else {
            return false;
        }
    }

    boolean isAuthorized() {
        if ("jim".equals(accountName)) {
            return true;
        } else {
            return false;
        }
    }

    boolean openService() {
        if (0 < balance) {
            this.balance--;
            doOpenServiceCode();
            return true;
        } else {
            return false;
        }
    }

    private void doOpenServiceCode() {
        System.out.println("T Mobile stuff");
    }
}
