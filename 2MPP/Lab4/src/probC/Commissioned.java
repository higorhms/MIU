package probC;

import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee{
    private double comission;
    private double baseSalary;

    private List<Order> orderList = new ArrayList<Order>();

    public Commissioned(double comission, double baseSalary){
        this.comission = comission;
        this.baseSalary = baseSalary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double totalComission = 0;
        for(int i = 0; i < this.orderList.size(); i++){
            if(orderList.get(i).getOrderMonth() == month && orderList.get(i).getOrderYear() == year){
                totalComission +=  orderList.get(i).getOrderAmount() * this.comission;
            }
        }

        return totalComission + baseSalary;
    }

    public void addOrder(Order o){
        this.orderList.add(o);
    }
}
