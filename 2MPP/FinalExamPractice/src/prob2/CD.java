package prob2;

public class CD extends LendingItem{
    private String productId;
    private String title;
    private String company;

    public CD(String productId, String title, String company){
        this.productId = productId;
        this.title = title;
        this.company = company;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        CD incoming = (CD) obj;
        if(this.productId == incoming.productId) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.productId.hashCode();
    }
}
