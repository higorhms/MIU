package prob2;

public class Rectangle implements Shape{
    private final double height;
    private final double width;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double computeArea(){
        return width * height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
