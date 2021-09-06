import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.print.attribute.standard.MediaSize.Other;

public class Polynomial {

	private ArrayList<Node> terms;


	private class Node implements Comparable<Node> {
		double coefficient;
		int exponent;

		public Node(double c, int e) {
			coefficient = c;
			exponent = e;
		}

		@Override
		public int compareTo( Node node ) {
			return node.exponent - this.exponent;
		}
	}



	public Polynomial() { // default constructor
		terms = new ArrayList<Node>();
	}

	public Polynomial(Polynomial poly) { // copy constructor
		this(); //terms = new ArrayList<Node>();
		for(Node n : poly.terms)
			terms.add(new Node(n.coefficient, n.exponent));

	}

	public Polynomial(ArrayList<Double> coef, ArrayList<Integer> expon) {
		this();
		if(coef.size() != expon.size())
			throw new InvalidParameterException("ArrayLists not equal");

		for(int i = 0; i < coef.size(); i++) 
			terms.add(new Node(coef.get(i), expon.get(i)));

		Collections.sort(terms);

	}


	public boolean equals(Polynomial poly) { // checks for equality

		if(poly == this)
			return true;
		if(poly == null)
			return false;
		return false;
	}

	public Polynomial add(Polynomial poly) {
		ArrayList<Integer> exponents = new ArrayList<Integer>();
		ArrayList<Double> coefficients = new ArrayList<Double>();

		Node node1, node2;
		int i = 0, j = 0;
		boolean done = false;

		while(!done) {
			if(i == terms.size() && j == terms.size()) {
				done = true;
			} else {
				if(i == terms.size()) {
					while(j < poly.terms.size()) {
						node2 = poly.terms.get(j);
						coefficients.add(node2.coefficient);
						exponents.add(node2.exponent);
						j++;
					}
					done = true;
				} else if(j == poly.terms.size()) {
					while(i < terms.size()) {
						node1 = terms.get(i);
						coefficients.add(node1.coefficient);
						exponents.add(node1.exponent);
						i++;
					}
					done = true;
				} else {
					node1 = this.terms.get(i);
					node2 = poly.terms.get(j);
					if(node1.exponent == node2.exponent) {
						double coef = node1.coefficient + node2.coefficient;
						coefficients.add(coef);
						exponents.add(node1.exponent);
						i++; j++;
					} else if(node1.exponent > node2.exponent) {
						coefficients.add(node1.coefficient);
						exponents.add(node1.exponent);
						i++;
					} else {
						coefficients.add(node2.coefficient);
						exponents.add(node2.exponent);
						j++;
					}
				}
			}
		}


		return new Polynomial(coefficients, exponents);
	}

	public Polynomial subtract(Polynomial poly) {
		ArrayList<Integer> exponents = new ArrayList<Integer>();
		ArrayList<Double> coefficients = new ArrayList<Double>();

		Node node1, node2;
		int i = 0, j = 0;
		boolean done = false;

		while(!done) {
			if(i == terms.size() && j == terms.size()) {
				done = true;
			} else {
				if(i == terms.size()) {
					while(j < poly.terms.size()) {
						node2 = poly.terms.get(j);
						coefficients.add(node2.coefficient);
						exponents.add(node2.exponent);
						j++;
					}
					done = true;
				} else if(j == poly.terms.size()) {
					while(i < terms.size()) {
						node1 = terms.get(i);
						coefficients.add(node1.coefficient);
						exponents.add(node1.exponent);
						i++;
					}
					done = true;
				} else {
					node1 = this.terms.get(i);
					node2 = poly.terms.get(j);
					if(node1.exponent == node2.exponent) {
						double coef = node1.coefficient - node2.coefficient;
						coefficients.add(coef);
						exponents.add(node1.exponent);
						i++; j++;
					} else if(node1.exponent > node2.exponent) {
						coefficients.remove(node1.coefficient);
						exponents.remove(node1.exponent);
						i++;
					} else {
						coefficients.remove(node2.coefficient);
						exponents.remove(node2.exponent);
						j++;
					}
				}
			}
		}

		return new Polynomial(coefficients, exponents);
	}

	public Polynomial multiply(Polynomial poly) {
		ArrayList<Integer> exponents = new ArrayList<Integer>();
		ArrayList<Double> coefficients = new ArrayList<Double>();

		Node node1, node2;

		for(int i = 0; i < this.terms.size(); i++) {
			node1 = this.terms.get(i);
			for(int j = 0; j < poly.terms.size(); j++) {
				node2 = poly.terms.get(j);
				if(exponents.contains(node1.exponent + node2.exponent)) {
					int index = exponents.indexOf(node1.exponent + node2.exponent);
					coefficients.add(index, node1.coefficient * node2.coefficient);
				} else {
					coefficients.add(node1.coefficient * node2.coefficient);
					exponents.add(node1.exponent + node2.exponent);
				}
			}


		}

		return new Polynomial(coefficients, exponents);
	}

	public double evaluate(double value) { // evaluate the polynomial with the parameter value for the variable
		double ret = 0.0;

		for(Node n : terms)
			ret += n.coefficient * Math.pow(value, n.exponent);
		return ret;
	}

	public Polynomial derivative() {// finds the derivative of host polynomial
		ArrayList<Double> coefs = new ArrayList<Double>();
		ArrayList<Integer> expons = new ArrayList<Integer>();

		for(Node n : terms)
			if(n.exponent > 0) {
				coefs.add(n.coefficient * n.exponent);
				expons.add(n.exponent-1);
			}

		return new Polynomial(coefs, expons);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();

		for (Node term : terms) {
			if (Math.abs(term.coefficient) < 0.0000000001) { // skip if coefficient is zero
			} else if (term.exponent > 1) {
				if (term.coefficient > 0.0) {
					result.append("+ " + term.coefficient + "x^" + term.exponent + " ");
				} else {
					result.append("- " + -1 * term.coefficient + "x^" + term.exponent + " ");
				}
			} else if (term.exponent == 1) {
				if (term.coefficient > 0.0) {
					result.append("+ " + term.coefficient + "x ");
				} else {
					result.append("- " + -1 * term.coefficient + "x ");
				}
			} else { // term.exponent == 0
				if (term.coefficient > 0.0) {
					result.append("+ " + term.coefficient + " ");
				} else {
					result.append("- " + -1 * term.coefficient + " ");
				}
			}
		}
		if (result.length() == 0)
			return "0";
		if (result.charAt(0) == '+')
			result.deleteCharAt(0);
		while (result.charAt(0) == ' ')
			result.deleteCharAt(0);
		while (result.charAt(result.length() - 1) == ' ')
			result.deleteCharAt(result.length() - 1);
		if (result.charAt(0) == '-' && result.charAt(1) == ' ') result.deleteCharAt(1);

		return result.toString();
	}
}
