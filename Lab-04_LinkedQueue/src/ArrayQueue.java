import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> {

	//====================================================================================== Properties
	private final static int DEFAULT_CAPACITY = 100;	// default array size
	private E[] elements = null;						// the array for the queue
	private int front = 0, back = 0, size = 0;
	
	//====================================================================================== Constructors
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int capacity) {
		elements = (E[])new Object[capacity];
		clear();
	}
	
	//====================================================================================== Methods
	@Override
	public boolean add(E element) {
		verifyCapacity();
		moveTail();
		elements[back] = element;
		size++;
		return true;
	}

	@Override
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		E ret = elements[front];
		elements[front] = null;
		moveHead();
		//size--;
		if(--size == 0) clear();	// no major advantage
		return ret;
	}

	@Override
	public E peek() {
		return (isEmpty() ? null : elements[front]);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		if(!isEmpty()) {
			for(int i = 0; i < size;  i++) {
				elements[front] = null;
				moveHead();
			}
		}
		
		front = size = 0;
		back = elements.length - 1;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) return "[]";
		String ret = "";
		int f = front;
		for(int i = 0; i < size; i++) {
			ret += ", " + elements[front];
			moveHead();
		}
		front = f;
		
		return "[" + ret.substring(2) + "]";
	}
	
	//--------------------------------- Internal Methods	
	private boolean isFull() {
		return size == elements.length;
	}

	private void moveHead() {
		front = (front + 1) % elements.length;
	}
	
	private void moveTail() {
		back = (back + 1) % elements.length;
	}
	
	private void verifyCapacity() {
		if(isFull()) {
			E[] orig = elements;
			int origSize = orig.length;
			elements = (E[])new Object[origSize * 2];
			for(int i = 0; i < origSize; i++) {
				elements[i] = orig[front];
				front = (front + 1) % origSize;
			}
			front = 0;
			back = origSize - 1;
		}
	}
	
	//===================================================== DELETE FOR PRODUCTION
	public String showActualArray() {
		return Arrays.toString(elements);
	}
	//===================================================== DELETE FOR PRODUCTION

	
}
