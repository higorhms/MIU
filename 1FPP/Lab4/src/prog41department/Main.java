package prog41department;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DeptEmployee[] employees = new DeptEmployee[5];

        Professor professor1 = new Professor("John Doe", 1000, 1, 1, 2020);
        Professor professor2 = new Professor("Jacob Doe", 1000, 1, 1, 2020);
        Professor professor3 = new Professor("Joshua Doe", 1000, 1, 1, 2020);
        Secretary secretary1 = new Secretary("Maria Doe", 1000, 1, 1, 2020);
        Secretary secretary2 = new Secretary("Tracy Doe", 1000, 1, 1, 2020);

        professor1.setNumberOfPublications(10);
        professor2.setNumberOfPublications(10);
        professor3.setNumberOfPublications(10);
        secretary1.setOvertimeHours(200);
        secretary2.setOvertimeHours(200);

        employees[0] = professor1;
        employees[1] = professor2;
        employees[2] = professor3;
        employees[3] = secretary1;
        employees[4] = secretary2;

        System.out.println("Do you wish to see the sum of all salaries in the department? (y/n)");

        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();

        if(answer.equalsIgnoreCase("y")){
            double sum = 0;

            for(DeptEmployee employee : employees){
                sum += employee.computeSalary();
            }

            System.out.println("Result: " + sum);
        }

        System.exit(0);
    }
}
