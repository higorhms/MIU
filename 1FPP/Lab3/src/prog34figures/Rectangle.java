package prog34figures;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double computeArea(){
        return this.width * this.height;
    }

    public double getWidth() { return this.width; }

    public double getHeight(){ return this.height; }

}
