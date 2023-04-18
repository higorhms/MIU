package prob4;

public interface Quack {
	default void quack() {
		System.out.println("  quacking");
	}
}

