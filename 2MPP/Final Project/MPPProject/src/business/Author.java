package business;

import java.io.Serializable;

final public class Author extends Person implements Serializable {
    private String authorId;

    public String getAuthorId() {
        return authorId;
    }

    public Author(
            String authorId,
            String firstName,
            String lastName,
            String phone,
            Address address
    ) {
        super(firstName, lastName, phone, address);
        this.authorId = authorId;
    }

    private static final long serialVersionUID = 7508481940058530471L;
}
