
import java.util.*;

/**
 * TO-DO: Fill in the code for the following methods:
 * 
 * 		public V put(K key, V value)
 * 		public V remove(K key)
 * 		public int size()
 * 		public Set<K> keySet()
 * 	
 */


public class HashMap274<K, V> implements MapInterface<K, V> {
	//===================================================================== Inner Class
	// Ordinarily, the inner class would be private.
	// But leave it public. Why? Because it makes it easier for you
	// (and your instructors!) to test your code.
	public class Entry<K, V> implements Comparable<K> {
		public K key;
		public V value;
		// constructors
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public Entry(K key) {
			this(key, null);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			Entry<K,V> other = (Entry<K,V>) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}

		public String toString() {
			return "<" + key + ", " + value + ">";
		}
		
		@Override
		public int compareTo(K o) {
			return ((Comparable)key).compareTo(o);
		}

	}

	//===================================================================== Properties
	// Ordinarily, the instance variables would be private.
	// But leave them public. Why? Because it makes it easier for you
	// (and your instructors!) to test your code.
	// Each array location contains a LinkedList of Key-Value pairs
	// So, it's an array of LinkedLists
	public LinkedList<Entry<K, V>>[] buckets;
	public int size;
	public static final int DEFAULT_CAPACITY = 11; // prime
	public static final double LOAD_FACTOR = 0.65;

	//===================================================================== Constructors
	public HashMap274() {
		buckets = (LinkedList<Entry<K, V>>[])new LinkedList[DEFAULT_CAPACITY];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<Entry<K, V>>();
		}
		size = 0;
	}
	
	//===================================================================== Methods
	@Override	
	public V get(K key) {// Written in video. Follow along and enter the code
		int index = getHashIndex(key);
		for(Entry e : buckets[index])
			if(e.key.equals(key))
				return (V)e.value;
		return null;
	}

	@Override	//************************************** TO-DO
	public V put(K key, V value) {
		// BEFORE adding a new element, check if the load factor
		// is exceeded and if it is, then call resize()
		if( size / buckets.length > LOAD_FACTOR)	resize();
		
		int index = getHashIndex(key);
		for(Entry<K, V> e : buckets[index])
			if(e.key.equals(key)) {
				V ret = e.value;
				e.value = value;
				return ret;
			}
		buckets[index].add(new Entry(key, value));
		size++;
		return null;
		
	}

	@Override	//************************************** TO-DO
	public V remove(K key) {
		int index = getHashIndex(key);
		for(Entry e : buckets[index]) {
			if(e.key.equals(key)) {
				buckets[index].remove(e);
				size--;
				return (V)e.value;
			}
		}
		return null;
	}

	@Override	//************************************** TO-DO
	public int size() {
		return size;
	}
	
	@Override	//************************************** TO-DO
	public Set<K> keySet() {
		Set<K> ret = new HashSet<K>();
		for(int i = 0; i < buckets.length; i++) {
			for(Entry<K, V> e : buckets[i])
				ret.add((K)e.value);
		}
		return ret;
//		for(Entry e : buckets[size])
//			ret.add(e.key);
	}
	
	//=============================================================== Completed for you
	
	@Override
	public Collection<V> values() {
		Collection<V> ret = new ArrayList<V>();
		for(int i = 0; i < buckets.length; i++) {
			for(Entry<K, V> e : buckets[i])
				ret.add(e.value);
		}
		return ret;
	}

	private void resize() {
		LinkedList<Entry<K, V>>[] oldBuckets = buckets;
		buckets = (LinkedList<Entry<K, V>>[])new LinkedList[firstPrime(2*oldBuckets.length)];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = buckets[i] = new LinkedList<Entry<K, V>>();
		}
		
		for (int i = 0; i < oldBuckets.length; i++) {
			while (!oldBuckets[i].isEmpty()) {
				Entry<K, V> entry = oldBuckets[i].remove(0);
				int newIndex = getHashIndex(entry.key);
				buckets[newIndex].add(entry);	
			}
		}
	}

	@Override
	public boolean containsKey(K key) {
		Entry<K, V> temp = new Entry<K, V>(key);
		int bucketIndex = getHashIndex(key); // tells us which bucket to check
		return buckets[bucketIndex].indexOf(temp) != -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (LinkedList<Entry<K,V>> list : buckets) {
			list.clear();
		}
		size = 0;
	}

	public String toString() {
		String result = "";
		
		for (int i = 0; i < buckets.length; i++) {
			result += "[" + i + "]\t" + buckets[i] + "\n";
		}
 		result += "size: " + size + "\n";
		return result;
	}
	
	// Gets the index of the bucket where a given string should go,
	// by computing the hashCode, and then compressing it to a valid index.
	private int getHashIndex(K key) {
		int index = key.hashCode() % buckets.length;
		if (index < 0)
			index += buckets.length;
		return index;
	}

	// Returns true if a number is prime, and false otherwise
	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	// Returns the first prime >= n
	private static int firstPrime(int n) {
		while (!isPrime(n))
			n++;
		return n;
	}

	@Override
	public V getOrDefault(K key, V defaultValue) {
		V ret = get(key);
		return ret == null ? defaultValue : ret;
	}

}
