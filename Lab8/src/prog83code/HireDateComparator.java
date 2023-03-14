package prog83code;

import java.util.Comparator;
import java.util.Date;

public class HireDateComparator implements Comparator<Employee> {

    public int compare(Employee e1, Employee e2) {
        Date hireDate1 = e1.getHireDate();
        Date hireDate2 = e2.getHireDate();

        return hireDate1.compareTo(hireDate2);
    }
}

