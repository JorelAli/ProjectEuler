package io.github.Skepter.Fractions;

import io.github.Skepter.Utils.Utils;

public class Fraction {

	int numerator;
	int denominator;

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public Fraction add(Fraction f) {
		setNumerator((f.getDenominator() * numerator) + (denominator * f.getNumerator()));
		setDenominator(f.getDenominator() * denominator);
		return this;
	}
	
	public Fraction subtract(Fraction f) {
		setNumerator((f.getDenominator() * numerator) - (denominator * f.getNumerator()));
		setDenominator(f.getDenominator() * denominator);
		return this;
	}
	
	public Fraction multiply(Fraction f) {
		setNumerator(numerator * f.numerator);
		setDenominator(f.denominator * denominator);
		return this;
	}

	public Fraction divide(Fraction f) {
		setNumerator(numerator * f.denominator);
		setDenominator(denominator * f.numerator);
		return this;
	}
	
	public Fraction pow(int i) {
		setNumerator((int) Math.pow(numerator, i));
		setDenominator((int) Math.pow(denominator, i));
		return this;
	}
	
	public Fraction simplify() {
		int divisor = Utils.gcd(numerator, denominator);
		setNumerator(numerator/divisor);
		setDenominator(denominator/divisor);
		return this;
	}
	
	public Fraction flip() {
		int temp = numerator;
		setNumerator(denominator);
		setDenominator(temp);
		return this;
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
