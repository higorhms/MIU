package prog10.employeebst;

import java.util.Comparator;

public class EmployeeBST {

    private class Node{
        private Employee data;

        private Node left;

        private Node right;

        public Node(Employee e, Node left, Node right){
            this.data = e;
            this.left = left;
            this.right = right;
        }
    }

    private Comparator comparator;
    private Node root;

    public EmployeeBST(Comparator c){
        this.comparator = c;
        root = null;
    }

    public void insert(Employee e){
        if(root == null){
            root = new Node(e, null, null);
            return;
        }

        Node auxRoot = root;
        boolean added = false;
        while(!added){
            boolean left = comparator.compare(e, auxRoot.data) < 0 ? true : false;

            if(left){
                if(auxRoot.left == null){
                    auxRoot.left = new Node(e, null, null);
                    added = true;
                }
                auxRoot = auxRoot.left;
            }


            if(!left){
                if(auxRoot.right == null){
                    auxRoot.right = new Node(e, null, null);
                    added = true;
                }
                auxRoot = auxRoot.right;
            }
        }
    }

    public void printTree() {
        if (root == null)
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private void printTree(Node t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.data);
            printTree(t.right);
        }
    }
}
