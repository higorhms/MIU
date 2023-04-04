package prog44closedcurve2;
public class Test {
	public static void main(String[] args) {

		ClosedCurve[] objects = {
				new Square(3),
				new Triangle(4,5,6),
				new Rectangle(3, 4),
		};

		for(ClosedCurve cc : objects) {
			System.out.println(
					String.format("For this %s\n Number of slides = %d\n Perimeter = %.1f",
					cc.getClass().getSimpleName(),
					((Polygon) cc).getNumberOfSides(),
					((Polygon) cc).computePerimeter())
			);
		}
	}
}