import java.util.Iterator;

public class LinkedListIterator<E> implements Iterable<E>{

	class Node {

		
		E data;
		Node next;
		
		public Node(E data) {
			this(data, null);
		}
		
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		public String toStringAll() {
			if(next == null) return data.toString();
			return data + ", " + next.toStringAll();
		}
		
	}
	
	class ListIterator<E>implements Iterator<E>{

		Node current;
		
		public ListIterator() {
			current = head;
		}
		
		public ListIterator(Node start) {
			current = start;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E tmp = (E)current.data;
			current = current.next;
			return tmp;
		}
		
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return null;
	}
	
	Node head, tail;
	int size;
	
	public LinkedListIterator() {
		head = tail = null;
		size = 0;
	}
	
	public void add(E data) {
		if(head == null) {
			head = tail = new Node(data);
			size++;
		} else {
			Node n = new Node(data);
			tail.next = n;
			tail = n;
			size++;
		}
	}
	
	@Override
	public String toString() {
		if(head == null) return "[]";
		return head.toStringAll();
	}
	
	
	public static void main(String[] args) {
		LinkedListIterator<String> words = new LinkedListIterator<String>();
		words.add("Hello");
		words.add("World");
		words.add("This");
		words.add("Is");
		words.add("Good");
		for(String s : words)
			System.out.println(s);
	}
	
}
