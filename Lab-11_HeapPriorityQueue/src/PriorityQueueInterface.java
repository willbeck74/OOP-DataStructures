
public interface PriorityQueueInterface<T extends Comparable<? super T>> {
	boolean isEmpty();
    void clear();
    int size();
    void add(T newEntry);
    T peek();// returns null if empty (gets highest object)
    T remove();// throws NoSuchElementException if empty (get and remove highest obj)
}
