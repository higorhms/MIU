package prob2;

public class Circle implements Shape{
    private final double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double computeArea(){
        return Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}
