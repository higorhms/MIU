package prog44closedcurve2;

public final class Square extends ClosedCurve implements Polygon {

	private final int SQUARE_SIDE = 4;
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}

	@Override
	public int getNumberOfSides() {
		return this.SQUARE_SIDE;
	}

	@Override
	public double computePerimeter() {
		return this.side * SQUARE_SIDE;
	}
}
