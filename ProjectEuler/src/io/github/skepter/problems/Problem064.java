package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem064 extends RT {

	/* https://projecteuler.net/problem=64 */
	public static void main(final String[] args) {
		//System.out.println(new SqrtNumber(23).getLowestRoot());
		
		//create sequence a0, a1...
		new ComboNumberFraction(new ComboNumber(new SqrtNumber(23), 0), 1).getExpansion().inverse().getExpansion().inverse().getExpansion().inverse().getExpansion().inverse().getExpansion().inverse().getExpansion();//;
		
		uptime();
	}
}

class ComboNumberFraction {
	
	ComboNumber numerator;
	int denominator;
	
	public ComboNumberFraction(ComboNumber numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	//finds mixed fraction form of a combonumberfraction
	public ComboNumberFraction getExpansion() {
		int expansionNumber = 0;
		while(numerator.value() > denominator) {
			numerator.integer = numerator.integer - denominator;
			expansionNumber++;
		}
		
		System.out.println(expansionNumber + " + " + numerator + "/" + denominator);
		return new ComboNumberFraction(numerator, denominator);
	}
	
	public ComboNumberFraction inverse() {
		int multiplier = this.denominator;
		ComboNumber numerator = new ComboNumber(this.numerator.sqrt, -this.numerator.integer);
		int denominator = this.numerator.sqrt.number - (this.numerator.integer * this.numerator.integer);
		
		//ASSUME perfectly divides:
		denominator = denominator / multiplier;
		
		return new ComboNumberFraction(numerator, denominator);
	}
}

class ComboNumber {
	
	SqrtNumber sqrt;
	int integer;
	//e.g. sqrt(23) + 4
	public ComboNumber(SqrtNumber sqrt, int integer) {
		this.sqrt = sqrt;
		this.integer = integer;
	}
	
	//Calculates 1/ComboNumber
	public ComboNumberFraction inverse() {
		ComboNumber numerator = new ComboNumber(sqrt, -integer);
		int denominator = sqrt.number - (integer * integer);
		return new ComboNumberFraction(numerator, denominator);
	}
	
	public double value() {
		return sqrt.doubleValue() + integer;
	}
	
	@Override
	public String toString() {
		return sqrt.toString() + (integer >= 0 ? "+ " + integer : integer);
	}
}

/**
 * Represents a square root number (e.g. sqrt(23))
 * @author Jorel
 *
 */
@SuppressWarnings("serial")
class SqrtNumber extends Number implements Comparable<Number> {
	
	int number;
	double value;
	
	/**
	 * Constructor for a square root number.
	 * @param number The number to square root. e.g. SqrtNumber(23) = sqrt(23)
	 */
	public SqrtNumber(int number) {
		this.number = number;
		value = Math.sqrt(number);
	}
	
	/**
	 * Gets the smallest integer n such that n^2 < sqrt(number) AND (n+1)^2 > sqrt(number) 
	 * @return
	 */
	public int getLowestRoot() {
		for(int i = 1; i <= number; i++) {
			if(i * i > number) {
				return i-1;
			}
		}
		return number;
	}
	
	public boolean isRational() {
		return Utils.isInteger(value);
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return (float) value;
	}

	@Override
	public int intValue() {
		return (int) value;
	}

	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public int compareTo(Number o) {
		return new Double(value).compareTo(o.doubleValue());
	}
	
	@Override
	public String toString() {
		return "sqrt(" + number + ")";
	}
	
}