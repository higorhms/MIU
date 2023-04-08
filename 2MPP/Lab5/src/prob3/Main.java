package prob3;

import java.time.LocalDate;

import prob3.solution.CustOrderFactory;
import prob3.solution.Customer;
import prob3.solution.Order;

public class Main {
	public static void main(String[] args) {
		Customer customer = CustOrderFactory.createCustomer("Bob");
		Order order = CustOrderFactory.createOrder(customer, LocalDate.now());
		order.addItem("Shirt");
		order.addItem("Laptop");

		order = CustOrderFactory.createOrder(customer, LocalDate.now());
		order.addItem("Pants");
		order.addItem("Knife set");

		System.out.println(customer.getOrders());
	}
}


