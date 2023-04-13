package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataAccess.Auth;
import dataAccess.IDataAccess;
import dataAccess.DataAccessFacade;
import dataAccess.User;

public class SystemController implements IController {
public static Auth currentAuth = null;
	public void login(String id, String password) throws LoginException {
		IDataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(map==null) {
			throw new LoginException("System has no users!, Add a User");
		}
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
	}
	@Override
	public List<String> allMemberIds() {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,LibraryMember> mems = da.readMemberMap();
		if (mems==null) return null;
		List<String> retval = new ArrayList<>();
		retval.addAll(mems.keySet());
		return retval;
	}
	@Override
	public List<String> allBookIds() {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,Book> bookmap = da.readBooksMap();
		if (bookmap==null) return null;
		List<String> retval = new ArrayList<>();
		retval.addAll(bookmap.keySet());
		return retval;
	}
	@Override
	public void addLibraryMember(LibraryMember member) {
		IDataAccess da = new DataAccessFacade();
		da.saveNewMember(member);
	}
	@Override
	public void addCheckoutRecordEntry(String memberId, String isbn) throws LibrarySystemException {
		IDataAccess da = new DataAccessFacade();
		
		HashMap<String,LibraryMember> mems = da.readMemberMap();
		if (mems==null) {
			throw new LibrarySystemException("System has no members!, Add a member first");
		}
		LibraryMember member=mems.get(memberId);
		if(member==null) {
			throw new LibrarySystemException(memberId + " member not found in the system");
		}		
		HashMap<String,Book> bookmap = da.readBooksMap();
		if(bookmap==null) {
			throw new LibrarySystemException("System has no books!, Add a book first");
		}
		Book book=bookmap.get(isbn);
		if (book==null) {
			throw new LibrarySystemException(isbn + " book not found in the system");
		}

		BookCopy bookcopy=book.getNextAvailableCopy();
		if(bookcopy==null) {
			throw new LibrarySystemException(isbn + " book is not available currently");
		}
		
		CheckoutRecord checkoutRecord=member.getCheckoutRecord();
		checkoutRecord.new CheckoutRecordEntry(bookcopy);

		da.saveMemberMap(mems);
		da.saveBookMap(bookmap);
	}
	@Override
	public void addCopyOfBook(String isbn) throws LibrarySystemException {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,Book> bookmap = da.readBooksMap();
		if(bookmap==null) {
			throw new LibrarySystemException("System has no books!, Add a book first");
		}
		Book book=bookmap.get(isbn);
		if (book==null) {
			throw new LibrarySystemException(isbn + " book not found in the system");
		}
		book.addCopy();
		da.saveBookMap(bookmap);
	}
	@Override
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors) {
		IDataAccess da = new DataAccessFacade();
		da.saveNewBook(new Book(isbn,title,maxCheckoutLength,authors));
	}

	@Override
	public void addAuthor(Author author) {
		IDataAccess da = new DataAccessFacade();
		da.saveNewAuthor(author);
		
	}
	
	@Override
	public String printCheckoutRecord(String memberId) {
		LibraryMember member=getMember(memberId);
		return member.getCheckoutRecord().toString();
	}

	@Override
	public Book getBook(String isbn) {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,Book> bookmap = da.readBooksMap();
		if(bookmap==null) return null;
		return bookmap.get(isbn);
	}
	@Override
	public LibraryMember getMember(String memberId) {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,LibraryMember> mems = da.readMemberMap();
		if (mems==null) return null;
		return mems.get(memberId);
	}

	
	@Override
	public List<Author> getAllAuthors() {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,Author> authors = da.readAuthorMap();
		if (authors==null) return null;
		return new ArrayList<>(authors.values());
	}
	
	@Override
	public List<LibraryMember> getAllMembers() {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,LibraryMember> mems = da.readMemberMap();
		if (mems==null) return null;
		return new ArrayList<>(mems.values());
	}
	@Override
	public List<Book> getAllBooks() {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,Book> books = da.readBooksMap();
		if (books==null) return null;
		return new ArrayList<>(books.values());
	}
	@Override
	public void UpdateLibraryMember(String memberId, String fname, String lname, String tel, String street, String city,
			String state, String zip) throws LibrarySystemException {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,LibraryMember> mems = da.readMemberMap();
		if (mems==null) {
			throw new LibrarySystemException("System has no members!, Add a member first");
		}
		LibraryMember member=mems.get(memberId);
		if(member==null) {
			throw new LibrarySystemException(memberId + " member not found in the system");
		}		
		Address address=new Address(street, city, state, zip);
		member.setAddress(address);
		member.setFirstName(fname);
		member.setLastName(lname);
		member.setTelephone(tel);
		
		da.saveMemberMap(mems);
	}
	
	public List<CheckoutRecordNew> getCheckoutRecords() {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,CheckoutRecordNew> checkoutMap = da.readCheckoutMap();
		if (checkoutMap==null) return null;
		
		return new ArrayList<>(checkoutMap.values());
		
	}

	public void addCheckoutRecord(CheckoutRecordNew checkoutRecord) {
		IDataAccess da = new DataAccessFacade();
		da.addCheckoutRecord(checkoutRecord);
		
	}

}
