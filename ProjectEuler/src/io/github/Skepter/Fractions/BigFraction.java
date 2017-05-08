package io.github.Skepter.Fractions;

import io.github.Skepter.Utils.Utils;

public class BigFraction {

	int numerator;
	int denominator;

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
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
	
	public BigFraction pow(int i) {
		setNumerator((int) Math.pow(numerator, i));
		setDenominator((int) Math.pow(denominator, i));
		return this;
	}
	
	public BigFraction simplify() {
		int divisor = Utils.gcd(numerator, denominator);
		setNumerator(numerator/divisor);
		setDenominator(denominator/divisor);
		return this;
	}
	
	public BigFraction flip() {
		setNumerator(denominator);
		setDenominator(numerator);
		return this;
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
