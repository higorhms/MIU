package prob2a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
	enum SortMethod {
		BY_NAME,
		BY_SALARY
	};
	
	public void sort(List<Employee> employees, final SortMethod method) {
		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				switch (method){
					case BY_NAME -> {
						if(e1 == e2) return 0;
						if(e1.equals(e2)) return 0;
						if(e1.name.compareTo(e2.name) == 1) return 1;
						if(e1.name.compareTo(e2.name) == 0 && e1.salary > e2.salary) return 1;
						return -1;
					}
					case BY_SALARY -> {
						if(e1.salary == e2.salary) return 0;
						if(e1.salary > e2.salary) return 1;
						if(e1.salary == e2.salary && e1.name.compareTo(e2.name) == 1) return 1;
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
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Joe", 100000));
		employees.add(new Employee("Tim", 50000));
		employees.add(new Employee("Andy", 60000));
		EmployeeInfo employeeInfo = new EmployeeInfo();
		System.out.println("Sorted by name: ");
		employeeInfo.sort(employees, EmployeeInfo.SortMethod.BY_NAME);
		System.out.println(employees);
		System.out.println();
		System.out.println("Sorted by Salary: ");
		employeeInfo.sort(employees, EmployeeInfo.SortMethod.BY_SALARY);
		System.out.println(employees);
		System.out.println();
	}
}