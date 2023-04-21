package part2.prob10b;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStream {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");

        System.out.println(Arrays.toString(stringStream.toArray()).replace("[", "").replace("]", ""));
    }
}
