package dataaccess;

import business.Book;
import business.LibraryMember;

import java.util.HashMap;

public interface DataAccess {
    public HashMap<String, Book> readBooksMap();

    public HashMap<String, User> readUserMap();

    public HashMap<String, LibraryMember> readMemberMap();

    public void saveNewMember(LibraryMember member);

    public Book searchBook(String isbn);

    public LibraryMember searchMember(String id);
}
