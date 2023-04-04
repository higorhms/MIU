package prog51singleton;

public class MySingleton {
    private static MySingleton instance = null;

    private MySingleton(){};

    public static MySingleton getInstance(){
        if(instance != null) return instance;

        instance = new MySingleton();

        return instance;
    }

}
