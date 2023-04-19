package prob6;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class LambdaAndMethodReferenceExample {
	private Employee employee = new Employee("Teste");
	private Apple apple;

	public static void main(String[] args) {
		LambdaAndMethodReferenceExample examples = new LambdaAndMethodReferenceExample();

		examples.Prob1A();
		System.out.println();

		examples.Prob1B();
		System.out.println();

		examples.Prob1C();
		System.out.println();

		examples.Prob1D();
		System.out.println();

		examples.Prob1E();
		System.out.println();

		examples.Prob1F();
		System.out.println();

		examples.Prob1G();
		System.out.println();

	}

	public void Prob1A(){
		Function<Employee, String> e = Employee::getName;
		System.out.println("1A. Get Name");
		System.out.println(e.apply(employee));
	}

	public void Prob1B(){
		BiConsumer<Employee, String> employeeNameSetter = Employee::setName;
		System.out.println("1B. Set Name");
		employeeNameSetter.accept(employee, "New Name");
		System.out.println(employee.getName());
	}

	public void Prob1C(){
		BiFunction<String,String, Integer> f2 = String::compareTo;
		System.out.println("1C. Compare '1' with '1'");
		System.out.println(f2.apply("1", "1"));
	}

	public void Prob1D(){
		BiFunction<Integer, Integer, Double> pow = Math::pow;
		System.out.println("1D. math pow");
		System.out.println(pow.apply(2,2));
	}

	public void Prob1E(){
		Function<Apple, Double> weightGetter = Apple::getWeight;
		System.out.println("1E. get Weight");
		apple = new Apple();
		apple.setWeight(1.0);
		System.out.println(weightGetter.apply(apple));
	}

	public void Prob1F(){
		Function<String, Integer> intParser = Integer::parseInt;
		System.out.println("1F. Int Parser '1'");
		System.out.println(intParser.apply("1"));
	}

	public void Prob1G(){
		EmployeeNameComparator emp = new EmployeeNameComparator();
		BiFunction<Employee, Employee, Integer> employeeComparator = emp::compare;
		System.out.println("1G. Compare same instances");
		System.out.println(employeeComparator.apply(employee, employee));
	}
}

class Employee{
	private String name;
	
	public Employee(String name) {
		this.name = name;// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Apple{
	private Double weight;
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}

class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}

