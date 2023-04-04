package prog21objects;
public class Main {

	public static void main(String[] args) {
		Address billingAddressCustomer1 = new Address("North Main Street", "Fairfield", "IA", "52556");
		Address shippingAddressCustomer1 = new Address("South Main Street", "Chicago", "IL", "52557");
		Address billingAddressCustomer2 = new Address("East Main Street", "Chicago", "IL", "52558");
		Address shippingAddressCustomer2 = new Address("West Main Street", "Fairfield", "IA", "52559");
		
		Customer customer1 = new Customer("John", "Doe", "111-11-1111");
		Customer customer2 = new Customer("Maria", "Doe", "222-22-2222");

		customer1.setBillingAddress(billingAddressCustomer1);
		customer1.setShippingAddress(shippingAddressCustomer1);
		customer2.setBillingAddress(billingAddressCustomer2);
		customer2.setShippingAddress(shippingAddressCustomer2);

		Customer[] customerArray = {customer1, customer2};

		for(Customer customer : customerArray){
			if(customer.getBillingAddress().getCity().equals("Chicago")) System.out.println(customer.toString());
		}

		System.out.println("Done");
	}

}
