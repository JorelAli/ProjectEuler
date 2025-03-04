package io.github.jorelali.utils.fractions;

import java.math.BigInteger;

import io.github.jorelali.utils.Utils;

public class Fraction implements Comparable<Fraction> {

	private int numerator;
	private int denominator;

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
	
	public Fraction multiply(int n) {
		setNumerator(numerator * n);
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
	
	public boolean canBeSimplified() {
		int divisor = Utils.gcd(numerator, denominator);
		Fraction f = this.copy();
		f.setNumerator(numerator/divisor);
		f.setDenominator(denominator/divisor);
		return !this.equals(f);
	}
	
	public Fraction flip() {
		int temp = numerator;
		setNumerator(denominator);
		setDenominator(temp);
		return this;
	}
	
	public BigFraction toBigFraction() {
		return new BigFraction(numerator, denominator);
	}
	
	public BigBigFraction toBigBigFraction() {
		return new BigBigFraction(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public boolean equals(Fraction f) {
		return (f.getNumerator() == getNumerator() && f.getDenominator() == getDenominator());
	}
	
	public boolean isEquivalent(Fraction f) {
		Fraction a = this.simplify();
		Fraction b = f.simplify();
		return (a.getNumerator() == b.getNumerator() && a.getDenominator() == b.getDenominator());
	}
	
	public static Fraction valueOf(int i) {
		return new Fraction(i, 1);
	}
	
	/*
	 * Makes a copy of this fraction. This is different to "this" fraction
	 */
	public Fraction copy() {
		return new Fraction(getNumerator(), getDenominator());
	}

	@Override
	public int compareTo(Fraction o) {
		Fraction a = this.copy();
		if(this.isEquivalent(o)) {
			return 0;
		}
		Fraction divided = a.divide(o);
		if(divided.getNumerator() > divided.getDenominator()) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
