import java.util.ArrayList;

public class Polygon implements ShapeInterface {

	//==================================================================
	private class Point {
		private double x, y;
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		public Point(Point p) {
			this(p.x, p.y);
		}
		public double distance(Point p) {
			return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
		}
	}
	
	//==================================================================
	
	private ArrayList<Point> vertices;
	 
	public Polygon() {
		vertices = new ArrayList<Polygon.Point>();
	}
	
	@Override
	public double getArea() {
		double area = 0.0;
		
		int n = vertices.size();
		Point p1, p2;
		int j = n-1;
		for (int i = 0; i < n; i++) {
			p1 = vertices.get(j);
			p2 = vertices.get(i);
			area += (p1.x + p2.x) * (p1.y - p2.y);
			j = i;
		}
		
		return Math.abs(area/2);
	}
	
	public void addPoint(double x, double y) {
		vertices.add(new Point(x, y));
	}

	@Override
	public double getPerimeter() {
		double distance = 0;
		int len = vertices.size();
		for (int i = 0; i < len; i++) 
			distance += vertices.get(i).distance(vertices.get((i+1) % len));
		return distance;	
		
	}
	
	public int compareTo(Polygon o) {
		return (int)(getArea()-o.getArea());
	}

}
