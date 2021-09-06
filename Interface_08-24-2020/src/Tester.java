import java.util.ArrayList;
import java.util.Stack;

public class Tester {

	public static void main(String[] args) {
		
		//Stack = LIFO
		Stack<Character> letters = new Stack<Character>();
		String words  = "Hello World...";
		
		for(Character c : words.toCharArray()) {
			System.out.println("pushing " + c);
			letters.push(c);
		}
		
		System.out.println(letters);
		
		while(!letters.empty())
			System.out.print(letters.pop());
		
		/*ArrayList<ShapeInterface> shapes = new ArrayList<ShapeInterface>();
		
		shapes.add(new Ball(5, 5, 10));
		shapes.add(new Box(5, 5, 10, 10));
		
		Polygon p = new Polygon();
		p.addPoint(0,0);
		p.addPoint(3, 0);
		p.addPoint(3, 4);
		shapes.add(p);
		
		for(ShapeInterface si : shapes) {
			System.out.println(si.getArea() + " - " + si.getPerimeter());
		}
		*/
		
	}

}
