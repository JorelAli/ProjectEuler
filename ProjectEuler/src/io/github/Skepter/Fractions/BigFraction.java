package io.github.Skepter.Fractions;

import io.github.Skepter.Utils.Utils;

public class BigFraction {

	long numerator;
	long denominator;
	
	public BigFraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public long getNumerator() {
		return numerator;
	}
	
	public long getDenominator() {
		return denominator;
	}
	
	public BigFraction add(BigFraction f) {
		long num = (f.getDenominator() * numerator) + (denominator * f.getNumerator());
		long denom = f.getDenominator() * denominator;
		return new BigFraction(num, denom);
	}
	
	public BigFraction subtract(BigFraction f) {
		long num = (f.getDenominator() * numerator) - (denominator * f.getNumerator());
		long denom = f.getDenominator() * denominator;
		return new BigFraction(num, denom);
	}
	
	public BigFraction multiply(BigFraction f) {
		long num = numerator * f.numerator;
		long denom = f.denominator * denominator;
		return new BigFraction(num, denom);
	}

	public BigFraction divide(BigFraction f) {
		long num = numerator * f.denominator;
		long denom = denominator * f.numerator;
		return new BigFraction(num, denom);
	}
	
	public BigFraction pow(long i) {
		long num = (long) Math.pow(numerator, i);
		long denom = (long) Math.pow(denominator, i);
		return new BigFraction(num, denom);		
	}
	
	public BigFraction simplify() {
		long divisor = Utils.gcd(numerator, denominator);
		return new BigFraction(numerator/divisor, denominator/divisor);
	}

	public BigFraction flip() {
		long num = denominator;
		long denom = numerator;
		return new BigFraction(num, denom);
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
