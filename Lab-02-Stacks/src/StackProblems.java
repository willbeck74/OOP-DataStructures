/*
 * Lab-02_Stack-ADT
 * Name: Will Beck
 * Date: 26 August 2020
 */

public class StackProblems {

	public static void main(String[] args) {

		// Do initial testing here.
		// For example, here is a basic test of the sum method:
		ArrayStack<Integer> stk = new ArrayStack<>();
		stk.push(11);
		stk.push(5);
		stk.push(8);
		stk.push(7);
		System.out.println("12? " + sum(stk));
		
		//pushUnder(stk, 20);
		sumSkipDuplicates(stk);
		
	}

	/*
	 * Computes the sum of all the numbers in the stack. It's ok 
	 * to destroy the stack in the process.
	 */
	public static int sum(ArrayStack<Integer> data) {
		int total = 0;
	
		while(!data.isEmpty()) {
			total+=data.pop();
		}
		return total;
	}


	/*
	 * Puts an integer under the top item in a stack.  If the stack is empty,
	 * just put the item on the top. 
	 * For example: if stk starting at the top is: 7, 8, 5, 11, 
	 * then pushUnder(stk, 20) would result in: 7, 20, 8, 5, 11
	 * For example: if stk is empty,  
	 * then pushUnder(stk, 20) would result in: 20
	 */
	public static void pushUnder(ArrayStack<Integer> data, int value) {
		if(data.isEmpty())
			data.push(value);
		else {
		int top = data.peek();
		data.pop();
		data.push(value);
		data.push(top);
		}
	}
	
	
	/*
	 * Computes the sum of all the numbers in the stack. However, if two or more
	 * numbers in a row are equal, only add one of them. So, for example, if the
	 * stack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would
	 * be added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(ArrayStack<Integer> data) {
		int sum = 0;
		int num = 0, num1 = 0;
		
		while(!data.isEmpty()) {
			num = num1;
			num1 = data.pop();
			if(num != num1)
				sum = sum + num1;
		}
		return sum;
	}

	/*
	 * Puts all of the characters of a string into a stack, with the first
	 * character of the string at the bottom of the stack and the last character
	 * of the string at the top of the stack.
	 */
	public static ArrayStack<Character> stringToStack(String s) {
		ArrayStack<Character> c = new ArrayStack<Character>();
		for(int i = 0; i < s.length(); i++) {
			c.push(s.charAt(i));
		}
		return c;
	}

	/*
	 * Reverses a given stack, so that the top of the stack becomes the bottom
	 * and the bottom becomes the top. YOU MAY USE ADDITIONAL STACKS AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static void reverseStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> a = new ArrayStack<Integer>();
		ArrayStack<Integer> b = new ArrayStack<Integer>();
		
		while(!s.isEmpty()) {
			a.push(s.pop());
		}
		while(!a.isEmpty()) {
			b.push(a.pop());
		}
		while(!b.isEmpty()) {
			s.push(b.pop());
		}
		
		
	}
	
	/*
	 * Returns an exact copy of the given stack.  At the end of this method
	 * the original stack should be the same as when it started, and a new copy
	 * of that stack should be returned.  YOU MAY USE ADDITIONAL STACKS AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static ArrayStack<Integer> copyStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> a = new ArrayStack<Integer>();
		ArrayStack<Integer> b = new ArrayStack<Integer>();
		
		while(!s.isEmpty()) {
			a.push(s.pop());
		}
		while(!a.isEmpty()) {
			b.push(a.peek());
			s.push(a.peek());
			a.pop();	
		}
		return b;	
	}

	/*
	 * A palindrome reads the same forward and backward. Use a stack to
	 * determine if a given string is a palindrome. Challenge: try not to use
	 * any additional variables (except a counter for any loop). Just the given
	 * string and a stack of Characters.
	 */
	public static boolean isPalindrome(String s) {
		
		ArrayStack<Character> a = new ArrayStack<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			a.push(s.charAt(i));
		}
		
		String reverse = "";
		
		while(!a.isEmpty()) {
			reverse += a.pop();
		}
		if(s.equals(reverse))
			return true;
		return false;
	}

}
