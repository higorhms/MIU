package prog51singleton;

public class Singleton {
    private static class MySingletonHolder {
        static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return MySingletonHolder.instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        printEachLetter("Higor");
    }

    public static void printEachLetter(String word){
        if(word.length() == 1){
            System.out.println(word);
        }else{
            String toPrint = word.substring(0, 1);
            System.out.println(toPrint);
            printEachLetter(word.substring(1, word.length()));
        }
    }
}
