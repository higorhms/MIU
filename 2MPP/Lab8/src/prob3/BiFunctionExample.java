package prob3;

import java.util.function.BiFunction;

public class BiFunctionExample {
	public static void main(String[] args) {
		BiFunction<Double, Double, Double> lambda = (x, y) -> Math.pow(x,y);
		System.out.println(lambda.apply(2.0,3.0));

		BiFunction<Double, Double, Double> function = Math::pow;
		System.out.println(function.apply(2.0, 3.0));
	}
}