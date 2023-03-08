package prog51singleton;

public class Main {

    public static void main(String[] args) {
        System.out.println(MySingleton.getInstance());
        System.out.println(MySingleton.getInstance());
        System.out.println(MySingleton.getInstance());
        System.out.println(MySingleton.getInstance());
    }
}
