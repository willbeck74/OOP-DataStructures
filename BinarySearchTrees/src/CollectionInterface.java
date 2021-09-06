
public interface CollectionInterface<E> {
	
	boolean add(E e);
	void clear();
	boolean contains(E e);
	boolean isEmpty();
	boolean isFull();
	boolean remove(E e);
	int size();
}
