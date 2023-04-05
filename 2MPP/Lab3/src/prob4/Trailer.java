package prob4;

public class Trailer extends Property{
    private final double TRAILER_RENT = 500;

    @Override
    public double computeRent() {
        return TRAILER_RENT;
    }
}
