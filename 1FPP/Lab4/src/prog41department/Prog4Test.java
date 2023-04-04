package prog41department;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Prog4Test {

    @Test
    public void combinedSalaries(){
        DeptEmployee[] employees = new DeptEmployee[5];

        employees[0] =  new Professor("John Doe", 1000, 1, 1, 2020);
        employees[1] = new Professor("Jacob Doe", 1000, 1, 1, 2020);
        employees[2] = new Professor("Joshua Doe", 1000, 1, 1, 2020);
        employees[3] = new Secretary("Maria Doe", 1000, 1, 1, 2020);
        employees[4] = new Secretary("Tracy Doe", 1000, 1, 1, 2020);

        double aux = 0;

        for (DeptEmployee employee: employees) {
            aux += employee.computeSalary();
        }

        assertEquals(aux, (double) 1000 * 5, 0.01);
    }
}
