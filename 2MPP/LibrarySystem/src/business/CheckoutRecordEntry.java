package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable {
    private LocalDate checkoutDate = LocalDate.now();
    private LocalDate dueDate;
    private String bookISBN;
    private String memberID;
    private BookCopy bookCopy;
    private CheckoutRecord record;

    public CheckoutRecordEntry(String bookISBN, String memberID) {
        super();
        this.bookISBN = bookISBN;
        this.memberID = memberID;
    }

    public String getBookTitle() {
        return bookCopy.getBook().getTitle();
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

    public String getISBN() {
        return bookISBN;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }
}
