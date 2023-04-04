import prob2A.Student;
import prob2B.Order;
import prob2B.OrderLine;

public class Main {

    public static void main(String[] args) {
        // new Student and GradeReport
        System.out.println(new Student("Higor"));

        // Not Possible because the constructor is package private
        // System.out.println(new GradeReport());

        // new Order with OrderLine
        System.out.println(new Order(001));

        // Not Possible because the constructor is package private
        //  System.out.println(new OrderLine());
    }
}
