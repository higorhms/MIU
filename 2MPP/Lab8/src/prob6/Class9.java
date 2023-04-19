package prob6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Class9 {
    public static void main(String[] args) {
        // stream int example
        List<Integer> ints = Arrays.asList(3, 5, 6, 7, 8);
        List<int[]> intArrs = ints.stream().map(int[]::new).collect(Collectors.toList());

        for (int[] arr : intArrs) {
            System.out.println(Arrays.toString(arr));
        }
    }
}