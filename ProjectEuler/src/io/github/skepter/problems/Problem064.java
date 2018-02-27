package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem064 extends RT {

	/* https://projecteuler.net/problem=64 */
	public static void main(final String[] args) {
		System.out.println(new SqrtNumber(23).getLowestRoot());
		uptime();
		//create sequence a0, a1...
	}
	
	// 1/ (1/sqrt(23)-4)
	public void getA() {
		
	}
	
	static class ComboNumberFraction {
		ComboNumber numerator;
		int denominator;
		public ComboNumberFraction(ComboNumber numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		} 
	}
	
	static class ComboNumber {
		
		SqrtNumber sqrt;
		int integer;
		//e.g. sqrt(23) + 4
		public ComboNumber(SqrtNumber sqrt, int integer) {
			this.sqrt = sqrt;
			this.integer = integer;
		}
		
		//Calculates 1/ComboNumber
		public void inverse() {
			ComboNumber numerator = new ComboNumber(sqrt, -integer);
			int denominator = sqrt.number - (integer * integer);
		}
	}
	
	/**
	 * Represents a square root number (e.g. sqrt(23))
	 * @author Jorel
	 *
	 */
	static class SqrtNumber extends Number implements Comparable<Number> {
		
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
		
	}
}
