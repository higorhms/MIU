package prog45closedcurve3;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}

	@Override
	public double[] getArrayOfSides() {
		 double[] aux = new double[]{this.side, this.side, this.side, this.side};

		 return aux;
	}
}
