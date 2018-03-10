package io.github.jorelali.problems;

import java.math.BigDecimal;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

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
			
			String val = Utils.nRootNewtonRaphson(BigDecimal.valueOf(i), BigDecimal.valueOf(Math.sqrt(i)), 2, 1000, 151).toString();
			//https://projecteuler.chat/viewtopic.php?t=1198 Includes the first digit.
			count += Utils.sumOfDigits(val.substring(0,101));
		}
		System.out.println(count);
		uptime();
	}
}
