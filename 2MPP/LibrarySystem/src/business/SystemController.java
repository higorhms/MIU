package business;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import librarysystem.LibrarySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemController implements ControllerInterface {
    public static ControllerInterface instance;
    public static Auth currentAuth = null;
    private SystemController() {
    }

    public static ControllerInterface getInstance() {
        if (instance == null) instance = new SystemController();
        return instance;
    }

    @Override
    public void login(String id, String password) throws LoginException {
        DataAccess da = DataAccessFacade.getInstance();
        HashMap<String, User> map = da.readUserMap();
        System.out.println(map);
        if (!map.containsKey(id)) {
            throw new LoginException("ID " + id + " not found");
        }
        String passwordFound = map.get(id).getPassword();
        if (!passwordFound.equals(password)) {
            throw new LoginException("Incorrect password ");
        }
        currentAuth = map.get(id).getAuthorization();
        LibrarySystem.INSTANCE.updateMenu();
        LibrarySystem.BackToMain();
    }

    @Override
    public List<String> allMemberIds() {
        DataAccess da = DataAccessFacade.getInstance();
        List<String> retval = new ArrayList<>();
        retval.addAll(da.readMemberMap().keySet());
        return retval;
    }

    @Override
    public List<String> allBookIds() {
        DataAccess da = DataAccessFacade.getInstance();
        List<String> retval = new ArrayList<>();
        retval.addAll(da.readBooksMap().keySet());
        return retval;
    }

    @Override
    public void addNewMember(String id, String firstName, String lastName, String telNumber, Address add) {
        CheckoutRecord record = new CheckoutRecord();
        LibraryMember member = new LibraryMember(id, firstName, lastName, telNumber, add, record);
        DataAccessFacade da = DataAccessFacade.getInstance();
        da.saveNewMember(member);
    }

    @Override
    public Book addNewBookCopy(String isbn) {
        DataAccessFacade da = DataAccessFacade.getInstance();
        Book book = da.searchBook(isbn);
        if (book != null)
            book.addCopy();
        return book;
    }

    public Book getBook(String isbn) {
        DataAccessFacade dataAccessFacade = DataAccessFacade.getInstance();
        HashMap<String, Book> booksMap = dataAccessFacade.readBooksMap();
        Book book = booksMap.get(isbn);
        return book;
    }

    @Override
    public void checkoutBook(String memberId, String isbn) {
        DataAccessFacade dataAccessFacade = DataAccessFacade.getInstance();
        HashMap<String, Book> booksMap = dataAccessFacade.readBooksMap();
        Book book = booksMap.get(isbn);
        BookCopy bookCopy = book.getNextAvailableCopy();
        bookCopy.changeAvailability();
        CheckoutRecord.entries.add(new CheckoutRecordEntry(isbn, memberId));
    }

    @Override
    public boolean isAValidMember(String id) {
        return allMemberIds().contains(id);
    }
}
