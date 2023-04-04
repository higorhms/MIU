package prog91mystack;

public class MyStack {
    private MyStringLinkedList list;

    public MyStack() {
        list = new MyStringLinkedList();
    }

    public String pop() {
        String toRemove = list.get(0);
        list.remove(toRemove);
        return toRemove;
    }

    public String peek() {
        return list.get(0).intern();
    }

    public void push(String s) {
        list.add(s);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("Bob");
        stack.push("Harry");
        stack.push("Alice");
        System.out.println("List before: " + stack.list + " size: " + stack.list.size());
        System.out.println("Popping…" + stack.pop());
        System.out.println("Peeking…." + stack.peek());
        System.out.println("Popping…" + stack.pop());
        System.out.println("List now: " + stack.list + " size: " + stack.list.size());
    }
}
