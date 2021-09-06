
public class Ball extends Shape {

	public int radius;
	
	public Ball(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

}
