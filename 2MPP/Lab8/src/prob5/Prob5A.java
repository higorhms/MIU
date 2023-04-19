package prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class Prob5A {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
	
		list.stream().map(s -> s.toUpperCase()).forEach( s -> System.out.println(s));
	}
}

 class Prob5B {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon",
				"Away", "On Vacation", "Everywhere you want to be");

		list.stream().map(String::toUpperCase).forEach(System.out::println);
	}
}
