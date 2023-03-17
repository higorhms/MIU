package lesson11.lab1.hashApplication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Employee {
	private String firstName;
	private String lastName;
	private HashMap salaryRecord;

	public Employee(){
		salaryRecord = new HashMap<String, Double>();
	}
	
	public void addEntry(String date, double salary) {
		salaryRecord.put(date, salary);
	}
	public void printPaymentAmount(String date) {
		var value = salaryRecord.get(date);
		if(value == null){
			System.out.println(String.format("%s %s was not paid on %s", this.firstName, this.lastName, date));
			return;
		}
		System.out.println(String.format("%s %s was paid %.2f on %s", this.firstName, this.lastName, salaryRecord.get(date), date));
	}
	public void printAveragePaycheck() {
		int size = salaryRecord.size();
		double aux = 0;

		HashMap<String, Double> mapperAux = (HashMap<String, Double>) this.salaryRecord;

		for(HashMap.Entry<String, Double> entry : mapperAux.entrySet()){
			aux += entry.getValue();
		}

		System.out.println("Average paycheck for " + this.firstName + " " + this.lastName + " was: " + aux / size);
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setFirstName("Jim");
		e.setLastName("Jones");
		for(int i = 1; i <= 12; ++i) {
			e.addEntry(i+"/15/2011", 3070+5*i);
		}

		e.printPaymentAmount("3/15/2011");
		e.printPaymentAmount("5/15/2010");
		e.printAveragePaycheck();
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
