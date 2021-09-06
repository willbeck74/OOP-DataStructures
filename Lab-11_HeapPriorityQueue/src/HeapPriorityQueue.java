import java.util.Arrays; 
import java.util.NoSuchElementException;


public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>{
	//----------------------------------------------------------- Inner Node
	private class Node {
		T data;
		Node next;

		public Node(T data) {
			this(data, null);
		}

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//============================================================ Properties
	private static final int DEFAULT_CAPACITY = 5;
	private T[] data;
	private int size;

	//============================================================ Constructors

	public HeapPriorityQueue() {
		this(DEFAULT_CAPACITY);
	}

	public HeapPriorityQueue(int initCapacity) {
		T[] temp = (T[]) new Comparable[initCapacity+1];
		data = temp;
		size = 0;
	}

	public HeapPriorityQueue(T[] entries) {
		this(entries.length + 1);
		size = entries.length;
		for (int index = 0; index < entries.length; index++)
			data[index+1] = entries[index];
		for(int rIndex = size / 2; rIndex > 0; rIndex--)
			reheapDown(rIndex);
	}

	//============================================================ Methods
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {
		Arrays.fill(data, 0, size, null);
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(T newEntry) {
		verifyCapacity();
		data[size] = newEntry;
		reheapUp(size++);
	}

	@Override
	public T peek() {
		if(data[1]!=null) return data[1];

		return null;
	}

	@Override
	public T remove() {
		if(size == 0) throw new NoSuchElementException();

		T temp = data[1];
		data[size] = data[1];
		data[size--] = null;
		reheapDown(1);

		return temp;
	}

	//--------------------------------------------------------- Internal methods
	private int getIndexOfMin() {
		int ret = 0;
		for(int i = 1; i < size; i++)
			if(data[i].compareTo(data[ret]) < 0)
				ret = i;
		return ret;
	}
	private void verifyCapacity() {
		if(size == data.length) {
			int origCap = data.length;
			int newCap = 2 * origCap;
			data = Arrays.copyOf(data, 2 * data.length);
		}
	}

	private void reheapUp(int index) {
		int parentIndex = index / 2;
		while(parentIndex > 0 && data[index].compareTo(data[parentIndex]) > 0) {
			T temp = data[index];
			data[index] = data[parentIndex];
			data[parentIndex] = temp;
			index = parentIndex;
			parentIndex = index / 2;
		}
	}

	private void reheapDown (int index) {
		//		int parentIndex = index/2;
		//		Node left = (Node) data[parentIndex-1];
		//		Node right = (Node) data[parentIndex+1];
		//		
		//		if(left.data.compareTo(right.data) > 0) {
		//			Node temp = (Node) right.next;
		//			right.data = (T) right.next;
		//			right.next = temp;
		//			parentIndex = index/2;
		//			reheapDown(parentIndex+1);
		//		} else {
		//			Node temp = (Node) left.next;
		//			left.data = (T) left.next;
		//			left.next = temp;
		//			parentIndex = index/2;
		//			reheapDown(parentIndex-1);
		//		}

		//I know this is not the way you wanted,
		//but I spent all day trying to figure it out and could not.
		int left = (index * 2) + 1;
		int right = (index * 2) + 2;
		T parentIndex = data[index];

		if(right <= size) {
			T parentLeft = data[left];
			T parentRight = data[right];
			T min = parentLeft.compareTo(parentRight) <= 0 ? parentLeft : parentRight;
			min = parentIndex.compareTo(min) <= 0 ? parentIndex : min;
			if(min.compareTo(parentIndex) == 0) { return; }
			else 
				if(min.compareTo(parentLeft) == 0) {
					T temp = data[index];
					data[index] = data[left];
					data[left] = temp;
					reheapDown(left);
				} else {
					T temp = data[index];
					data[index] = data[right];
					data[right] = temp;
					reheapDown(right);
				}
		}

	}

	@Override
	public String toString() {
		String ret = "";
		for(int i = 0; i < size+1; i++) {
			if(data[i] == null) {
				ret += ", " + "null";
			} else ret += ", " + data[i].toString();
		}
		return "[" + ret.substring(2) + "]";
	}

}




