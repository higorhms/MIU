package prob4;

public class Driver {

	public static void main(String[] args) {
		Property[] objects = { new House(9000), new Condo(2), new Trailer() };
		double totalRent = Admin.computeTotalRent(objects);
		System.out.println("Total rent: ");
		System.out.println(totalRent);

		System.out.println("List by City: ");
		Admin.listByCity("Fairfield", objects);
	}
}