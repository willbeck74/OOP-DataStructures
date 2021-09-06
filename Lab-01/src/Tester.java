import java.util.ArrayList;
import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		// Do your own testing here.  Create a WordList object,
		// add, remove, check what's in the array, and so on.
		// Test edge cases as you go.
	
		WordList wl = new WordList();
		wl.add("A");
		wl.add("B");
		wl.add("C");
		wl.add("D");
		wl.add("E");
		
		
		System.out.println(wl.contains("A"));
		
		System.out.println(wl);
		System.out.println(Arrays.toString(wl.toArray()));
		
		System.out.println(wl.remove(1));
		
		wl.set(2, "J");
		
		System.out.println(Arrays.toString(wl.toArray()));
	}
	


}
