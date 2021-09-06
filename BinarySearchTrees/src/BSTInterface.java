import java.util.Iterator;

public interface BSTInterface<E> extends CollectionInterface<E>, Iterable<E>{
	E min();
	E max();
	public Iterator<E> getIterator(enuTraversalType orderType);
}
