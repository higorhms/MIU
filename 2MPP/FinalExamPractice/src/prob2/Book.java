package prob2;

public class Book extends LendingItem{
    private String isbn;
    private String title;
    private String authorFirstName;
    private String authorLastName;

    public Book(String isbn, String title, String authorFirstName, String authorLastName){
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Book incoming = (Book) obj;
        if(this.isbn == incoming.isbn) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.isbn.hashCode();
    }
}
