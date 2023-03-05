package prog43improvedemployee;

import java.util.Scanner;

public class Main {
    Employee[] emps = null;

    public static void main(String[] args) {
        new Main();
    }

    Main() {
        emps = new Employee[3];

        emps[0] = new Employee("Jim Daley", 2000, 9, 4);
        emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
        emps[2] = new Employee("Susan Randolph", 1997, 2, 13);

        emps[0].createNewChecking(10500);
        emps[0].createNewSavings(1000);
        emps[0].createNewRetirement(9300);
        emps[1].createNewChecking(34000);
        emps[1].createNewSavings(27000);
        emps[2].createNewChecking(10038);
        emps[2].createNewSavings(12600);
        emps[2].createNewRetirement(9000);

        System.out.print("A. See a report of all accounts. \nB. Make a deposit. \nC. Make a withdrawal. \nMake a selection (A/B/C):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            if (input.equalsIgnoreCase("A")) {
                String info = getFormattedAccountInfo();
                System.out.println(info);
                System.exit(0);
            }

            if (input.equalsIgnoreCase("B")) {
                for (int index = 0; index < emps.length; index++) {
                    System.out.println(index + ". " + emps[index].getName());
                }
                System.out.print("Select an employee: (type a number) ");
                int inputB = scanner.nextInt();

                if (inputB >= emps.length) invalidOption();

                Employee selectedEmployee = emps[inputB];
                AccountList accounts = selectedEmployee.getAccounts();

                for (int index = 0; index < accounts.size(); index++) {
                    System.out.println(index + ". " + accounts.get(index).getAcctType());
                }

                System.out.print("Select an account: (type a number) ");
                int selectedAccount = scanner.nextInt();

                if (selectedAccount >= accounts.size()) invalidOption();

                System.out.print("Deposit amount: ");
                double inputAmount = scanner.nextDouble();

                Account account = accounts.get(selectedAccount);

                account.makeDeposit(inputAmount);

                System.out.println(String.format("%.2f has been deposited in the %s account of %s", inputAmount, account.getAcctType(), selectedEmployee.getName()));

                System.exit(0);
            }

            if (input.equalsIgnoreCase("C")) {
                for (int index = 0; index < emps.length; index++) {
                    System.out.println(index + ". " + emps[index].getName());
                }
                System.out.print("Select an employee: (type a number) ");
                int inputB = scanner.nextInt();

                if (inputB >= emps.length) invalidOption();

                Employee selectedEmployee = emps[inputB];
                AccountList accounts = selectedEmployee.getAccounts();

                for (int index = 0; index < accounts.size(); index++) {
                    System.out.println(index + ". " + accounts.get(index).getAcctType());
                }

                System.out.print("Select an account: (type a number) ");
                int selectedAccount = scanner.nextInt();

                if (selectedAccount >= accounts.size()) invalidOption();

                System.out.print("Withdraw amount: ");

                double inputAmount = scanner.nextDouble();

                Account account = accounts.get(selectedAccount);

                if (!account.makeWithdrawal(inputAmount)) System.exit(0);

                System.out.println(String.format("%.2f has been withdraw in the %s account of %s", inputAmount, account.getAcctType(), selectedEmployee.getName()));

                System.exit(0);
            }

        } catch (Exception err) {
            invalidOption();
        }
        invalidOption();
    }

    String getFormattedAccountInfo() {
        return String.format("%s %s %s",
                emps[0].getFormattedAcctInfo(),
                emps[1].getFormattedAcctInfo(),
                emps[2].getFormattedAcctInfo()
        );
    }

    void invalidOption() {
        System.out.println("Invalid Option");
        System.exit(0);
    }
}
