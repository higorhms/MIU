package prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {
        Filter filter = new Filter();
        List<String> list = Arrays.asList("john", "mary", "oaks", "thomas", "kevin");
        System.out.println(filter.countWords(list, 'o', 'y', 4));
    }

    public int countWords(List<String> words, char c, char d, int len) {

        Stream<String> filteredWords = words.stream()
                .filter(word -> contains(word, c) && !contains(word, d) && word.length() == len);

        long count = filteredWords.count();


        return (int) count;
    }

    public boolean contains(String word, char c) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c)
                return true;
        }
        return false;
    }

}
