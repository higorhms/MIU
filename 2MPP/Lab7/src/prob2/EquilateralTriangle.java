package prob2;

public class EquilateralTriangle implements Polygon{
    private final double side;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    @Override
    public double[] getSides() {
        return new double[] {side,side,side};
    }

    public double getSide() {
        return side;
    }
}
