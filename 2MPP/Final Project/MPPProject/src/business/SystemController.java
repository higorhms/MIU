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
	public void addCopyOfBook(String isbn) throws SystemException {
		IDataAccess da = new DataAccessFacade();
		HashMap<String,Book> bookMap = da.readBooksMap();
		if(bookMap==null) {
			throw new SystemException("System has no books!, Add a book first");
		}
		Book book = bookMap.get(isbn);
		if (book==null) {
			throw new SystemException(isbn + " book not found in the system");
		}
		book.addCopy();
		da.saveBookMap(bookMap);
	}
	@Override
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors) {
		IDataAccess da = new DataAccessFacade();
		da.saveNewBook(new Book(isbn,title,maxCheckoutLength));
	}

	@Override
	public void addAuthor(Author author) {
		IDataAccess da = new DataAccessFacade();
		da.saveNewAuthor(author);
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
