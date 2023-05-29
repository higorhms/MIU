package prob1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem1 {
	
	//Returns a list of those strings which belong to just one of the two lists
	//Hint: use concat
	public static List<String> elementsInBoth(List<String> list1, List<String> list2) {
		return Stream.concat(list1.stream(), list2.stream())
				.filter(e -> (list1.stream().filter(l1 -> e == l1).count() + list2.stream().filter(l2 -> e == l2).count() == 2))
				.distinct()
				.toList();
	}

	public static List<String> elementsInEither(List<String> list1, List<String> list2) {
		return Stream.concat(list1.stream(), list2.stream())
				.distinct()
				.toList();
	}
	
	//Returns a list, in sorted order, of the names of the Customers in the input list who live in Fairfield
	public static List<String> getAllFairfieldCustomers(List<Customer> list) {
		return list.stream().filter(customer -> customer.getCity().equals("Fairfield")).map(Customer::getName).toList();
	}

	public static List<String> elementsInJustOne(List<String> list1, List<String> list2) {
		return Stream.concat(list1.stream(), list2.stream())
				.filter(e -> (list1.stream().filter(l1 -> e == l1).count() + list2.stream().filter(l2 -> e == l2).count() == 1))
				.toList();
	}

	
	//test methods
	public static void main(String[] args) {
		testFirstMethod();
		testSecondMethod();
		testElementsInBothMethod();
		testElementsInEitherMethod();
	}
	private static void testFirstMethod() {
		List<String> list1 = Arrays.asList(new String[]{"friend", "tree", "bike", "bat"});
		List<String> list2 = Arrays.asList(new String[]{"tree", "strong", "bike", "weak"});
		System.out.println("Strings occurring in just one of the two lists: " + elementsInJustOne(list1, list2));
	}
	private static void testSecondMethod() {
		Customer cust1 = new Customer("Bob", "11 Adams", "Fairfield", "52556");
		Customer cust2 = new Customer("Laurence Lebihans",	"12, rue des Bouchers",	"Marseille","13008");
		Customer cust3 = new Customer("Andy", "1000 Channing Ave", "Palo Alto", "94301");
		Customer cust4 = new Customer("Zeke", "212 Wilkshire Blvd", "Chicago", "57532");
		Customer cust5 = new Customer("Blauer Delikatessen", "Forsterstr. 57","Mannheim", "68306");
		Customer cust6 = new Customer("Anna", "1000 N 4th", "Fairfield", "52557");
		List<Customer> list = Arrays.asList(cust1, cust2, cust3, cust4, cust5, cust6);
		System.out.println("Names of Customers who live in Fairfield: " + getAllFairfieldCustomers(list));
	}

	private static void testElementsInBothMethod() {
		List<String> list1 = Arrays.asList(new String[]{"friend", "tree", "bike", "bat"});
		List<String> list2 = Arrays.asList(new String[]{"tree", "strong", "bike", "weak"});
		System.out.println("Strings occurring in BOTH of the two lists: " + elementsInBoth(list1, list2));
	}

	private static void testElementsInEitherMethod() {
		List<String> list1 = Arrays.asList(new String[]{"friend", "tree", "bike", "bat"});
		List<String> list2 = Arrays.asList(new String[]{"tree", "strong", "bike", "weak"});
		System.out.println("Strings occurring in EITHER of the two lists: " + elementsInEither(list1, list2));
	}
}
