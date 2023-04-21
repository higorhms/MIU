package part1.prob1.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingAtLeastTwoCopies());
		System.out.println(allHavingMultipleAuthors());
	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		//implement
		List<String> memberIds = members.stream()
						.filter(e -> e.getAddress().getZip().contains("3"))
						.map(LibraryMember::getMemberId) //emps -> emps.getMemberId()
						.collect(Collectors.toList());
		return memberIds;
		
	}
	//Returns a list of all isbns of books having at least two copies
	public static List<String> allHavingAtLeastTwoCopies() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		//implement
		List<String> isbns = books.stream()
				.filter(b -> b.getCopyNums().size() > 2)
				.map(isbn -> isbn.getIsbn()) // Book::getIsbn
				.collect(Collectors.toList());
		return isbns;
		
	}

	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		//implement
		books.stream()
				.filter(numBooks -> numBooks.getAuthors().size() > 2)
				.map(Book::getIsbn) // b -> b.getIsbn()
				.collect(Collectors.toList());
		return null;
		
		}

}
