package prob4;

public interface CannotQuack extends Quack {
	default void quack() {
		System.out.println("  cannot quack");
	}
}
