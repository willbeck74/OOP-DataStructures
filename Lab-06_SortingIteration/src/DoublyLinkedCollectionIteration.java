import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Lab-05 
 * @author stahrm
 *
 * @param <E>
 */
public class DoublyLinkedCollectionIteration<E> implements CollectionInterface<E> {
	//************************************************************************************** Inner Classes
	private class Node {
		E data;
		Node next;
		Node prev;

		public Node(E data) {
			this(data, null, null);
		}

		public Node(E data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		//============================================= Internal methods
		
		// remove() breaks it's connections to things pointing to it
		// in other words, this node removes itself from the equation 
		void remove() {
			if(prev != null)	prev.next = next;
			if(next != null)	next.prev = prev;
		}

		Node insertLeft(Node n) {
			n.next = this;
			n.prev = this.prev;
			prev = n;
			if(n.prev != null) 
				n.prev.next = n;
			return n;
		}
		
		Node insertRight(Node n) {
			n.prev = this;
			n.next = next;
			next = n;
			if(n.next != null)
				n.next.prev = n;
			return n;
		}
		
		// toStringAll() recursively calls it's children
		// to produce a full list of values
		String toStringAll() {
			if(next == null) return data.toString();
			else return data + ", " + next.toStringAll();
		}
	}

	class MyClassIterator<E> implements Iterator<E> {
		private Node current;
		
		public MyClassIterator() {
			this(head);
		}
		
		public MyClassIterator(Node start) {
			current = start;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E ret = (E)current.data;
			current = current.next;	
			return ret;
		}
		
	}
	
	
	//-------------- Small inner class - can be used to send both index and node around
	private class SelectedItem {
		Node node = null;
		int index = -1;
	}

	//**************************************************************************************

	public Iterator<E> iterator(){
		return new MyClassIterator();
	}
	
	//====================================================================================== Properties
	private Node head;
	private Node tail;
	private int size;

	//====================================================================================== Constructors
	DoublyLinkedCollectionIteration() {
		//clear();
		head = tail = null;
		size = 0;
	}

	//====================================================================================== Methods
	@Override
	public boolean add(E e) {
		return add(e, size);	// adds to the end of the list
	}

	@Override
	public boolean add(E e, int index) {
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
		Node n = new Node(e);
		if(size == 0) {
			head = tail = n;
		} else {
			Node tmp = find(index);
			if(tmp == null) 			tail = tail.insertRight(n);
			else if(tmp == head) 		head = head.insertLeft(n);
			else 						tmp.insertLeft(n);			
		}
		size++;
		return true;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public boolean contains(E o) {
		return indexOf(o) > -1;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		return find(index).data;
	}

	@Override
	public int indexOf(E o) {
		return find(o).index;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

		if(size == 1) {
			clear();
		} else {
			Node n = find(index);	
			if(n.prev != null)	n.prev.next = n.next;	//  We can do these 2 here or put them in the Node
			if(n.next != null)	n.next.prev = n.prev;	//	class and call the node to do it: n.remove();
			if(n == head) head = head.next;
			if(n == tail) tail = tail.prev;
			size--;
		}
		return true;
	}

	@Override
	public boolean remove(E o) {
		SelectedItem n = find(o);
		if(n.index == -1) return false;
		n.node.remove();
		if(n.node == head) head = head.next;
		if(n.node == tail) tail = tail.prev;
		size--;
		return true;
	}

	@Override
	public boolean remove() {
		return remove(size-1);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if(head == null) return "[]";
		return "[" + head.toStringAll() + "]";
	}

	//============================================ 2 helper methods that might come in handy...
	private Node find(int index) {
		Node tmp = head;
		for(int i = 0; i < index; i++) 
			tmp = tmp.next;		
		return tmp;
	}

	private SelectedItem find(E o) {
		SelectedItem ret = new SelectedItem();
		Node tmp = head;
		for(int i = 0; i < size; i++) {
			if(tmp.data.equals(o)) {
				ret.node = tmp;
				ret.index = i;
				break;
			}
			tmp = tmp.next;
		}	
		return ret;
	}


}
