public class A {
    String name;
    A(String name) {
        this.name = "Hello " + name;
    }
    public static void main(String[] args) {
        A h = new A("World");
        System.out.println(h.name);
    }
}