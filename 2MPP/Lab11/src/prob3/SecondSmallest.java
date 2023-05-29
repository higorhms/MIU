package prob3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SecondSmallest {

    public static void main(String[] args) {
		System.out.println("No Stream");
        List<Integer> list = Arrays.asList(4, 2, 3, 6);
        System.out.println(secondSmallest2(list));

        List<Employee> list2 = Arrays.asList(new Employee(1, "joe", 10000), new Employee(2, "tom", 200000));
        System.out.println(secondSmallest2(list2));

        List<LocalDate> dates = Arrays.asList(LocalDate.of(1900, 1, 1), LocalDate.of(1950, 1, 1),
                LocalDate.of(1975, 1, 1), LocalDate.of(2000, 1, 1));
        System.out.println(secondSmallest3(dates));

        System.out.println();
		System.out.println("With Stream");

		Integer[] listS = new Integer[]{1, 2, 3, 4, 5};
		System.out.println(secondSmallest(listS));

		Employee[] listS1 = new Employee[]{new Employee(1, "joe", 10000), new Employee(2, "tom", 200000)};
		System.out.println(secondSmallest(listS1));

        Integer[] array2 = {1, 1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println(secondSmallest(array2));

        LocalDate[] array3 = {
                LocalDate.of(1900, 1, 1),
                LocalDate.of(1950, 1, 1),
                LocalDate.of(1975, 1, 1),
                LocalDate.of(2000, 1, 1)
        };
		System.out.println(secondSmallest(array3));

    }

    public static <T extends Comparable<T>> Optional<T> secondSmallestCGPT(T[] array) {
        if (array == null || array.length < 2) {
            return Optional.empty();
        }

        return Arrays.stream(array)
                .sorted(Comparator.naturalOrder())
                .distinct()
                .skip(1)
                .findFirst();
    }


    public static <T extends Comparable<T>> T secondSmallest(T[] list){
		return Arrays.asList(list).stream().sorted(Comparator.naturalOrder()).distinct().skip(1).findFirst().orElse(null);
	}

    public static <T extends Comparable<T>> T secondSmallest2(List<T> list) {
        T smallest = list.get(0);
        T secondSmallest = list.get(1);
        if (smallest.compareTo(secondSmallest) > 0) {
            T temp = smallest;
            smallest = secondSmallest;
            secondSmallest = temp;
        }
        for (int i = 2; i < list.size(); ++i) {
            T next = list.get(i);
            if (next.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = next;
            } else if (next.compareTo(secondSmallest) < 0) {
                secondSmallest = next;
            }

        }
        return secondSmallest;
    }

    public static <T extends Comparable<? super T>> T secondSmallest3(List<T> list) {
        T smallest = list.get(0);
        T secondSmallest = list.get(1);
        if (smallest.compareTo(secondSmallest) > 0) {
            T temp = smallest;
            smallest = secondSmallest;
            secondSmallest = temp;
        }
        for (int i = 2; i < list.size(); ++i) {
            T next = list.get(i);
            if (next.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = next;
            } else if (next.compareTo(secondSmallest) < 0) {
                secondSmallest = next;
            }

        }
        return secondSmallest;
    }

    /////////Using Comparators
    public static <T> T secondSmallest4(List<T> list, Comparator<T> comp) {
        T smallest = list.get(0);
        T secondSmallest = list.get(1);
        if (comp.compare(smallest, secondSmallest) > 0) {
            T temp = smallest;
            smallest = secondSmallest;
            secondSmallest = temp;
        }
        for (int i = 2; i < list.size(); ++i) {
            T next = list.get(i);
            if (comp.compare(next, smallest) < 0) {
                secondSmallest = smallest;
                smallest = next;
            } else if (comp.compare(next, secondSmallest) < 0) {
                secondSmallest = next;
            }

        }
        return secondSmallest;
    }


    public static <T> T secondSmallest5(List<? extends T> list, Comparator<? super T> comp) {
        T smallest = list.get(0);
        T secondSmallest = list.get(1);
        if (comp.compare(smallest, secondSmallest) > 0) {
            T temp = smallest;
            smallest = secondSmallest;
            secondSmallest = temp;
        }
        for (int i = 2; i < list.size(); ++i) {
            T next = list.get(i);
            if (comp.compare(next, smallest) < 0) {
                secondSmallest = smallest;
                smallest = next;
            } else if (comp.compare(next, secondSmallest) < 0) {
                secondSmallest = next;
            }

        }
        return secondSmallest;
    }
}
