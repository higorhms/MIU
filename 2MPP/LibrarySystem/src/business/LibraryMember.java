package business;

import java.io.Serializable;

final public class LibraryMember extends Person implements Serializable {
    
    private String memberId;

    private CheckoutRecord record;

    public CheckoutRecord getRecord() {
        return record;
    }

    public LibraryMember(String memberId, String fname, String lname, String tel, Address add, CheckoutRecord record) {
        super(fname, lname, tel, add);
        this.memberId = memberId;
        this.record = record;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() +
                ", " + getTelephone() + " " + getAddress();
    }

    private static final long serialVersionUID = -2226197306790714013L;
}
