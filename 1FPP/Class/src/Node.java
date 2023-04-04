public class Node implements Cloneable {

    String data;

    Node next;

    public Node(String data, Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data;
    }
}
