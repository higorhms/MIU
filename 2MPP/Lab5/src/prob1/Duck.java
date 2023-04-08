package prob1;

public abstract class Duck implements QuackBehavior, FlyBehavior{
    @Override
    public void fly() {
        System.out.println("flying with wings");
    }

    @Override
    public void quack() {
        System.out.println("quacking");
    }

    public void display() {
        System.out.println("display");
    }

    public void swim() {
        System.out.println("swimming");
    }
}
