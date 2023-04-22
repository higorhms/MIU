package prob2;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {

    private List<CheckoutRecordEntry> checkoutEntryList = new ArrayList<CheckoutRecordEntry>();

    public List<CheckoutRecordEntry> getCheckoutEntryList() {
        return checkoutEntryList;
    }

    public void addCheckoutEntry(CheckoutRecordEntry record){
        this.checkoutEntryList.add(record);
    }
}
