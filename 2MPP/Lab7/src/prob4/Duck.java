package prob4;

abstract public class Duck implements Fly, Quack {
	abstract public void display();
	
	public void swim() {
		System.out.println("  swimming");
	}
	
}
