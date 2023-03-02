import prog31.Account;
import prog31.AccountType;
import prog31.Employee;

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
    }
}