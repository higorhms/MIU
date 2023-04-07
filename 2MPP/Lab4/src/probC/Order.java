package probC;

import java.util.Calendar;
import java.util.Date;

public class Order {

    static int ORDER_NUMBER = 0;
    private int orderNo;
    private Date orderDate;
    private double orderAmount;

    private Commissioned commissioned;

    public Order(double orderAmount, Commissioned commissioned){
        this.orderAmount = orderAmount;
        this.commissioned = commissioned;
        orderNo = ORDER_NUMBER;
        this.orderDate = new Date();
        ORDER_NUMBER++;
    }

    public int getOrderMonth() {
        return orderDate.getMonth() + 1;
    }

    public int getOrderYear(){
        Calendar instance = Calendar.getInstance();
        instance.setTime(this.orderDate);
        return instance.get(Calendar.YEAR);
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}
