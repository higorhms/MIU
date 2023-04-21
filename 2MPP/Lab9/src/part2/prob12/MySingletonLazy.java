package part2.prob12;

import java.util.Optional;

public class MySingletonLazy {

    private static MySingletonLazy instance = null;

    private MySingletonLazy() {}

    public static MySingletonLazy getInstance() {
        return Optional.ofNullable(instance).orElse(instance = new MySingletonLazy());
    }

    public static void main(String[] args) {
        System.out.println(MySingletonLazy.getInstance() == MySingletonLazy.getInstance());
    }
}