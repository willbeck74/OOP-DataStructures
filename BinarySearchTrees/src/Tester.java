import java.util.Iterator;

public class Tester {

	public static void main(String[] args) {
		
		BinarySearchTree<String> b = new BinarySearchTree<String>();
		
		b.add("P");
		b.add("F");
		b.add("S");
		b.add("B");
		b.add("H");
		b.add("R");
		b.add("Y");
		b.add("G");
		b.add("T");
		b.add("Z");
		b.add("W");
		
		Iterator i;
		
		System.out.println("\nLevel Order: \t");
		i = b.getIterator(enuTraversalType.LEVEL_ORDER);
		while(i.hasNext()) System.out.print(i.next() + " ");
		
		System.out.println("\nIn Order: \t");
		i = b.getIterator(enuTraversalType.IN_ORDER);
		while(i.hasNext()) System.out.print(i.next() + " ");
		
		System.out.println("\nPre Order: \t");
		i = b.getIterator(enuTraversalType.PRE_ORDER);
		while(i.hasNext()) System.out.print(i.next() + " ");
		
		System.out.println("\nPost Order: \t");
		i = b.getIterator(enuTraversalType.POST_ORDER);
		while(i.hasNext()) System.out.print(i.next() + " ");
		
		for(String s : b)
			System.out.print(s + " ");
		
	}

}
