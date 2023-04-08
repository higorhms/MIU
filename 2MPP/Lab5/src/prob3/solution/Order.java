package prob3.solution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate orderDate;
    private List<Item> items;

    //use a factory method
    private Order(LocalDate orderDate) {
        this.orderDate = orderDate;
        items = new ArrayList<Item>();
    }

    static Order newOrder(Customer customer, LocalDate date) {
        if (customer == null) throw new NullPointerException("Null customer");
        Order ord = new Order(date);
        customer.addOrder(ord);
        return ord;
    }

    public void addItem(String name) {
        items.add(new Item(name));
    }

    @Override
    public String toString() {
        return orderDate + ": " +
                items.toString();
    }
}
