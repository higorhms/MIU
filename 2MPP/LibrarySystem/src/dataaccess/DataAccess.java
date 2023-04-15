package dataaccess;

import business.Book;
import business.LibraryMember;

import java.util.HashMap;

public interface DataAccess {
    public HashMap<String, Book> readBooksMap();

    public HashMap<String, User> readUserMap();

    public HashMap<String, LibraryMember> readMemberMap();

    public void saveNewMember( String id,
                               String firstName,
                               String lastName,
                               String phoneNumber,
                               String street,
                               String city,
                               String state,
                               String zip
    );

    public Book searchBook(String isbn);

    public LibraryMember searchMember(String id);
}
