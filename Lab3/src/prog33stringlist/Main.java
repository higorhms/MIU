package prog33stringlist;

public class Main {

    public static void main(String[] args) {
        MyStringList l = new MyStringList();
        l.add("Bob");
        l.add("Steve");
        l.add("Susan");
        l.add("Mark");
        l.add("Dave");
        System.out.println("The list of size "+l.size()+" is "+l);
        l.remove("Mark");
        l.remove("Bob");
        System.out.println("The list of size "+l.size()+" is "+l);
        l.insert("Richard",3);
        System.out.println("The list of size "+l.size()+" after inserting Richard into pos 3 is "+l);
        l.insert("Tonya",0);
        System.out.println("The list of size "+l.size()+" after inserting Tonya into pos 0 is "+l);
    }
}
