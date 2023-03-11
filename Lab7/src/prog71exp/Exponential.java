package prog71exp;

public class Exponential {
    public double power(double x, int n){
        if(n == 1) return x;

        return power(x, n - 1) * x;
    }

    public static void main(String[] args) {
        System.out.println(new Exponential().power(2,10));
        System.out.println(Math.pow(2, 10));
    }
}
