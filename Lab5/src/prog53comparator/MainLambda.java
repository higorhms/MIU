package prog53comparator;

import java.util.Arrays;
import java.util.Comparator;

public class MainLambda {

    public static void main(String[] args) {
        StringSort ss = new StringSort((String o1, String o2) -> o2.length() - o1.length());

        String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };

        ss.stringSort(testStrings);

        System.out.println(Arrays.asList(testStrings));
    }
}
