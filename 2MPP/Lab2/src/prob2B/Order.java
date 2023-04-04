package prob2B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private int orderNum;
    private List<OrderLine> lines;
    public Order(int number){
        this.orderNum = number;
        this.lines = new ArrayList<OrderLine>();
    }

    @Override
    public String toString() {
        return String.format("{ \n" +
                "  orderNum: \"%s\",\n" +
                "  lines: %s,\n" +
                "}", this.orderNum, this.lines.toString());
    }
}
