

import java.util.Collection;
import java.util.Set;

public interface MapInterface<K, V> {
	
	/**
	 * If the given key is not already in the map, adds the 
	 * key-value pair to the map. Otherwise, updates the old
	 * value of the existing key to the specified value.
	 * @param key the key
	 * @param value the value to be stored in the map with the key
	 * @return null if the key was not already in the map, or
	 * the old value associated with the key if the key was already in the map
	 */
	public V put(K key, V value);
	
	
	/**
	 * @param key the key
	 * @return the value associated with the key, or null if the key is
	 * not in the map
	 */
	public V get(K key);
	
	
	/**
	 * Removes from the key-value pair associated with the specified key
	 * @param key the key
	 * @return the value associated with the key, or null if the key is
	 * not in the map
	 */
	public V remove(K key);
	
	
	/**
	 * @param key the key
	 * @return true if the map contains a key-value pair with the specified
	 * key, and false otherwise
	 */
	public boolean containsKey(K key);
	
	
	/**
	 * @return true if the map contains no key-value pairs, and false otherwise
	 */
	public boolean isEmpty();
	
	
	/**
	 * Removes all elements from the map
	 */
	public void clear();
	
	
	/**
	 * @return the number of key-value pairs in the map
	 */
	public int size();
	
	
	/**
	 * @return a set of all keys in the map
	 */
	public Set<K> keySet();

	/**
	 * @return a set of all values in the map
	 */
	public Collection<V> values();
	
		
	/**
	 * @return the value from the map and returns it
	 * unless it is not found, in which case, the
	 * defaultValue is returned
	 */
	public V getOrDefault(K key, V defaultValue);

}
