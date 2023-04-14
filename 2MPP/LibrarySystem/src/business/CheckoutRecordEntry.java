package business;

import dataaccess.DataAccessFacade;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable {
    private LocalDate checkoutDate = LocalDate.now();
    private LocalDate dueDate;
    private BookCopy bookCopy;
    private static String bookISBN;
    private CheckoutRecord record;
    private String memberID;


    public CheckoutRecordEntry(String bookISBN, String memberID) {
        super();
        this.bookISBN = bookISBN;
        this.memberID = memberID;
    }

    public CheckoutRecordEntry(LocalDate today, LocalDate dueDate2, BookCopy copy, CheckoutRecord record2) {
        // TODO Auto-generated constructor stub
    }

    public LocalDate getCheckoutDueDate() {
        DataAccessFacade books = DataAccessFacade.getInstance();
        Book book = books.readBooksMap().get(bookISBN);
        this.dueDate = checkoutDate.plusDays(book.getMaxCheckoutLength());
        return checkoutDate.plusDays(book.getMaxCheckoutLength());

    }

    public String getBookTitle() {
        DataAccessFacade books = DataAccessFacade.getInstance();
        Book book = books.readBooksMap().get(bookISBN);
        return book.getTitle();
    }

    public CheckoutRecord getRecord() {
        return record;
    }


    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public String getMemberId() {
        return memberID;
    }

    public static String getISBN() {
        return bookISBN;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }
}
