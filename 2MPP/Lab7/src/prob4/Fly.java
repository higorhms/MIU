package prob4;

public interface Fly {
	default void fly() {
		System.out.println("  flying");
	}
}
