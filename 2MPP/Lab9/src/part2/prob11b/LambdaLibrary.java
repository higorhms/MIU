package part2.prob11b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;


public class LambdaLibrary {
    public static final Function<List<Employee>, String> employeesThatEarnMoreThan100kAndLastNameStartsGreaterThanM
            = (list) -> Arrays.toString(list.stream()
            .filter(e -> e.getSalary() > 100000)
            .filter(e -> e.getLastName().charAt(0) > 'M')
            .map(e -> e.getFirstName() + " " + e.getLastName())
            .sorted(Comparator.naturalOrder()).toArray()).replace("[", "").replace("]", "");
}
