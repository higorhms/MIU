package prob4;

public class RedheadDuck extends Duck implements Quack, Fly {
	@Override
	public void display() {
		System.out.println("  displaying");
	}
}