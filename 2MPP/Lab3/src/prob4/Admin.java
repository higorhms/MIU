package prob4;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Admin {
	public static double computeTotalRent(Property[] properties) {
		double totalRent = 0;

		for (Property o : properties) {
				totalRent += o.computeRent();
		}

		return totalRent;
	}

	public static void listByCity(String city, Property[] properties){
		List<Property> aux = new ArrayList<Property>();

		for (Property o : properties) {
			if(o.getAddress() != null && o.getAddress().getCity().equals(city)) aux.add((o));
		}

		System.out.println(aux);
	}
}
