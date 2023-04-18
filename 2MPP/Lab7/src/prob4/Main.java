package prob4;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<Duck>();
		ducks.add(new MallardDuck());
		ducks.add(new RubberDuck());
		ducks.add(new RedheadDuck());
		ducks.add(new DecoyDuck());

		ducks.forEach(duck -> {
			System.out.println(duck.getClass().getSimpleName() + ":");
			duck.display();
			duck.fly();
			duck.quack();
			duck.swim();
			System.out.println();
		});
	}
}
