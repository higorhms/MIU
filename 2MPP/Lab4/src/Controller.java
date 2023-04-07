import probC.*;

public class Controller {
    public static void main(String[] args) {

        Employee emp1 = new Hourly(100, 40);
        Employee emp2 = new Salaried(1900);
        Commissioned emp3 = new Commissioned(0.10, 1000);
        Order order1 = new Order(1000, emp3);
        Order order2 = new Order(2000, emp3);
        emp3.addOrder(order1);
        emp3.addOrder(order2);


        System.out.println("Employee 1");
        System.out.println(emp1.calcCompensation(4, 2023));
        System.out.println();
        System.out.println("Employee 2");
        System.out.println(emp2.calcCompensation(4, 2023));
        System.out.println();
        System.out.println("Employee 3");
        System.out.println(emp3.calcCompensation(4, 2023));
        System.out.println();
    }
}