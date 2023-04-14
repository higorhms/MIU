package business;

import librarysystem.LibrarySystem;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public void addNewMember(String id, String firstName, String lastName, String telNumber, Address add);
	public Book addNewBookCopy(String isbn);
	public void checkoutBook(String memberId, String isbn);
	public Book getBook(String isbn);
	public boolean isAValidMember(String id);
}
