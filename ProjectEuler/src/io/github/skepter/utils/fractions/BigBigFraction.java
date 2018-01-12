package io.github.skepter.utils.fractions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigBigFraction implements Comparable<BigBigFraction> {

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
	
	public static BigBigFraction valueOf(long i) {
		return new BigBigFraction(BigInteger.valueOf(i), BigInteger.ONE);
	}
	
	public static BigBigFraction valueOf(BigInteger i) {
		return new BigBigFraction(i, BigInteger.ONE);
	}
	
	public static BigBigFraction valueOf(BigDecimal i) {
		// Get decimal places: https://stackoverflow.com/a/4592016/4779071
		String string = i.stripTrailingZeros().toPlainString();
		int index = string.indexOf(".");
		int decimalPlaces = index < 0 ? 0 : string.length() - index - 1;
		
		int multiplicand = 10 * decimalPlaces;
		BigInteger numerator = new BigInteger(i.multiply(BigDecimal.valueOf(multiplicand)).toString().replace(".0", ""));
		
		return new BigBigFraction(numerator, BigInteger.valueOf(multiplicand));
	}
	
	public BigBigFraction copy() {
		return new BigBigFraction(getNumerator(), getDenominator());
	}

	@Override
	public int compareTo(BigBigFraction o) {
		BigBigFraction a = this.copy();
		if(this.equals(o)) {
			return 0;
		}
		BigBigFraction divided = a.divide(o);
		if(divided.getNumerator().compareTo(divided.getDenominator()) >= 1) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
