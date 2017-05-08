package io.github.Skepter.Fractions;

import java.math.BigInteger;

import io.github.Skepter.Utils.Utils;

public class Fraction {

	int numerator;
	int denominator;
	
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
		int num = (f.getDenominator() * numerator) + (denominator * f.getNumerator());
		int denom = f.getDenominator() * denominator;
		return new Fraction(num, denom);
	}
	
	public Fraction subtract(Fraction f) {
		int num = (f.getDenominator() * numerator) - (denominator * f.getNumerator());
		int denom = f.getDenominator() * denominator;
		return new Fraction(num, denom);
	}
	
	public Fraction multiply(Fraction f) {
		int num = numerator * f.numerator;
		int denom = f.denominator * denominator;
		return new Fraction(num, denom);
	}

	public Fraction divide(Fraction f) {
		int num = numerator * f.denominator;
		int denom = denominator * f.numerator;
		return new Fraction(num, denom);
	}
	
	public Fraction pow(int i) {
		int num = (int) Math.pow(numerator, i);
		int denom = (int) Math.pow(denominator, i);
		return new Fraction(num, denom);		
	}
	
	public Fraction simplify() {
		int divisor = Utils.gcd(numerator, denominator);
		return new Fraction(numerator/divisor, denominator/divisor);
	}
	
	public Fraction flip() {
		int num = denominator;
		int denom = numerator;
		return new Fraction(num, denom);
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
