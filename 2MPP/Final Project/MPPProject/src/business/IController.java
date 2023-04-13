package business;

import java.util.List;

public interface IController {
	public void login(String id, String password) throws LoginException;
	public List<String> allBookIds();
	public void addLibraryMember(LibraryMember member);
	public void addCheckoutRecord(CheckoutRecordNew rec);
	public void addCopyOfBook(String isbn) throws SystemException;
	public List<CheckoutRecordNew> getCheckoutRecords();
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors);
	public void addAuthor(Author author);
	public Book getBook(String isbn);
	public LibraryMember getMember(String memberId);
	public List<Author> getAllAuthors();
	public List<LibraryMember> getAllMembers();
	public List<Book> getAllBooks();
}
