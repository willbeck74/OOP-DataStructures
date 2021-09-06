import java.util.PriorityQueue;
import java.util.Queue;

public class Tester {

	public Tester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		PriorityQueue<Student> pQueue = new PriorityQueue<>();
		pQueue.add(new Student("willie", 28, false));
		pQueue.add(new Student("jose", 27, false));
		pQueue.add(new Student("albert", 30, false));
		while (!pQueue.isEmpty()) 
		     System.out.println(pQueue.remove());
	}

}
