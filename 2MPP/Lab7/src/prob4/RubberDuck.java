package prob4;

public class RubberDuck extends Duck implements CannotQuack {
	@Override
	public void display() {
		System.out.println("  displaying");
	}
}
