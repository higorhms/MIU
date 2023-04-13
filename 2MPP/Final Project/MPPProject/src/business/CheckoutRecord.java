package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final public class CheckoutRecord implements Serializable {

    private static final long serialVersionUID = -7607095907637905271L;
    private LibraryMember owner;
    private List<CheckoutRecordEntry> entries;

    CheckoutRecord(LibraryMember owner) {
        this.owner = owner;
        entries = new ArrayList<>();
    }

    @Override
    public String toString() {
        String ret = "Member Id=" + owner.getMemberId() + "\n";
        for (CheckoutRecordEntry entry : entries) {
            ret += entry;
        }
        return ret;
    }

    final class CheckoutRecordEntry implements Serializable {

        private static final long serialVersionUID = -2572766210399733458L;

        private LocalDate checkoutDate;
        private LocalDate dueDate;
        private BookCopy bookCopy;

        CheckoutRecordEntry(BookCopy bookCopy) {
            this.bookCopy = bookCopy;
            checkoutDate = LocalDate.now();
            dueDate = checkoutDate.plusDays(bookCopy.getBook().getMaxCheckoutLength());
        }

        @Override
        public String toString() {
            return "[checkoutDate=" + checkoutDate + ", dueDate=" + dueDate + ", isbn="
                    + bookCopy.getBook().getIsbn() + ", CopyNumber=" + bookCopy.getCopyNum() + "]\n";
        }
    }
}
