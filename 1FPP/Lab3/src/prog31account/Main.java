package prog31account;

import prog31account.Account;
import prog31account.AccountType;
import prog31account.Employee;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee(
                "H M S",
                "HMS",
                150.000,
                2020,
                01,
                01
        );
        Account checkingsAccount = new Account(employee1, AccountType.CHECKING, 300.00);
        Account savingsAccount = new Account(employee1, AccountType.SAVINGS, 300.00);
        Account retirementAccount = new Account(employee1, AccountType.RETIREMENT, 300.00);


        System.out.println(checkingsAccount.toString());
        System.out.println(savingsAccount.toString());
        System.out.println(retirementAccount.toString());
        System.out.println(employee1.toString());
    }
}