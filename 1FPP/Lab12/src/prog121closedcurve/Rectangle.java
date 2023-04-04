package prog121closedcurve;

public class Rectangle extends ClosedCurve {

	private double width;
	private double length;
	public Rectangle(double width, double length) throws IllegalClosedCurveException {
		if(width < 0 || length < 0) throw new IllegalClosedCurveException("Width and length should be positive");

		this.length = length;
		this.width = width;
	}
	double computeArea() {
		return width*length;
	}
	


}
