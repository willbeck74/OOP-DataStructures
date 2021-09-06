import java.util.NoSuchElementException;

public class LinkedDeque<E> implements DequeInterface<E>{
	//----------------------------------------------- Internal Node class
	private class Node {
		private E data;
		private Node next;
		
		private Node(E next) {
			this(next, null);
		}
		
		private Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//-------------------------------------------------------------------
	
	//====================================================================================== Properties
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	//====================================================================================== Constructors
	public LinkedDeque() {
		head = null;
		tail = null;
		size = 0;
	}
	
	//====================================================================================== Methods
	@Override
	public boolean add(E e) {
		Node n = new Node(e);
		if(isEmpty())
			head = n;
		else
			tail.next = n;
		tail = n;
		size++;
		return true;
	}

	@Override
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		else {
			Node ret = head;
			head = head.next;
			size--;
			return ret.data;
		}
	}

	@Override
	public boolean addFirst(E e) {
		head = new Node(e, head);
		size++;
		return true;
	}

	@Override
	public boolean addLast(E e) {
		Node n = new Node(e);
		tail.next = n;
		tail = n;
		size++;
		return true;
	}

	@Override
	public boolean contains(E e) {
		Node n = new Node(e);
		Node temp = head;
		for(int i = 0; i < size; i++) {
			if(n.equals(temp)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public E peekFirst() {
		return (isEmpty() ? null : head.data);
	}

	@Override
	public E peekLast() {
		return (isEmpty() ? null : tail.data);
	}

	@Override
	public E removeFirst() {
		if(isEmpty()) throw new NoSuchElementException();
		else {
		Node ret = new Node(head.data);
		ret = head.next;
		size--;
		return ret.data;
		}
	}

	@Override
	public E removeLast() {
		if(isEmpty()) throw new NoSuchElementException();
		else {
		Node temp = head;;
		for(int i = 0; i < size-1; i++) {
			temp = temp.next;
		}
		tail = temp;
		tail.next = null;
		size--;
		return temp.data;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		if(!isEmpty()) {
			for(int i = 0; i < size; i++) {
				head.next = null;
			}
			size = 0;
		}
	}

	@Override
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
	//----------------------------------------------- Internal Private Helper Methods
	
	
	//-------------------------------------------------------------------------------
	

}
