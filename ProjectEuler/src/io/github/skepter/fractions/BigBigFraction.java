package io.github.skepter.fractions;

import java.math.BigInteger;

public class BigBigFraction {

	private BigInteger numerator;
	private BigInteger denominator;
	
	public BigBigFraction(BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public BigInteger getNumerator() {
		return numerator;
	}
	
	public BigInteger getDenominator() {
		return denominator;
	}
	
	public void setNumerator(BigInteger numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(BigInteger denominator) {
		this.denominator = denominator;
	}
	
	public BigBigFraction add(BigBigFraction f) {
		setNumerator((f.getDenominator().multiply(numerator)).add(denominator.multiply(f.getNumerator())));
		setDenominator(f.getDenominator().multiply(denominator));
		return this;
	}
	
	public BigBigFraction subtract(BigBigFraction f) {
		setNumerator((f.getDenominator().multiply(numerator)).subtract(denominator.multiply(f.getNumerator())));
		setDenominator(f.getDenominator().multiply(denominator));
		return this;
	}
	
	public BigBigFraction multiply(BigBigFraction f) {
		setNumerator(numerator.multiply(f.numerator));
		setDenominator(f.denominator.multiply(denominator));
		return this;
	}

	public BigBigFraction divide(BigBigFraction f) {
		setNumerator(numerator.multiply(f.denominator));
		setDenominator(denominator.multiply(f.numerator));
		return this;
	}
	
	public BigBigFraction simplify() {
		BigInteger divisor = gcd(numerator, denominator);
		setNumerator(numerator.divide(divisor));
		setDenominator(denominator.divide(divisor));
		return this;
	}

	public BigBigFraction flip() {
		BigInteger temp = numerator;
		setNumerator(denominator);
		setDenominator(temp);
		return this;
	}
	
	private BigInteger gcd(BigInteger a, BigInteger b) {
		return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
	}
	
	@Override
	public String toString() {
		return numerator.toString() + "/" + denominator.toString();
	}
	
	public boolean equals(BigBigFraction f) {
		BigBigFraction a = this.simplify();
		BigBigFraction b = f.simplify();
		
		return (a.getNumerator() == b.getNumerator() && a.getDenominator() == b.getDenominator());
	}
	
}
