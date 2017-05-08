package io.github.Skepter.Utils;

public class BigFraction {

	int numerator;
	int denominator;
	
	public BigFraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public BigFraction add(BigFraction f) {
		int num = (f.getDenominator() * numerator) + (denominator * f.getNumerator());
		int denom = f.getDenominator() * denominator;
		return new BigFraction(num, denom);
	}
	
	public BigFraction subtract(BigFraction f) {
		int num = (f.getDenominator() * numerator) - (denominator * f.getNumerator());
		int denom = f.getDenominator() * denominator;
		return new BigFraction(num, denom);
	}
	
	public BigFraction multiply(BigFraction f) {
		int num = numerator * f.numerator;
		int denom = f.denominator * denominator;
		return new BigFraction(num, denom);
	}

	public BigFraction divide(BigFraction f) {
		int num = numerator * f.denominator;
		int denom = denominator * f.numerator;
		return new BigFraction(num, denom);
	}
	
	public BigFraction pow(int i) {
		int num = (int) Math.pow(numerator, i);
		int denom = (int) Math.pow(denominator, i);
		return new BigFraction(num, denom);		
	}
	
	public BigFraction simplify() {
		int divisor = Utils.gcd(numerator, denominator);
		return new BigFraction(numerator/divisor, denominator/divisor);
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
