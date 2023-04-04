package prog34figures;

public class Triangle {
    private double base;
    private double height;

    public Triangle(double base , double height){
        this.base = base;
        this.height = height;
    }
    public double computeArea(){
        return 0.5 * base * height;
    }

    public double getBase(){
        return this.base;
    }

    public double getHeight(){
        return this.height;
    }
}
