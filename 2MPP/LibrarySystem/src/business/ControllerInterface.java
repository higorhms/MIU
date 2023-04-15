package business;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public void addNewMember(String id,
	 String firstName,
	  String lastName,
		 String telNumber,
		     String street,
	 String city,
	 String state,
	 String zip);
	public Book addNewBookCopy(String isbn);
	public void checkoutBook(String memberId, String isbn);
	public Book getBook(String isbn);
	public boolean isAValidMember(String id);
}
