
import org.junit.runner.*;
import org.junit.*;

import java.security.InvalidParameterException;
import java.util.*;

import mu.grading.*;
import mu.grading.results.GradingScheme;

//@GradingTest(defaultPoints = 2.0)
//@MUTests(lowDetails=true, medDetails=true, highDetails=true) 
@RunWith(GradingRunner.class)

public class PolynomialTest {

	Polynomial[] polynomials;
	ArrayList<Double> coef;
	ArrayList<Integer> expon;
	static final int NUMBER_TEST_POLYNOMIALS = 20;

	public PolynomialTest() {

		polynomials = new Polynomial[NUMBER_TEST_POLYNOMIALS];
		coef = new ArrayList<Double>(Arrays.asList(2.0, -3.0, 4.0, 1.0));
		expon = new ArrayList<Integer>(Arrays.asList(4, 3, 1, 0));
		polynomials[0] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(-2.0, 3.0, -4.0));
		expon = new ArrayList<Integer>(Arrays.asList(4, 3, 1));
		polynomials[1] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(2.0));
		expon = new ArrayList<Integer>(Arrays.asList(0));
		polynomials[2] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(3.0));
		expon = new ArrayList<Integer>(Arrays.asList(0));
		polynomials[3] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(2.0, 3.0, 4.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
		polynomials[4] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(4.0, 5.0, 6.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
		polynomials[5] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(1.5, 2.0, 3.0, 4.0, 5.0));
		expon = new ArrayList<Integer>(Arrays.asList(6, 5, 3, 2, 0));
		polynomials[6] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(4.0, 5.0, 6.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 2, 1));
		polynomials[7] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(-2.0, -3.0, -4.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
		polynomials[8] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(-4.0, -5.0, -6.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
		polynomials[9] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(-1.5, -2.0, -3.0, -4.0, -5.0));
		expon = new ArrayList<Integer>(Arrays.asList(6, 5, 3, 2, 0));
		polynomials[10] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(-4.0, -5.0, -6.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 2, 1));
		polynomials[11] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(-2.0, -3.0, -4.0, -5.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 3, 2, 0));
		polynomials[12] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(4.0, 5.0, -6.0, 7.0));
		expon = new ArrayList<Integer>(Arrays.asList(5, 3, 2, 0));
		polynomials[13] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(-2.0, 3.0, -4.0, 5.0));
		expon = new ArrayList<Integer>(Arrays.asList(6, 3, 2, 0));
		polynomials[14] = new Polynomial(coef, expon);

		coef = new ArrayList<Double>(Arrays.asList(4.0, -5.0, -6.0, 7.0, -10.0));
		expon = new ArrayList<Integer>(Arrays.asList(7, 5, 3, 2, 0));
		polynomials[15] = new Polynomial(coef, expon);
		
		coef = new ArrayList<Double>(Arrays.asList(4.0, -5.0));
		expon = new ArrayList<Integer>(Arrays.asList(1, 0));
		polynomials[16] = new Polynomial(coef, expon);
		
		coef = new ArrayList<Double>(Arrays.asList(1.0, -1.0));
		expon = new ArrayList<Integer>(Arrays.asList(1, 0));
		polynomials[17] = new Polynomial(coef, expon);
		
		coef = new ArrayList<Double>(Arrays.asList(1.0, 1.0));
		expon = new ArrayList<Integer>(Arrays.asList(1, 0));
		polynomials[18] = new Polynomial(coef, expon);
		
	}

	@GradingTest(points = 5.0)
	@Test(timeout = 250)
	public void toStringTest() {

		ST st = ST.startSubtest("toString", 1.0, GradingScheme.code());
		st.assertEquals(polynomials[0].toString(), "2.0x^4 - 3.0x^3 + 4.0x + 1.0");
		st.assertEquals(polynomials[1].toString(), "-2.0x^4 + 3.0x^3 - 4.0x");
	}
	
	@GradingTest(points = 5.0)
	@Test(timeout = 250)
	public void equalityTest() {
		ST st = ST.startSubtest("equals", 1.0, GradingScheme.code());
		
		// true test
		st.assertTrue(polynomials[0].equals(polynomials[0]));
		st.assertTrue(polynomials[2].equals(polynomials[2]));
		st.assertTrue(polynomials[6].equals(polynomials[6]));
		st.assertTrue(polynomials[10].equals(polynomials[10]));
		st.assertTrue(polynomials[15].equals(polynomials[15]));
		
		//false test
		st.assertFalse(polynomials[0].equals(polynomials[1]));
		st.assertFalse(polynomials[2].equals(polynomials[1]));
		st.assertFalse(polynomials[2].equals(polynomials[3]));
		st.assertFalse(polynomials[10].equals(polynomials[11]));
		st.assertFalse(polynomials[14].equals(polynomials[15]));
	}
	
	@GradingTest(points = 5.0)
	@Test(timeout = 250)
	public void contructorTest() {
		ST st = ST.startSubtest("constructor", 1.0, GradingScheme.code());
		
		st.assertTrue( polynomials[15].equals( new Polynomial(polynomials[15] )));
	}
		
	@GradingTest(points = 20.0)
	@Test(timeout = 250)
	public void additionTest() {

		ST st = ST.startSubtest("addition", 1.0, GradingScheme.code());

		// degree 0
		st.assertEquals(polynomials[2].add(polynomials[3]).toString(), "5.0");

		// positive coefficients, same exponents
		st.assertEquals(polynomials[4].add(polynomials[5]).toString(), "6.0x^5 + 8.0x^3 + 10.0");

		// positive coefficients, different exponents
		st.assertEquals(polynomials[6].add(polynomials[7]).toString(),
				"1.5x^6 + 6.0x^5 + 3.0x^3 + 9.0x^2 + 6.0x + 5.0");

		// negative coefficient, same exponents
		st.assertEquals(polynomials[8].add(polynomials[9]).toString(), "-6.0x^5 - 8.0x^3 - 10.0");

		// negative coefficient, different exponents
		st.assertEquals(polynomials[10].add(polynomials[11]).toString(),
				"-1.5x^6 - 6.0x^5 - 3.0x^3 - 9.0x^2 - 6.0x - 5.0");

		// positive and negative coefficients, same exponents
		st.assertEquals(polynomials[12].add(polynomials[13]).toString(), "2.0x^5 + 2.0x^3 - 10.0x^2 + 2.0");

		// positive and negative coefficients, same exponents
		st.assertEquals(polynomials[14].add(polynomials[15]).toString(),
				"4.0x^7 - 2.0x^6 - 5.0x^5 - 3.0x^3 + 3.0x^2 - 5.0");

	}

	@GradingTest(points = 20.0)
	@Test(timeout = 250)
	public void subtrationTest() {

		// degree 0
		ST st = ST.startSubtest("subtraction", 1.0, GradingScheme.code());
		st.assertEquals(polynomials[2].subtract(polynomials[3]).toString(), "-1.0");
		st.assertEquals(polynomials[3].subtract(polynomials[2]).toString(), "1.0");

		// subtracted from itself to give 0
		st.assertEquals(polynomials[2].subtract(polynomials[2]).toString(), "0");
		st.assertEquals(polynomials[15].subtract(polynomials[15]).toString(), "0");

		// positive coefficients, same exponents
		st.assertEquals(polynomials[4].subtract(polynomials[5]).toString(), "-2.0x^5 - 2.0x^3 - 2.0");
		st.assertEquals(polynomials[5].subtract(polynomials[4]).toString(), "2.0x^5 + 2.0x^3 + 2.0");

		// positive coefficients, different exponents
		st.assertEquals(polynomials[6].subtract(polynomials[7]).toString(),
				"1.5x^6 - 2.0x^5 + 3.0x^3 - 1.0x^2 - 6.0x + 5.0");
		st.assertEquals(polynomials[7].subtract(polynomials[6]).toString(),
				"-1.5x^6 + 2.0x^5 - 3.0x^3 + 1.0x^2 + 6.0x - 5.0");
		
		// negative coefficient, same exponents
		st.assertEquals(polynomials[8].subtract(polynomials[9]).toString(), "2.0x^5 + 2.0x^3 + 2.0");
		st.assertEquals(polynomials[9].subtract(polynomials[8]).toString(), "-2.0x^5 - 2.0x^3 - 2.0");
		
		// negative coefficient, different exponents
		st.assertEquals(polynomials[10].subtract(polynomials[11]).toString(),
				"-1.5x^6 + 2.0x^5 - 3.0x^3 + 1.0x^2 + 6.0x - 5.0");
		st.assertEquals(polynomials[11].subtract(polynomials[10]).toString(),
				"1.5x^6 - 2.0x^5 + 3.0x^3 - 1.0x^2 - 6.0x + 5.0");


		// positive and negative coefficients, same exponents
		st.assertEquals(polynomials[12].subtract(polynomials[13]).toString(), "-6.0x^5 - 8.0x^3 + 2.0x^2 - 12.0");
		st.assertEquals(polynomials[13].subtract(polynomials[12]).toString(), "6.0x^5 + 8.0x^3 - 2.0x^2 + 12.0");
		
		// positive and negative coefficients, same exponents
		st.assertEquals(polynomials[14].subtract(polynomials[15]).toString(),
				"-4.0x^7 - 2.0x^6 + 5.0x^5 + 9.0x^3 - 11.0x^2 + 15.0");
		st.assertEquals(polynomials[15].subtract(polynomials[14]).toString(),
				"4.0x^7 + 2.0x^6 - 5.0x^5 - 9.0x^3 + 11.0x^2 - 15.0");

	}
	@GradingTest(points = 20.0)
	@Test(timeout = 250)
	public void multiplyTest() {
		ST st = ST.startSubtest("equals", 1.0, GradingScheme.code());
		
		// two constants
		st.assertEquals(polynomials[2].multiply(polynomials[3]).toString(), "6.0");
		
		// constant times multiple term polynomial
		st.assertEquals(polynomials[2].multiply(polynomials[15]).toString(), "8.0x^7 - 10.0x^5 - 12.0x^3 + 14.0x^2 - 20.0");
		st.assertEquals(polynomials[15].multiply(polynomials[2]).toString(), "8.0x^7 - 10.0x^5 - 12.0x^3 + 14.0x^2 - 20.0");
		
		// binomial * binomial 
		st.assertEquals(polynomials[17].multiply(polynomials[18]).toString(), "1.0x^2 - 1.0");
		st.assertEquals(polynomials[17].multiply(polynomials[17]).toString(), "1.0x^2 - 2.0x + 1.0");
		st.assertEquals(polynomials[18].multiply(polynomials[18]).toString(), "1.0x^2 + 2.0x + 1.0");
		st.assertEquals(polynomials[16].multiply(polynomials[17]).toString(), "4.0x^2 - 9.0x + 5.0");
		st.assertEquals(polynomials[16].multiply(polynomials[18]).toString(), "4.0x^2 - 1.0x - 5.0");
		
		// more complex
		st.assertEquals(polynomials[14].multiply(polynomials[15]).toString(), "-8.0x^13 + 10.0x^11 + 12.0x^10 - 4.0x^9 - 29.0x^8 + 40.0x^7 + 2.0x^6 + 20.0x^5 - 28.0x^4 - 60.0x^3 + 75.0x^2 - 50.0");
		st.assertEquals(polynomials[15].multiply(polynomials[14]).toString(), "-8.0x^13 + 10.0x^11 + 12.0x^10 - 4.0x^9 - 29.0x^8 + 40.0x^7 + 2.0x^6 + 20.0x^5 - 28.0x^4 - 60.0x^3 + 75.0x^2 - 50.0");
		
	}
	
	@GradingTest(points = 20.0)
	@Test(timeout = 250)
	public void derivativeTest() {
		ST st = ST.startSubtest("derivative", 1.0, GradingScheme.code());
		
		// derivative of a constant

		st.assertEquals(polynomials[2].derivative().toString(), "0");
		
		// derivative of a binomial
		st.assertEquals(polynomials[16].derivative().toString(), "4.0");
		
		// derivative of a more complex polynomial
		st.assertEquals(polynomials[15].derivative().toString(), "28.0x^6 - 25.0x^4 - 18.0x^2 + 14.0x");
	}
	
	@GradingTest(points = 10.0)
	@Test(timeout = 250)
	public void evaluateTest() {
		ST st = ST.startSubtest("evaluate", 1.0, GradingScheme.code());
		
		st.assertEquals(polynomials[2].evaluate(3.0), 2.0);
		st.assertEquals(polynomials[16].evaluate(3.0), 7.0);
		
		st.assertEquals(polynomials[15].evaluate(1.0), -10.0);
		st.assertEquals(polynomials[15].evaluate(-1.0), 4.0);
		st.assertEquals(polynomials[15].evaluate(2.0), 322.0);
		st.assertEquals(polynomials[15].evaluate(-2.0), -286.0);
		
	}
	
	@GradingTest(points = 10.0)
	@Test(timeout = 250)
	public void exceptionTest() {
	ST stE = ST.startSubtest("Exceptions", 1); 
	coef = new ArrayList<Double>(Arrays.asList(1.0, 1.0, 1.0));
	expon = new ArrayList<Integer>(Arrays.asList(1, 0));
	
	stE.assertThrows(InvalidParameterException.class, () -> { new Polynomial(coef, expon); });
	}

}