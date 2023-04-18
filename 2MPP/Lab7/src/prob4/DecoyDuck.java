package prob4;

public class DecoyDuck extends Duck implements CannotFly, CannotQuack {
	
	@Override
	public void display() {
		System.out.println("  displaying");
	}
}
