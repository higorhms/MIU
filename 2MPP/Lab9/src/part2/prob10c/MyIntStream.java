package part2.prob10c;

import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MyIntStream {

    public static void main(String[] args) {
        Supplier<Stream<Integer>> integerStream = () -> Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println("Max: " + integerStream.get().max(Comparator.naturalOrder()).get());
        System.out.println("Min: " + integerStream.get().min(Comparator.naturalOrder()).get());
    }
}
