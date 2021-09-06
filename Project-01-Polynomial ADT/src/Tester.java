import java.util.ArrayList;
import java.util.Arrays;

/*
	Project-01 - Polynomial ADT
	Name: Will Beck

*/
public class Tester {

	public static void main(String[] args) {
		
		Polynomial poly1 = new Polynomial();
		
		System.out.println( "Constructor Test 1: " + (poly1.toString().compareTo( "0") == 0));
		
		ArrayList<Double> coeficients = new ArrayList<Double>(Arrays.asList(2.0, -3.0, 4.0, 1.0));
		ArrayList<Integer> exponents = new ArrayList<Integer>(Arrays.asList(4, 3, 1, 0));
		
		Polynomial poly2  = new Polynomial(coeficients, exponents);
		System.out.println( "Constructor Test 2: " + (poly2.toString().compareTo( "2.0x^4 - 3.0x^3 + 4.0x + 1.0") == 0));
		
		Polynomial poly3  = new Polynomial(coeficients, exponents);
		System.out.println( "Equality Test 1: " + poly2.equals(poly3));
		

	}

}
