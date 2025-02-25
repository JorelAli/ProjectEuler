package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.fractions.Fraction;

public class BonusProblem001 extends RT {

	// Find sum of all multiples of 3 and 5 up to infinity
	// 060ms
	public static void main(final String[] args) {
		System.out.println(sum(3).add(sum(5)).subtract(sum(15)).simplify());
		uptime();
	}
	
	public static Fraction sum(int k) {
		return new Fraction(-1, 12).multiply(k);
	}
}
