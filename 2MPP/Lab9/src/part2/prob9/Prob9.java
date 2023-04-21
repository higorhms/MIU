package part2.prob9;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prob9 {
    private static int count = 1;

    public static void main(String[] args) {
        printSquares(4);
    }

    public static void printSquares(int num){

        System.out.println(Stream.iterate(1, n -> {
            ++count;
            int aux = count * count;
            return aux;
        }).limit(num).collect(Collectors.toList()));

    }
}
