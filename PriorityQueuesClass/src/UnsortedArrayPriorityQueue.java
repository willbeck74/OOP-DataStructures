import java.util.Arrays; 
import java.util.NoSuchElementException;

public class UnsortedArrayPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	//============================================================ Properties
	private static final int DEFAULT_CAPACITY = 5;
	private T[] data;
	private int size;

	//============================================================ Constructors
	public UnsortedArrayPriorityQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public UnsortedArrayPriorityQueue(int initCapacity) {
		T[] temp = (T[]) new Comparable[initCapacity];
		data = temp;
		size = 0;
	}
	
	public UnsortedArrayPriorityQueue(T[] entries) {
		this(2*entries.length);
		for(T e : entries)
			add(e);
	}
	
	//============================================================ Methods
	@Override
	public boolean isEmpty() {
		return size == 0;
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
		data[size++] = newEntry;
	}

	@Override
	public T peek() {
		return isEmpty() ? null : data[getIndexOfMin()];
	}

	@Override
	public T remove() {
		if(isEmpty()) throw new NoSuchElementException();
		int min = getIndexOfMin();
		T ret = data[min];
		data[min] = data[--size];
		data[size] = null;
		return ret;
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
	@Override
	public String toString() {
		String ret = "";
		for(int i = 0; i < size; i++)
			ret += ", " + data[i].toString();
		return "[" + ret.substring(2) + "]";
	}
	
}
