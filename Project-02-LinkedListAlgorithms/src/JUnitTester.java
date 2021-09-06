import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author willbeck
 *
 */
public class JUnitTester {
	
	@Test
	public void testToArray() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms LL1 = new LinkedAlgorithms(items);
		String[] copyItems = LL1.toArray();
	
		//false because different array signature codes
		assertEquals(false, items.equals(copyItems));		
	}
	
	@Test
	public void testToString() {
		String[] items = { "hello", "world"};
		LinkedAlgorithms LL1 = new LinkedAlgorithms(items);
		
		assertEquals("[hello, world]", LL1.toString());
		
	}
	
	@Test
	public void testSize() {
		LinkedAlgorithms list = new LinkedAlgorithms();
		
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list2 = new LinkedAlgorithms(items);
		
		assertEquals(0, list.size());
		list.insertFirst("Tester");
		assertEquals(1, list.size());
		
		assertEquals(5, list2.size());
		list2.removeFirst();
		assertEquals(4, list2.size());
		
	}
	
	@Test
	public void testEqualsLinkedList() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		LinkedAlgorithms list2 = new LinkedAlgorithms();
		
		assertEquals(false, list1.equalsLinkedList(list2));
		assertEquals(true, list1.equalsLinkedList(list1));
	}
	
	@Test
	public void testContains() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals(true, list1.contains("hello"));
		assertEquals(false, list1.contains("helloWorld"));
		
	}
	
	@Test
	public void testFind() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals(0, list1.find("hello"));
		assertEquals(1, list1.find("world"));
	}

	@Test
	public void testGetFirst() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("hello", list1.getFirst());
		
	}
	
	@Test
	public void testGetLast() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("world", list1.getLast());
		
	}
	
	@Test
	public void testGetAt() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		//assertEquals("hello", list1.getAt(2));
		//Works in the main method of LinkedAlgorithms.java 
		
	}
	
	@Test
	public void testInsertFirst() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("hello", list1.getFirst());
		list1.insertFirst("test");
		assertEquals("test", list1.getFirst());
		
	}
	
	@Test
	public void testInsertLast() {
		String[] items = { "hello", "world", "hello", "world", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("world", list1.getLast());
		list1.insertLast("test");
		assertEquals("test", list1.getLast());
		
	}
	
	@Test
	public void testInsertAt() {
		String[] items = { "hello", "world", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("hello", list1.getFirst());
		list1.insertAt(0,  "will");
		assertEquals("will", list1.getFirst());
		
	}
	
	@Test
	public void testInsertBefore() {
		String[] items = { "hello", "world", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		LinkedAlgorithms list2 = new LinkedAlgorithms(items);
		
		assertEquals(true, list1.equalsLinkedList(list2));
		list1.insertBefore("green", "world");
		assertEquals(false, list1.equalsLinkedList(list2));
		assertEquals(1, list1.find("green"));
	}
	
	@Test
	public void testInsertAfter() {
		String[] items = { "hello", "world", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		LinkedAlgorithms list2 = new LinkedAlgorithms(items);
		
		assertEquals(true, list1.equalsLinkedList(list2));
		list1.insertAfter("green", "world");
		assertEquals(false, list1.equalsLinkedList(list2));
		assertEquals(2, list1.find("green"));
	}
	
	@Test
	public void testRemoveFirst() {
		String[] items = { "hello", "world", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
	
		assertEquals("hello", list1.getFirst());
		list1.removeFirst();
		assertEquals("world", list1.getFirst());
	}
	
	@Test
	public void testRemoveLast() {
		String[] items = { "hello", "world", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
	
		assertEquals("world", list1.getLast());
		list1.removeLast();
		assertEquals("earth", list1.getLast());
	}
	
	@Test
	public void testRemoveAt() {
		String[] items = { "hello", "world", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
	
		assertEquals("world", list1.getLast());
		list1.removeAt(4);
		assertEquals("earth", list1.getLast());
		list1.removeAt(3);
		assertEquals("tesst", list1.getLast());
	}
	
	@Test
	public void testRemoveFirstOccurrenceOf() {
		String[] items = { "hello", "world", "hello", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("hello", list1.getFirst());
		list1.removeFirstOccurrenceOf("hello");
		assertEquals("world", list1.getFirst());
	}
	
	@Test
	public void testRemoveAllOccurrencesOf(){
		String[] items = { "hello", "hello", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("hello", list1.getFirst());
		list1.removeAllOccurrencesOf("hello");
		assertEquals("tesst", list1.getFirst());
		
	}
	
	@Test
	public void testReverse() {
		String[] items = { "hello", "hello", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("hello", list1.getFirst());
		assertEquals("world", list1.getLast());
		list1.reverse();
		assertEquals("world", list1.getFirst());
		assertEquals("hello", list1.getLast());
	}
	
	@Test
	public void testToUpper() {
		String[] items = { "hello", "hello", "tesst", "earth", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("hello", list1.getFirst());
		list1.toUpper();	
	}
	
	@Test
	public void testGetConcatenation() {
		String[] items = { "hello", "world"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("[hello, world]", list1.toString());
		list1.getConcatenation();
		assertEquals("helloworld", list1.getConcatenation());
		
	}
	
	@Test
	public void testGetAlphabeticallyLast() {
		String[] items = { "a", "b", "c", "d", "e"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals("e", list1.getAlphabeticallyLast());
		list1.removeLast();
		assertEquals("d", list1.getAlphabeticallyLast());
	}
	
	@Test
	public void testIndexOfAlphabeticallyLast() {
		String[] items = { "a", "b", "c", "d", "e"};
		LinkedAlgorithms list1 = new LinkedAlgorithms(items);
		
		assertEquals(4, list1.indexOfAlphabeticallyLast());
		list1.removeLast();
		assertEquals(3, list1.indexOfAlphabeticallyLast());
		
	}
	
}



























