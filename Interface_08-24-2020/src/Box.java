
public class Box extends Shape {

	public int w, h;
	
	public Box(int x, int y, int w, int h) {
		super(x, y);
		this.w = w;
		this.h = h;
	}

	@Override
	public double getArea() {
		return w * h;
	}

	@Override
	public double getPerimeter() {
		
		return 2 * w + 2 * h;
	}
	
}
