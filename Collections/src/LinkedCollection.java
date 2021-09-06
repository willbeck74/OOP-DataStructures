
public class LinkedCollection<E> implements CollectionInterface<E>{

	// ********************************************************************* Inner Node Class
	private class Node {
		E data;
		Node next;
		
		Node(E data){
			this(data, null);
		}
		Node(E data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	// ********************************************************************* 
	// ===================================================================== Properties
	
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	// =====================================================================  Constructors
	
	public LinkedCollection() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// ===================================================================== Methods
	@Override
	public boolean add(E e) {
		Node n = new Node(e);
		if(head == null) {
			head = n;
			size++;
			return true;
		} else if(head != null) {
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = new Node(e);
			size++;
			return true;
		} else return false;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public boolean contains(E o) {
		Node temp = head;
		while(temp != null)
			if(temp.data.equals(o)) return true;
		return false;
	}

	@Override
	public int indexOf(E o) {
		Node temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.data.equals(o)) {
				return pos;
			}
			temp = temp.next;
			pos++;
		}
		return -1;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		Node temp = head;
		for(int i = 0; i <= index; i++)
			temp = temp.next;
		return temp.data;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		else {
			Node temp = head;
			for(int i = 0; i <= index-1; i++) {
			temp = temp.next;
			}
			temp = null;
			size--;
		}
		return true;
	}

	@Override
	public boolean remove(E o) {
		Node temp = head;
		Node n = null;
		while(temp.data != o && temp != null) {
			n = temp;
			temp = temp.next;
		}
		if(temp.data == o) {
			n.next = temp.next;
			size--;
			return true;
		}
		return false;
				
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		String ret = "";
		if(isEmpty())
			return "[]";
		Node temp = head;
		while(temp != null) {
			ret += temp.data;
			temp = temp.next;
			if(temp != null)
				ret += ", ";
		}
		return "[" + ret + "]";
	}

}
