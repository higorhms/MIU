package prog45closedcurve3;

public interface Polygon {
    public double[] getArrayOfSides();
    static double sum(double[] arr){
        double sum = 0;

        for(double value : arr){
            sum += value;
        }

        return sum;
    }

    default double computePerimeter() {
        double[] aux = this.getArrayOfSides();

        double sum = 0;

        for(double value : aux){
            sum += value;
        }

        return sum;
    }
}
