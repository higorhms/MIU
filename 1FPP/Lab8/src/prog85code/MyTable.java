package prog85code;

public class MyTable {
    private Entry[] entries = new Entry[26];
    private int size = 0;

    public void add(char c, String s){
        entries[size] = new Entry(c,s);
        size++;
    }

    @Override
    public String toString() {
        String aux = "";
       for(int i=0; i<size; i++){
          aux += this.entries[i].toString() + "\n";
       }
       return aux;
    }

    public class Entry{
        char c;
        String s;

        public Entry(char c, String s){
            this.c = c;
            this.s = s;
        }

        @Override
        public String toString() {
            return c + "->" + s;
        }
    }


    public static void main(String[] args) {
        MyTable m = new MyTable();
        m.add('c', "Carro");
        m.add('h', "Higor");

        System.out.println(m);
    }
}
