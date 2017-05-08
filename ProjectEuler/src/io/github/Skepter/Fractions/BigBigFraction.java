package io.github.Skepter.Fractions;

import java.math.BigInteger;

public class BigBigFraction {

	BigInteger numerator;
	BigInteger denominator;
	
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
	
	public BigBigFraction add(BigBigFraction f) {
		BigInteger num = (f.getDenominator().multiply(numerator)).add(denominator.multiply(f.getNumerator()));
		BigInteger denom = f.getDenominator().multiply(denominator);
		return new BigBigFraction(num, denom);
	}
	
	public BigBigFraction subtract(BigBigFraction f) {
		BigInteger num = (f.getDenominator().multiply(numerator)).subtract(denominator.multiply(f.getNumerator()));
		BigInteger denom = f.getDenominator().multiply(denominator);
		return new BigBigFraction(num, denom);
	}
	
	public BigBigFraction multiply(BigBigFraction f) {
		BigInteger num = numerator.multiply(f.numerator);
		BigInteger denom = f.denominator.multiply(denominator);
		return new BigBigFraction(num, denom);
	}

	public BigBigFraction divide(BigBigFraction f) {
		BigInteger num = numerator.multiply(f.denominator);
		BigInteger denom = denominator.multiply(f.numerator);
		return new BigBigFraction(num, denom);
	}
	
	public BigBigFraction simplify() {
		BigInteger divisor = gcd(numerator, denominator);
		return new BigBigFraction(numerator.divide(divisor), denominator.divide(divisor));
	}

	public BigBigFraction flip() {
		BigInteger num = denominator;
		BigInteger denom = numerator;
		return new BigBigFraction(num, denom);
	}
	
	private BigInteger gcd(BigInteger a, BigInteger b) {
		return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
	}
	
	@Override
	public String toString() {
		return numerator.toString() + "/" + denominator.toString();
	}
	
}
