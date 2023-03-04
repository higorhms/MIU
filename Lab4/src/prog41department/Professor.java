package prog41department;

public class Professor extends DeptEmployee{

    private int numberOfPublications;
    public Professor(String name, double salary, int day, int month, int year) {
        super(name, salary, day, month, year);
    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }

    public void setNumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }
}
