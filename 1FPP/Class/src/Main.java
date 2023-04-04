public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("Higor");
        stack.push("Pedro");
        System.out.println(stack.peek());
        stack.push("Bia");
        stack.push("Linda");
        System.out.println(stack.pop());
        stack.push("Jayme");

        System.out.println(stack);
    }
}
