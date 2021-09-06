import java.util.Arrays;

public class ArrayCollection<E> implements CollectionInterface<E>{

	//======================================================================================== Properties
	private static final int DEFAULT_CAPACITY = 100;
	private E[] elements;
	private int size;

	//======================================================================================== Constructors
	public ArrayCollection() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayCollection(int capacity) {
		elements = (E[]) new Object[capacity];
	}
	
	//======================================================================================== Methods
	@Override
	public boolean add(E e) {
		if(size >= elements.length)
			elements = Arrays.copyOf(elements, elements.length*2);
		//elements[size++];
		return true;
	}

	@Override
	public void clear() {
		while(size > 0)
			elements[--size] = null;
	}

	@Override
	public boolean contains(E o) {
		return indexOf(o) > -1;
	}

	@Override
	public int indexOf(E o) {
		for(int i = 0; i < size; i++)
			if(elements[i].equals(o)) return i;
		return -1;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		return elements[index];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		elements[index] = elements[--size];
		elements[size] = null;
		return true;
	}

	@Override
	public boolean remove(E o) {
		int pos = indexOf(o);
		if(pos == -1) return false;
		remove(pos);
		return true;
	}

	@Override
	public int size() {
		return size;
	}

}
