package business;

import java.io.Serializable;

/**
 * Immutable class
 */
final public class Address implements Serializable {
	private static final long serialVersionUID = -891229800414574888L;
	private String street;
	private String city;
	private String state;
	private String zip;
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "(" + street + ", " + city + ", " + zip + ")";
		
	}
}
