package prob1;

public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("displaying");
    }

    @Override
    public void fly() {
        System.out.println("cannot fly");
    }

    @Override
    public void quack() {
        System.out.println("squeaking");
    }
}
