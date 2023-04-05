package prob4;

public class Condo extends Property{
    private final double CONDO_RENT = 400;
    private int numberOfFloors;

    public Condo(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public double computeRent() {
        return CONDO_RENT * this.numberOfFloors;
    }
}
