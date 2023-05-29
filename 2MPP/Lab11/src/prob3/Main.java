package prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;


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




        // QUIZ - 04/25/2023 ANSWERS

        // Question 1
        Function<String, String> lambda = (String s1) -> s1.toUpperCase();
        Function<String, String> methodReference = String::toUpperCase;
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        // Question 2
        Consumer<Employee> setNameLambda = (Employee e) -> e.setName("default");
//        Consumer<Employee> setNameMethodReference = Employee::setName; // NOT POSSIBLE
        Consumer<Employee> annonymousSetDefaultName = new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                employee.setName("default");
            }
        };

        // Question 3
        BiConsumer<Employee, String> setStringName = (Employee e, String name) -> e.setName(name);
        BiConsumer<Employee, String> setStringNameMReference = Employee::setName;
        BiConsumer<Employee, String> setStringNameAClass = new BiConsumer<Employee, String>() {
            @Override
            public void accept(Employee employee, String s) {
                employee.setName(s);
            }
        };


        // Question 4
        BiFunction<Integer, Integer, Double> lamdaMathPow = (Integer i1, Integer i2) -> Math.pow(i1, i2);
        BiFunction<Integer, Integer, Double> methodReferenceMathPow = Math::pow;
        BiFunction<Integer, Integer, Double> annonymous = new BiFunction<Integer, Integer, Double>() {
            @Override
            public Double apply(Integer integer, Integer integer2) {
                return Math.pow(integer, integer2);
            }
        };

        // Question 5 FIRST POSSIBILITY
        Comparator<String> comparator1 = (String s1, String s2) -> s1.compareTo(s2); // FIRST POSSIBILITY
        Comparator<String> stringComparator = String::compareTo;
        Comparator<String> annonymousComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        // Question 5 SECOND POSSIBILITY
        BiFunction<String, String, Integer> comparator2 = (String s1, String s2) -> s1.compareTo(s2); // SECOND POSSIBILITY
        BiFunction<String, String, Integer> methodReferenceComparator2 = String::compareTo;
        BiFunction<String, String, Integer> annonymousComparator2 = new BiFunction<String, String, Integer>() {
            @Override
            public Integer apply(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };


        // Question 6 FIRST POSSIBILITY
        EmployeeComparator comp = new EmployeeComparator();
        Comparator<Employee> employeeComparator = (Employee e1, Employee e2) -> comp.compare(e1, e2);
        Comparator<Employee> employeeComparatorMethodReference = comp::compare;
        Comparator<Employee> annonymouys = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return comp.compare(o1, o2);
            }
        };


        // Question 6 SECOND POSSIBILITY
        EmployeeComparator comp1 = new EmployeeComparator();
        BiFunction<Employee, Employee, Integer> employeeComparator1 = (Employee e1, Employee e2) -> comp1.compare(e1, e2);
        BiFunction<Employee, Employee, Integer> employeeComparatorMethodReference1 = comp1::compare;
        BiFunction<Employee, Employee, Integer> annonymouys1 = new BiFunction<>() {
            @Override
            public Integer apply(Employee employee, Employee employee2) {
                return comp1.compare(employee, employee2);

            }
        };
    }
}
