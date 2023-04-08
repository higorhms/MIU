package prob2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shape s1 = new Triangle(9,12);
        Shape s2 = new Triangle(6,9);
        Shape s3 = new Triangle(3,6);
        Shape s4 = new Rectangle(9, 12);
        Shape s5 = new Rectangle(6,9);
        Shape s6 = new Rectangle(3,6);
        Shape s7 = new Circle(3);
        Shape s8 = new Circle(6);
        Shape s9 = new Circle(9);
        List<Shape> shapes = new ArrayList<Shape>();

        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);
        shapes.add(s4);
        shapes.add(s5);
        shapes.add(s6);
        shapes.add(s7);
        shapes.add(s8);
        shapes.add(s9);

        double sumOfAreas = 0;

        for(int i = 0; i < shapes.size(); i++){
            Shape current = shapes.get(i);
            System.out.println(String.format("%s Area: %.2f", current.getClass().getSimpleName(), current.computeArea()));
            sumOfAreas += current.computeArea();
        }

        System.out.println("---------");

        System.out.println(String.format("Sum of areas: %.2f", sumOfAreas));
    }
}
