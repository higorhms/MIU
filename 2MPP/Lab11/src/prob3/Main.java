package prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;


public class Main {

    //simple version
    public static boolean contains1(List<String> list, String s) {
        for (String x : list) {
            if (x == null && s == null) return true;
            if (s == null || x == null) continue;
            if (x.equals(s)) return true;
        }
        return false;
    }


    //your generalization -- should work with lists of
    //Employees, Accounts. You may not override equals
    //in the data-holder classes (like Employee, Account, etc)
    //so you need to find another way to deal with the fact
    //that these classes do not have their own equals methods.

    public static <T> boolean contains2(List<T> list, T s, BiPredicate<T, T> function) {
        return list.stream().anyMatch(item -> function.test(item, s));
    }

    public static void test1() {
        List<String> list = Arrays.asList("Bob", "Joe", "Tom");
        boolean result = Main.contains1(list, "Tom");
        System.out.println(result);
        System.out.println(Main.contains2(list, "Tom", (a, b) -> a.equals(b)));
    }

    public static void test2() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1003, "Tom", 60000));
        list.add(new Employee(1002, "Harry", 70000));
        list.add(new Employee(1001, "Joe", 50000));
        System.out.println(Main.contains2(list, new Employee(1001, "Joe", 50000), (a, b) -> a.getName().equals(b.getName())));
    }

    public static void test3() {
        List<Manager> list = new ArrayList<>();
        list.add(new Manager(1003, "Tom", 60000, 700));
        list.add(new Manager(1002, "Harry", 70000, 400));
        list.add(new Manager(1001, "Joe", 50000, 500));
        System.out.println(
                Main.contains2(
                        list,
                        new Manager(1001, "Joe", 50000, 500),
                        (a, b) -> a.getName().equals(b.getName())
                )
        );
    }

    public static void test4() {
        List<CheckingAccount> list = new ArrayList<>();
        list.add(new CheckingAccount(1001, 25.00));
        list.add(new CheckingAccount(1002, 35.00));
        list.add(new CheckingAccount(1003, 125.00));
        System.out.println(
                Main.contains2(
                        list,
                        new CheckingAccount(1003, 125.00),
                        (a, b) -> a.getAcctId() == b.getAcctId()
                )
        );
    }


    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
    }
}
