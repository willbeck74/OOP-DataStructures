
public class Tester {
	private class Node{
		Node next;
		Node prev;
		String data;
		
		public Node(String data) {
			
		}
		
		public Node(String data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public Node insertRight(String data) {
			Node n = new Node(data);
			n.prev = prev;
			n.next = next;
			next = n;
			if(n.next != null) n.next.prev = n;
			return n;
		}

		public String toStringAll() {
			if(next == null) return data;
			return data + ", " + next.toStringAll();
		}
		public String toStringAllReverse() {
			if(next == null) return data;
			return next.toStringAllReverse() + ", " + data;
		}
	}
	
	Node head;
	Node tail;
	int size;
	
	public Tester() {
		head = tail = null;
		size = 0;
	}
	
	public boolean add(String data) {
		if(tail == null) {
			head = tail = new Node(data);
		} else {
			tail = tail.insertRight(data);
		}
		size++;
		return true;
	}
	
	public String toString() {
		if(head == null) return "[]";
		return "[" + head.toStringAll() + "]";
	}
	
	public static void main(String[] args) {
		Tester t = new Tester();
		t.add("A");
		t.add("B");
		t.add("C");
		t.add("D");
		System.out.println(t);
	}
	
}
