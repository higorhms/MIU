public class Stack implements QueueOrStack{
    Node head;

    @Override
    public void push(String value) {
        Node toAdd = new Node(value, null);

        if(head == null){
            head = toAdd;
            return;
        }

        toAdd.next = head;
        head = toAdd;
    }

    @Override
    public Node pop() {
        Node toReturn = head;
        head = head.next;
        return toReturn;
    }

    @Override
    public Node peek() {
        return head;
    }


    @Override
    public String toString() {
        String output = "-----\n";
        Node aux = head;

        while (aux != null){
            if(aux.next == null){
                output += aux.data;
                break;
            }
            output += aux.data + " \n | \n";
            aux = aux.next;
        }

        return output;
    }
}
