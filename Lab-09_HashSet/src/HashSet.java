/**
 * Lab-09: HashSet
 * 
 * @author: 
 *
 *	Note: 	Spend some time reading over all of the methods.  Some are 
 *			done for you and are very helpful for coding this lab.
 *
 *			Look for the TO-DO parts
 */

public class HashSet<T> implements SetInterface<T> {
	//============================================================================= Inner node class 
	private class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	//============================================================================= Properties
	private Node<T>[] buckets;	// An array of nodes
	private Node head;
	private int size;
	private static final double LOAD_FACTOR = .6;
	private static final int DEFAULT_SIZE = 11; // should be prime

	//============================================================================= Constructors
	public HashSet() {
		buckets = (Node<T>[]) new Node[DEFAULT_SIZE];
		size = 0;
	}

	public HashSet(T[] items) {
		//************************************************************* TO-DO
		// Make a call to your empty constructor and then somehow fill
		// this set with the items sent in
		this();
		for(int i = 0; i < items.length; i++) {
			add(items[i]);
		}
		//addAll()
	}

	//============================================================================= Methods
	@Override
	public boolean add(T item) {
		//************************************************************* TO-DO
		// Check to see if item is in the set. If so return false.  If not,
		// check if the LOAD_FACTOR has already been exceeded by the previous
		// add and if so, call the resize() before adding.
		if(contains(item)) return false;
		else if( (double)(size/buckets.length) >= LOAD_FACTOR) {
			resize();
		} 
		int index = getHashIndex(item);
		Node<T> node = new Node<T>(item);
		node.next = buckets[index];
		buckets[index] = node;
		size++;

		return true;  // returns true because we know it's been added
	}

	@Override
	public boolean remove(T item) {
		//************************************************************* TO-DO
		// To remove an item, you are removing from a linked chain of nodes.
		// Our algorithm is to copy the data from that head node to the node to be 
		// removed, and then remove the head node.
		boolean success = false;

		int index = getHashIndex(item);
		Node<T> node = buckets[index];
		buckets[index] = null;

		while(node != null) {
			if(node.data.equals(item)) {
				success = true;
				node = node.next;
				continue;
			}
			add(node.data);
			node = node.next;
		}
		if(success)
			size--;

		return success;
	}

	@Override
	public boolean contains(T item) { 
		//************************************************************* TO-DO
		// A one-line method that calls
		// the find() method
		if(find(item) == null) return false;
		return true;
	}

	@Override
	public void clear() {
		//************************************************************* TO-DO
		// sets all items in the array to null
		for(int i = 0; i < buckets.length; i++)
			buckets[i] = null;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		// The structure of this is similar to the structure of toString
		//************************************************************* TO-DO
		for (int i = 0, j =0 ; i < buckets.length && j < size; i++) {	
			Node temp = buckets[i];
			while(temp != null) {
				result[j] = temp.data;
				j++;
				temp = temp.next;
			}
		
		}
		return result;
	}

	// Return a string that shows the array indexes, and the items in each bucket
	public String toString() {
		String result = "";
		String format = "[%" + ("" + buckets.length).length() + "d] ";

		// Loop through the array of buckets. A bucket is just a chain of linked nodes.
		// For each bucket, loop through the chain, displaying the contents of the bucket
		for (int i = 0; i < buckets.length; i++) {
			result += String.format(format, i);

			// add the data in bucket i
			Node curr = buckets[i];
			while (curr != null) {
				result += curr.data + " ";
				curr = curr.next;
			}
			result += "\n";
		}
		return result;
	}

	// helper methods

	// Adds all items in an array to this set.
	// resize() could make use of this.
	// One of the constructors can make use of this too.
	private void addAll(T[] items) {
		//************************************************************* TO-DO
		for(int i = 0; i < items.length; i++)
				add(items[i]);
	}

	private void resize() {

		T[] allData = (T[]) toArray();	// toArray() is method above
		buckets = (Node<T>[]) new Node[ firstPrime(2 * buckets.length) ];
		size = 0;
		//************************************************************* TO-DO
		// now, allData contains all the data from the set
		// and buckets points to a new empty array
		// call addAll to do the adding
		// double-check size when you are done
		addAll(allData);
		while(size != allData.length)  
			addAll(allData);

	}

	// Very important
	// Returns the node containing a particular item, or null if not found.
	// Useful for add, remove, and contains. This is a PRIVATE helper method
	private Node<T> find(T item) {
		// Step 1: 	find the index of where this T would be...
		int index = getHashIndex(item);

		// Step 2: 	using the index, check the linked nodes at that array index
		//          by looping through all nodes of the bucket		
		Node<T> curr = buckets[index];	
		while(curr != null && !curr.data.equals(item))
			curr = curr.next;

		return curr;	// we will either be returning null (not found) or the node
		// that contains the node we are looking for
	}

	// Gets the index of the bucket where a given string should go,
	// by computing the hashCode, and then compressing it to a valid index.
	private int getHashIndex(T item) {
		// item will always have the hashCode() method.  
		// From the 
		int hashCode = item.hashCode();
		int index = -1;	// calculate the actual index here using the
		// hashCode and length of of the buckets array.

		//************************************************************* TO-DO

		index = (hashCode%buckets.length + buckets.length) % buckets.length;

		return index;
	}

	// Returns true if a number is prime, and false otherwise
	private static boolean isPrime(int n) {
		if (n <= 1)	return false;
		if (n == 2)	return true;

		for (int i = 2; i * i <= n; i++) 
			if (n % i == 0)	return false;

		return true;
	}

	// Returns the first prime >= n
	private static int firstPrime(int n) {
		while (!isPrime(n)) n++;
		return n;
	}

}
