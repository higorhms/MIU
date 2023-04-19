package prob2b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
    static enum SortMethod {BY_NAME, BY_SALARY}

    public void sort(List<Employee> employees, final SortMethod method) {
        class EmployeeComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee e1, Employee e2) {
                switch (method) {
                    case BY_NAME -> {
                        if (e1 == e2) return 0;
                        if (e1.equals(e2)) return 0;
                        if (e1.name.compareTo(e2.name) == 1) return 1;
                        if (e1.name.compareTo(e2.name) == 0 && e1.salary > e2.salary) return 1;
                        return -1;
                    }
                    case BY_SALARY -> {
                        if (e1.salary == e2.salary) return 0;
                        if (e1.salary > e2.salary) return 1;
                        if (e1.salary == e2.salary && e1.name.compareTo(e2.name) == 1) return 1;
                        return -1;
                    }
                    default -> {
                        return 0;
                    }
                }
            }
        }

        Collections.sort(employees, new EmployeeComparator());
    }

    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Joe", 100000));
        emps.add(new Employee("Tim", 50000));
        emps.add(new Employee("Andy", 60000));
        EmployeeInfo ei = new EmployeeInfo();
        ei.sort(emps, EmployeeInfo.SortMethod.BY_NAME);
        System.out.println(emps);
        //same instance
        ei.sort(emps, EmployeeInfo.SortMethod.BY_SALARY);
        System.out.println(emps);
    }
}
