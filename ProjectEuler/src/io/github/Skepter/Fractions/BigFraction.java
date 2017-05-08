package io.github.Skepter.Fractions;

import io.github.Skepter.Utils.Utils;

public class BigFraction {

	long numerator;
	long denominator;

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
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
