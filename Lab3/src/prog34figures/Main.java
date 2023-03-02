package prog34figures;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                String.format(
                        "Area of Triangle is: %.2f\n" +
                        "Area of Rectangle is: %.2f\n" +
                        "Area of Circle is: %.2f\n",
                        new Triangle(10, 10).computeArea(),
                        new Rectangle(9, 3).computeArea(),
                        new Circle(5).computeArea()
                )
        );
    }
}
