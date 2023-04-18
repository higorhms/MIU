package prob4;

public interface CannotFly extends Fly {
	default void fly() {
		System.out.println("  cannot fly");
	}
}
