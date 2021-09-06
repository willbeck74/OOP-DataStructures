import java.util.NoSuchElementException;

// Put your prologue comments here

/**
 * @author Will Beck
 * 
 * @apiNote
 * 		Program-02
 * 		Linked Algorithms
 * 		Due Date: 9/20/2020 @ 11:59 pm    
 *
 */
public class LinkedAlgorithms {

	//==================================================================== Internal Node Class
	private class Node {
		String data;
		Node next;

		Node(String data) {
			this(data, null);
		}

		Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

		// You may add helper methods here

	}
	//========================================================================================



	//==================================================================== Properties
	public Node head;
	public int size;

	//==================================================================== Constructors
	/**
	 * Creates the empty list.
	 */
	public LinkedAlgorithms() {
		head = null;
		size = 0;
	}

	/**
	 * Creates a list containing all the elements of the passed array.
	 * {@code data[0]} will be the first element of the list, {@code data[1]} will
	 * be the second element of the list, and so on.
	 * 
	 * @param data The array of values
	 * @throws NullPointerException - data is null
	 */
	public LinkedAlgorithms(String[] data) {
		if(data == null) throw new NullPointerException();

		for(int i = 0; i < data.length; i++) {
			Node temp = new Node(data[i]);
			if(head == null) {
				head = temp;
			} else {
				Node n = head;
				while(n.next != null)
					n = n.next;
				n.next = temp;
			} // end of else
			size++;
		} // end of for loop

	} // end of constructor

	/**
	 * Constructs a deep copy of the linked list {@code original}
	 * 
	 * @param original The list to be copied
	 * @throws NullPointerException - original is null
	 */
	public LinkedAlgorithms(LinkedAlgorithms original) {
		if(original == null) throw new NullPointerException();

		size = 1;
		head = original.head;
		Node c = original.head.next;
		Node n = head.next;

		while(c != null) {
			n = new Node(c.data);
			size++;
			c = c.next;
		} // end of while
	} // end of constructor

	//==================================================================== Methods
	/**
	 * Returns array with all the elements.
	 * 
	 * @return Array containing all elements.
	 */
	public String[] toArray() {
		Node n = head;
		String[] ret = new String[size];
		for(int i = 0; i < size; i++) {
			ret[i] = n.data;
			n = n.next;
		}
		return ret;
	}

	/**
	 * Formats the elements in the list using leading and ending brackets (i.e., []), with the values comma separated. 
	 * There will be one space between each of these but none at the beginning nor at the end.
	 * Some examples:
	 * if the list is empty, toString() gives []
	 * if the list has these three elements in this order: "hello", "world", "everyone", then the result should be 
	 *      [hello, world, everyone]
	 */
	@Override
	public String toString() {
		String ret = "";
		if(size == 0)
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

	/**
	 * Returns the number of items in the list
	 * 
	 * @return Number of items in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Determines if two lists contain exactly the same values, in exactly the same
	 * order.
	 * 
	 * @return {@code true} if and only if obj is an list that is equivalent to the
	 *         incoming list.
	 */
	public boolean equalsLinkedList(LinkedAlgorithms obj) {
		int count = 0;
		Node n = head;
		Node other = obj.head;
		if(obj.size != 0 && size == obj.size) {
			while(n != null && n.data.equals(other.data)) {
				count++;
				n = n.next;
				other = other.next;
			}
		}
		return count == size;
	}

	/**
	 * Determines if {@code key} is in the linked list.
	 * 
	 * @param key The value to be found
	 * @return true if and only if {@code key} is in the list
	 */
	public boolean contains(String key) {
		Node n = head;
		while(n != null) {
			if(n.data.equals(key))
				return true;
			n = n.next;
		}
		return false;
	}

	/**
	 * Determines the index of {@code key}. -1 is returned if the value is not
	 * present in the linked list. If {@code key} is present present more than once,
	 * the first index is returned.
	 * 
	 * @param key The value to be found
	 * @return The index of the {@code key}
	 */
	public int find(String key) {
		Node n = head;
		int index = 0;
		while(n != null) {
			if(n.data.equals(key))
				return index;
			n = n.next;
			index++;
		}
		return -1;
	}

	/**
	 * Returns the value of the first element of the list.
	 * 
	 * @return The first element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getFirst() {
		if(head == null) throw new NoSuchElementException();

		return head.data;
	}

	/**
	 * Returns the value of the last element of the list.
	 * 
	 * @return The last element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getLast() {
		if(head == null) throw new NoSuchElementException();

		Node n = head;
		while(n.next != null)
			n = n.next;
		return n.data;
	}

	/**
	 * Returns the value of the {@code ith} element of the list (0 based).
	 * 
	 * @param i The target index
	 * @return The value of the ith element of the list.
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public String getAt(int i) {
		if(i > size-1) throw new IndexOutOfBoundsException();
		Node n = head;
		for (int a = 0; a < i; a++)
			n = n.next;
		return n.data;
	}

	/**
	 * Adds {@code data} to the beginning of the list. All other values in the list
	 * remain but they are "shifted to the right."
	 * 
	 * @param data The value to add to the list
	 */
	public void insertFirst(String data) {
		Node first = new Node(data);
		first.next = head;
		head = first;
		size++;
	}

	/**
	 * Adds {@code data} to the end of the list. All other values in the list remain
	 * in their current positions.
	 * 
	 * @param data The value to add to the list
	 */
	public void insertLast(String data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		} else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
		size++;
	}

	/**
	 * Adds data to a specific spot in the list. The values in the list remain
	 * intact but {@code data} is inserted in the list at position {@code i}. When
	 * {@code i=0}, the result is the same as {@code insertFirst}.
	 * 
	 * @param i    The target index
	 * @param data The value to add to the list
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public void insertAt(int i, String data) {
		if(i < 0 || i > size) throw new IndexOutOfBoundsException();

		if(i == 0)
			insertFirst(data);
		else if(i == size)
			insertLast(data);

		Node n = head; 
		for(int a = 0; a < i-1; a++)
			n = n.next;
		Node temp = new Node(data);
		temp.next = n.next;
		n.next = temp;
		size++;
	}

	/**
	 * Adds {@code newData} the position immediately preceding {@code existingData}.
	 * If the {@code existingData} appears multiple times, only the first one is
	 * used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertBefore(String newData, String existingData) {
		int indexExist = find(existingData); // finds current index
		if(indexExist == -1) throw new NoSuchElementException();
		insertAt(indexExist, newData); // moves over existing data, and places new data at that index
	}

	/**
	 * Adds {@code newData} the position immediately after {@code existingData}. If
	 * the {@code existingData} appears multiple times, only the first one is used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertAfter(String newData, String existingData) {
		int indexExist = find(existingData); // finds current index
		if(indexExist == -1) throw new NoSuchElementException();
		insertAt(indexExist+1, newData); 
	}

	/**
	 * Removes the first element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeFirst() {
		if(head == null) throw new NoSuchElementException();
		String first = head.data;
		head = head.next;
		size--;
		return first;

	}

	/**
	 * Removes the last element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeLast() {
		String last;
		if(head == null) throw new NoSuchElementException();
		if(head.next == null) {
			last = head.data;
			head = null;
			return last;
		}
		Node n = head;
		while(n.next.next != null)
			n = n.next;
		last = n.next.data;
		n.next = null;
		size--;
		return last;
	}

	/**
	 * Removes the ith element of the list. The remaining elements are kept in their
	 * existing order.
	 * 
	 * @param i The target index
	 * @return The value removed from the list
	 * @throws IndexOutOfBoundsException i does not represent a legal index
	 */
	public String removeAt(int i) {
		String val;
		if(i < 0 || i >= size) throw new IndexOutOfBoundsException();
		if(i==0) {
			val = head.data;
			head = head.next;
			size--;
			return val;
		}
		Node n = head;
		for(int a = 0; a < i-1; a++)
			n = n.next;
		val = n.next.data;
		n.next = n.next.next;
		size--;
		return val;
	}

	/**
	 * Removes the first occurrence of data in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return {@code true} if and only if {@code data} was removed
	 */
	public boolean removeFirstOccurrenceOf(String data) {
		int index = find(data);
		if(index == -1) return false;
		removeAt(index); return true;
	}

	/**
	 * Removes the all occurrence of {@code data} in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return The number of times {@code data} was removed
	 */
	public int removeAllOccurrencesOf(String data) {
		Node n = head;
		int count = 0;
		while(n != null) {
			if(n.data.compareTo(data) == 0) {
				removeAt(find(n.data));
				count++;
			}
			n = n.next;
		}
		return count;
	}

	/**
	 * Reverses the elements in the incoming linked list.
	 */
	public void reverse() {
		Node a, b, c = null;
		b = a = head;
		b = b.next;
		a.next = null;
		
		while(b != null) {
			c = b.next;
			b.next = a;
			a = b;
			b = c;
		}
		head = a;
	}

	/**
	 * Puts all the elements in the list to uppercase.
	 */
	public void toUpper() {
		Node n = head;
		while(n != null) {
			n.data.toUpperCase();
			n = n.next;
		}
	}

	/**
	 * Returns the concatenation of all strings, from left to right. No extra spaces
	 * are inserted.
	 * 
	 * @return Concatenation of all string in the list
	 */
	public String getConcatenation() {
		String ret = "";
		Node n = head;
		while(n != null) {
			ret += n.data;
			n = n.next;
		}
		return ret;
	}

	/**
	 * Returns the alphabetically last value in the list.
	 * 
	 * @return The alphabetically last value in the list
	 * @throws NoSuchElementException list is empty
	 */
	public String getAlphabeticallyLast() {
		// example:
		// Bob -> Sandy -> Al -> Sandy -> Dan
		// getAlphabeticallyLast() returns "Sandy" 

		Node n = head;
		String ret = "";
		while(n != null) {
			if(ret.compareToIgnoreCase(n.data) < 0)
				ret = n.data;
			n = n.next;
		}
		return ret;
	}

	/**
	 * Returns the index where the alphabetically last value value resides. If this
	 * value appears multiple times, the first occurrence is used.
	 * 
	 * @return Index value of where maximum value resides
	 * @throws NoSuchElementException list is empty
	 */
	public int indexOfAlphabeticallyLast() {
		// example:
		// Bob -> Sandy -> Al -> Sandy -> Dan
		// indexOfAlphabeticallyLast() returns 1

		Node n = head;
		String ret = "";
		int index = 0;
		while(n != null) {
			index++;
			if(ret.compareToIgnoreCase(n.data) > 0) {
				ret = n.data;
				return index;
			}
		}
		return index;
	}

	/**
	 * Determines if the two list contain elements that have exactly the same
	 * value, with the same list sizes, but with the elements perhaps in different order.
	 * 
	 * @returns true only if the two lists are permutations of one another.
	 */
	public boolean anagrams(LinkedAlgorithms other) {
		//char n1[]
		return false;
	}

	//==================================================================== Internal Testing
	public static void main(String[] args) {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms LL1 = new LinkedAlgorithms();
		LinkedAlgorithms LL2 = new LinkedAlgorithms(items);
		LinkedAlgorithms LL3 = new LinkedAlgorithms(LL2);

	}
}

