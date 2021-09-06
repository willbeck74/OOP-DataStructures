
public class DoublyLinkedCollection<E> implements CollectionInterface<E> {

	// ================================================================================= Inner Node Class
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
		
	}
	// =================================================================================
	
	// ================================================================================= Properties
	private Node head;
	private Node tail;
	private int size;
	// ================================================================================= Constructors
	DoublyLinkedCollection(){
		clear();
	}
	// ================================================================================= Methods
	@Override
	public boolean add(E e) {
		Node temp = new Node(e);
		tail.next = temp;
		return true;
	}

	@Override
	public boolean add(E e, int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		Node n = new Node(e);
		Node temp = head;
		for(int i = 0; i <= index; i++) {
			temp = temp.next;
		}
		temp = n;
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
		Node temp = head;
		for(int i = 0; i <= index; i++)
			temp = temp.next;
		return temp.data;
	}

	@Override
	public int indexOf(E o) {
		Node temp = head; 
		int pos = 0;
		for(int i = 0; i <= size; i++) {
			if(temp.data.equals(o)) {
				pos = i;
			}
			temp = temp.next;
		}
		return pos;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		return remove(get(index));
	}

	@Override
	public boolean remove(E o) {
		return remove(indexOf(o));
	}

	@Override
	public boolean remove() {
		Node temp = tail.prev;
		tail = null;
		tail = temp;
		return true;
	}

	@Override
	public int size() {
		return size;
	}
}

