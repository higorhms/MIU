package prob4;

public class MallardDuck extends Duck implements Fly, Quack {
	@Override
	public void display() {
		System.out.println("  displaying");
	}
}
