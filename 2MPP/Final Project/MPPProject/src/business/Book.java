package business;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

final public class Book implements Serializable {
    private static final long serialVersionUID = 6110690276685962829L;
    private BookCopy[] copies;
    private String isbn;
    private String title;
    private int maxCheckoutLength;

    public Book(String isbn, String title, int maxCheckoutLength) {
        this.isbn = isbn;
        this.title = title;
        this.maxCheckoutLength = maxCheckoutLength;
        copies = new BookCopy[]{new BookCopy(this, 1, true)};
    }

    public void addCopy() {
        BookCopy[] newArr = new BookCopy[copies.length + 1];
        System.arraycopy(copies, 0, newArr, 0, copies.length);
        newArr[copies.length] = new BookCopy(this, copies.length + 1, true);
        copies = newArr;
    }


    @Override
    public boolean equals(Object ob) {
        if (ob == null) return false;
        if (ob.getClass() != getClass()) return false;
        Book b = (Book) ob;
        return b.isbn.equals(isbn);
    }


    public boolean isAvailable() {
        if (copies == null) {
            return false;
        }
        return Arrays.stream(copies)
                .map(l -> l.isAvailable())
                .reduce(false, (x, y) -> x || y);
    }

    @Override
    public String toString() {
        return "isbn: " + isbn + ", maxLength: " + maxCheckoutLength + ", available: " + isAvailable();
    }

    public String getTitle() {
        return title;
    }

    public BookCopy[] getCopies() {
        return copies;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getMaxCheckoutLength() {
        return maxCheckoutLength;
    }
}
