package prog44closedcurve2;

import prog44closedcurve2.Polygon;
public class Rectangle extends ClosedCurve implements Polygon {
    private final int RECTANGLE_SIDES = 4;
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
    public int getNumberOfSides() {
        return this.RECTANGLE_SIDES;
    }

    @Override
    public double computePerimeter() {
        return (width * 2) + (length * 2);
    }
}
