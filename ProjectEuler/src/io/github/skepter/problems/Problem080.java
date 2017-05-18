package io.github.skepter.problems;

import java.math.BigDecimal;
import java.math.RoundingMode;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem080 extends RT {

	/*
	 * https://projecteuler.net/problem=80
	 * 
	 * It is well known that if the square root of a natural number is not an
	 * integer, then it is irrational. The decimal expansion of such square
	 * roots is infinite without any repeating pattern at all.
	 * 
	 * The square root of two is 1.41421356237309504880..., and the digital sum
	 * of the first one hundred decimal digits is 475.
	 * 
	 * For the first one hundred natural numbers, find the total of the digital
	 * sums of the first one hundred decimal digits for all the irrational
	 * square roots.
	 * 
	 * Program took 183 milliseconds
	 */
	public static void main(final String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if(i == 1 || i == 4 || i== 9 || i== 16 || i== 25 || i== 36 || i== 49 || i== 64 || i== 81 || i== 100) {
				continue;
			}
			
			String val = squareRootNewtonRaphson(BigDecimal.valueOf(i), BigDecimal.valueOf(Math.sqrt(i)), 1000, 150).toString();
			//https://projecteuler.chat/viewtopic.php?t=1198 Includes the first digit.
			count += Utils.sumOfDigits(val.substring(0,101));
		}
		System.out.println(count);
		uptime();
	}

	// https://en.wikipedia.org/wiki/Newton's_method#Examples
	/*
	 * x0 is the inital estimate. Choose 10 if uncertain
	 * x is the value to find the square root for
	 * iterations indicates how many iterations to perform the NewtonRaphson method.
	 */
	public static BigDecimal squareRootNewtonRaphson(BigDecimal x, BigDecimal x0, int iterations, int precision) {
		iterations--;
		if(iterations == 0) {
			return x0;
		} else {
			BigDecimal numerator = x0.multiply(x0).subtract(x);
			BigDecimal denominator = x0.multiply(BigDecimal.valueOf(2));
			BigDecimal x1 = x0.subtract(numerator.divide(denominator, precision, RoundingMode.HALF_DOWN));
			return squareRootNewtonRaphson(x, x1, iterations, precision);
		}
	}
}
