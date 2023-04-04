public class TheClass {
    private int value =5;
    public int getValue() {
        return value;
    }
    private static TheSubclass clsub;
    public TheClass() {
    }
    public class TheInnerClass {
        public int evaluate() {
            return value;
        }
    }
    void run() {
        TheClass.TheInnerClass inner =
                clsub.new TheSubInner();
        System.out.println(inner.evaluate());
    }
    public static void main(String[] args){
        clsub = new TheSubclass();
        clsub.run();
    }
}
class TheSubclass extends TheClass {
    private int value = getValue()+1;
    public class TheSubInner extends TheClass.TheInnerClass {
        public int evaluate() {
            return super.evaluate()+value;
        }
    }
    TheSubclass() {}
}