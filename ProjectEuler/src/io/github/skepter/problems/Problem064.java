package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem064 extends RT {

	/* https://projecteuler.net/problem=64 
	 * Checks: https://oeis.org/A013943/list */
	public static void main(final String[] args) {
		//System.out.println(new SqrtNumber(23).getLowestRoot());
		
		//create sequence a0, a1...
		//new ComboNumberFraction(new ComboNumber(new SqrtNumber(23), 0), 1).getExpansion().fraction.inverse().getExpansion().fraction.inverse().getExpansion().fraction.inverse().getExpansion().fraction.inverse().getExpansion().fraction.inverse().getExpansion();//;
		
//		ComboNumberFraction fraction = new ComboNumberFraction(new ComboNumber(new SqrtNumber(23), 0), 1); 
//		for(int i = 0; i < 10; i++) {
//			ExpansionFractionObject result = fraction.getExpansion();
//			System.out.println(result.expansion);
//			fraction = result.fraction.inverse();
//		}
		
		
		//System.out.println(lengthSize(2));
		
		//System.out.println(length("242424242424242424242424", "242424242424242424242424"));
		
//		System.out.println(lengthSize(7));
		
		//System.out.println(lengthSize(7614));
		
		System.out.println(lengthSize(13));
				
		int count = 0;
		int max = 0;
		
		
		
		for(int i = 2; i <= 10000; i++) {
			if(!Utils.isInteger(Math.sqrt(i))) {
				int lengthSize = lengthSize(i);
				System.out.println(i + ": " + lengthSize);
				if((lengthSize & 1) == 1) {
					if(lengthSize > max)
						max = lengthSize;
					count++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
		
		//Program takes 116 milliseconds
		//System.out.println(getExpansion(23, 50));
		
		uptime();
	}
	
	public static List<Integer> getExpansion(int integer, int listLength) {
		List<Integer> list = new ArrayList<>();
		ComboNumberFraction fraction = new ComboNumberFraction(new ComboNumber(new SqrtNumber(integer), 0), 1);
		for(int i = 0; i < listLength; i++) {
			ExpansionFractionObject result = fraction.getExpansion();
			list.add(result.expansion);
			fraction = result.fraction.inverse();
		}
		return list;
	}
	
	public static int lengthSize(int integer) {
		String result = getLength(getExpansion(integer, 1000));
		//System.out.println(result);
		return length(result, result).length();
	}
	
	/**
	 * Repeatedly reduces the length from the getLength() function recursively to get
	 * the smallest repeating length from the recurring sequence (recurrence)
	 */
	public static String length(String sequence, String previousSequence) {
		String regex = "(\\d+)\\1";
		Pattern patt = Pattern.compile(regex);
		Matcher matcher = patt.matcher(sequence);
		while (matcher.find()) {
			String repeatedStr = matcher.group(1);
			
			if(previousSequence.contains(repeatedStr)) {
				
				if(!previousSequence.replaceAll(repeatedStr, "").equals("") && Utils.isInteger(((double) previousSequence.length() / (double) repeatedStr.length()))) {
					return previousSequence;
				}
				
				return length(previousSequence, repeatedStr);
			} else {
				return repeatedStr;
			}
		}
		return sequence;
	}
	
	/**
	 * Matches a sequence
	 * https://stackoverflow.com/a/28851457
	 * @param expansion
	 * @return
	 */
	public static String getLength(List<Integer> expansion) {
		
		//Don't need first element
		expansion.remove(0);
		
		StringBuilder builder = new StringBuilder();
		
		expansion.forEach(builder::append);
		
		String regex = "(\\d+)\\1";
		Pattern patt = Pattern.compile(regex);
		Matcher matcher = patt.matcher(builder.toString());
		while (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
}

class ExpansionFractionObject {
	
	ComboNumberFraction fraction;
	int expansion;
	
	public ExpansionFractionObject(ComboNumberFraction fraction, int expansion) {
		this.fraction = fraction;
		this.expansion = expansion;
	}
}

class ComboNumberFraction {
	
	ComboNumber numerator;
	int denominator;
	
	public ComboNumberFraction(ComboNumber numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	//finds mixed fraction form of a combonumberfraction
	public ExpansionFractionObject getExpansion() {
		int expansionNumber = 0;
		while(numerator.value() > denominator) {
			numerator.integer = numerator.integer - denominator;
			expansionNumber++;
		}
		
		//System.out.println(expansionNumber + " + " + numerator + "/" + denominator);
		return new ExpansionFractionObject(new ComboNumberFraction(numerator, denominator), expansionNumber);
	}
	
	public ComboNumberFraction inverse() {
		int multiplier = this.denominator;
		ComboNumber numerator = new ComboNumber(this.numerator.sqrt, -this.numerator.integer);
		int denominator = this.numerator.sqrt.number - (this.numerator.integer * this.numerator.integer);
		
		//ASSUME perfectly divides:
		denominator = denominator / multiplier;
		
		return new ComboNumberFraction(numerator, denominator);
	}
}

class ComboNumber {
	
	SqrtNumber sqrt;
	int integer;
	//e.g. sqrt(23) + 4
	public ComboNumber(SqrtNumber sqrt, int integer) {
		this.sqrt = sqrt;
		this.integer = integer;
	}
	
	//Calculates 1/ComboNumber
	public ComboNumberFraction inverse() {
		ComboNumber numerator = new ComboNumber(sqrt, -integer);
		int denominator = sqrt.number - (integer * integer);
		return new ComboNumberFraction(numerator, denominator);
	}
	
	public double value() {
		return sqrt.doubleValue() + integer;
	}
	
	@Override
	public String toString() {
		return sqrt.toString() + (integer >= 0 ? "+ " + integer : integer);
	}
}

/**
 * Represents a square root number (e.g. sqrt(23))
 * @author Jorel
 *
 */
@SuppressWarnings("serial")
class SqrtNumber extends Number implements Comparable<Number> {
	
	int number;
	double value;
	
	/**
	 * Constructor for a square root number.
	 * @param number The number to square root. e.g. SqrtNumber(23) = sqrt(23)
	 */
	public SqrtNumber(int number) {
		this.number = number;
		value = Math.sqrt(number);
	}
	
	/**
	 * Gets the smallest integer n such that n^2 < sqrt(number) AND (n+1)^2 > sqrt(number) 
	 * @return
	 */
	public int getLowestRoot() {
		for(int i = 1; i <= number; i++) {
			if(i * i > number) {
				return i-1;
			}
		}
		return number;
	}
	
	public boolean isRational() {
		return Utils.isInteger(value);
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return (float) value;
	}

	@Override
	public int intValue() {
		return (int) value;
	}

	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public int compareTo(Number o) {
		return new Double(value).compareTo(o.doubleValue());
	}
	
	@Override
	public String toString() {
		return "sqrt(" + number + ")";
	}
	
}