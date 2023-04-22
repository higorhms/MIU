package prob2;

import java.time.LocalDate;
import java.util.Date;

public class CheckoutRecordEntry {

    private LendingItem item;
    private LocalDate chDate;
    private LocalDate dueDate;
    private ItemType type;

    public CheckoutRecordEntry(LendingItem item, LocalDate chDate, LocalDate dueDate, ItemType type){
        this.item = item;
        this.chDate = chDate;
        this.dueDate = dueDate;
        this.type = type;
    }


    public LocalDate getCheckoutDate() {
        return chDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LendingItem getLendingItem() {
        return item;
    }

    public ItemType getLendingItemType() {
        return type;
    }
}
