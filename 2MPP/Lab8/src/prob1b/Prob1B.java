package prob1b;

import java.util.function.Supplier;

class Question1 {
	public static void main(String[] args) {
		Supplier<Double> random = () -> Math.random();
		System.out.println(random.get());
	}
}

class Question2 {
	public static void main(String[] args) {
		Supplier<Double> num = Math::random;
		System.out.println(num.get());
	}
}

class Question3{

	class MySupplier implements Supplier<Double> {
		@Override
		public Double get() {
			return Math.random();
		}
	}

	public static void main(String[] args) {
		System.out.println(new Question3().new MySupplier().get());
	}
}
