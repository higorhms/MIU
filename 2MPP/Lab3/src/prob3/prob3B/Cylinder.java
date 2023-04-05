package prob3.prob3B;

public class Cylinder {
    private Circle base;
    private double height;

    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double computeArea() {
        return base.computeArea() * height;
    }

    public double getRadius(){
        return this.base.getRadius();
    }
}

