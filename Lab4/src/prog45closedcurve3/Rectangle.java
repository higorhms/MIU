package prog45closedcurve3;
public class Rectangle extends ClosedCurve implements Polygon {
    private double width;
    private double length;

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    @Override
    double computeArea() {
        return this.width * this.length;
    }

    @Override
    public double[] getArrayOfSides() {
        return new double[]{width, length, width, length};
    }
}
