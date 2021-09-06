
public class Tester {

	public static void main(String[] args) {
		HeapPriorityQueue<Integer> h = new HeapPriorityQueue<Integer>();
		h.add(55);
		h.add(25);
		h.add(75);
		h.add(20);
		h.add(30);
		h.add(10);
		h.add(90);
		
		System.out.println(h);
		h.remove();
		System.out.println(h);
		h.remove();
		System.out.println(h);
		h.remove();
		System.out.println(h);
		h.remove();
		System.out.println(h);
		h.remove();
		System.out.println(h);
		h.remove();
		System.out.println(h);
		h.remove();
		System.out.println(h);
		try {
			h.remove();
		} catch (Exception e) {
			System.out.println("If you see this that means it worked. Tried to remove when there were no more to remove");
		}
	}
}