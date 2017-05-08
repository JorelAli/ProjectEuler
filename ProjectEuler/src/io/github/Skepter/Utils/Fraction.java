package io.github.Skepter.Utils;

public class Fraction {

	long numerator;
	long denominator;
	
	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public long getNumerator() {
		return numerator;
	}
	
	public long getDenominator() {
		return denominator;
	}
	
	public Fraction add(Fraction f) {
		long num = (f.getDenominator() * numerator) + (denominator * f.getNumerator());
		long denom = f.getDenominator() * denominator;
		return new Fraction(num, denom);
	}
	
	public Fraction subtract(Fraction f) {
		long num = (f.getDenominator() * numerator) - (denominator * f.getNumerator());
		long denom = f.getDenominator() * denominator;
		return new Fraction(num, denom);
	}
	
	public Fraction multiply(Fraction f) {
		long num = numerator * f.numerator;
		long denom = f.denominator * denominator;
		return new Fraction(num, denom);
	}

	public Fraction divide(Fraction f) {
		long num = numerator * f.denominator;
		long denom = denominator * f.numerator;
		return new Fraction(num, denom);
	}
	
	public Fraction pow(long i) {
		long num = (long) Math.pow(numerator, i);
		long denom = (long) Math.pow(denominator, i);
		return new Fraction(num, denom);		
	}
	
	public Fraction simplify() {
		long divisor = Utils.gcd(numerator, denominator);
		return new Fraction(numerator/divisor, denominator/divisor);
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
