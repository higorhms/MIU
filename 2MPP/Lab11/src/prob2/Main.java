package prob2;

import java.util.Arrays;
import java.util.List;

public class Main {
    static <T> T secondSmallest(List<T> list) {
        return list.stream().sorted().skip(1).findFirst().get();
    }

    public static void main(String[] args) {
        System.out.println(secondSmallest(Arrays.asList(1, 2, 3, 4)));
        System.out.println(secondSmallest(Arrays.asList(1.0, 2.0, 3.0, 4.7)));
        System.out.println(secondSmallest(Arrays.asList("Amin", "", "hi", "Jack")));
    }
}