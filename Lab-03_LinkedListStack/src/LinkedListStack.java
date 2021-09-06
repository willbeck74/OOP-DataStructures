import java.util.EmptyStackException;

/**
 * A Linked List based stack.
 * @author Mike Stahr
 *
 */

public class LinkedListStack<Athlete> implements StackInterface<Athlete> {
	
	//======================================================== Inner Node Class
	private class Node {
		Athlete data = null;
		Node next = null;
		
		public Node(Athlete data) {
			this(data, null);
		}
		
		public Node(Athlete data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//=========================================================================
	
	// private member variable to keep track of the number of nodes
	private int size = 0;
	private Node head = null;
	
	/*
	 * For the following implementations, refer to the StackInterface for 
	 * documentation on how to handle edge cases
	 * 
	 */
	@Override
	public void push(Athlete item) {
		if(head == null)
			head = new Node(item);
		else
			head = new Node(item, head);
	}

	@Override
	public Athlete pop() {
		Athlete temp = peek();
		head = head.next;
		return temp;
	}

	@Override
	public Athlete peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		return size == -1;
	}

	@Override
	public void clear() {
		for(int i = 0; i < size; i++) {
			
		}
	}

	@Override
	public int size() {
		return size-1;
	}

	// Returns (without removing) the Athlete at the index position
	// throws IndexOutOfBoundsException if index is invalid 
	public Athlete get(int index) {
		Node temp = head;
		for(int i = 0; i < index; i++)
			temp = temp.next;
		return temp.data;
	}

	// Reverses the stack
	public void reverseStack() {
		Node a, b, c = null;
		b = a = head;
		b = b.next;
		a.next = null;
		
		while(b != null) {
			c = b.next;
			b.next = a;
			a = b;
			b = c;
		}
		head = a;
		
		
	}
	
}
