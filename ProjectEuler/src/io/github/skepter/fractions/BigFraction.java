package io.github.skepter.fractions;

import java.math.BigInteger;

import io.github.skepter.utils.Utils;

public class BigFraction {

	private long numerator;
	private long denominator;

	public void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(long denominator) {
		this.denominator = denominator;
	}
	
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
		setNumerator((f.getDenominator() * numerator) + (denominator * f.getNumerator()));
		setDenominator(f.getDenominator() * denominator);
		return this;
	}
	
	public BigFraction subtract(BigFraction f) {
		setNumerator((f.getDenominator() * numerator) - (denominator * f.getNumerator()));
		setDenominator(f.getDenominator() * denominator);
		return this;
	}
	
	public BigFraction multiply(BigFraction f) {
		setNumerator(numerator * f.numerator);
		setDenominator(f.denominator * denominator);
		return this;
	}

	public BigFraction divide(BigFraction f) {
		setNumerator(numerator * f.denominator);
		setDenominator(denominator * f.numerator);
		return this;
	}
	
	public BigFraction pow(long i) {
		setNumerator((long) Math.pow(numerator, i));
		setDenominator((long) Math.pow(denominator, i));
		return this;
	}
	
	public BigFraction simplify() {
		long divisor = Utils.gcd(numerator, denominator);
		setNumerator(numerator/divisor);
		setDenominator(denominator/divisor);
		return this;
	}
	
	public BigFraction flip() {
		long temp = numerator;
		setNumerator(denominator);
		setDenominator(temp);
		return this;
	}
	
	public BigBigFraction toBigBigFraction() {
		return new BigBigFraction(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public boolean equals(BigFraction f) {
		BigFraction a = this.simplify();
		BigFraction b = f.simplify();
		
		return (a.getNumerator() == b.getNumerator() && a.getDenominator() == b.getDenominator());
	}
	
	public static BigFraction valueOf(long i) {
		return new BigFraction(i, 1);
	}
}
