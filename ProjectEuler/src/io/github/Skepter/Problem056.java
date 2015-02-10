package io.github.Skepter;

import java.math.BigInteger;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem056 extends RT {

	/*
	 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 
	 * is almost unimaginably large: one followed by two-hundred zeros. Despite their size, 
	 * the sum of the digits in each number is only 1.

	Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?*/
	public static void main(final String[] args) {
		int biggestSum = 0;
		for (int a = 0; a < 100; a++) {
			for (int b = 0; b < 100; b++) {
				/* Loop through a and b to 100*/
				BigInteger i = new BigInteger(String.valueOf(a));
				/* Calculate the power and update biggestSum with the largest sum */
				long newBigSum = Utils.sumOfDigits(i.pow(b).toString());
				if (biggestSum < newBigSum) {
					biggestSum = (int) newBigSum;
				}
			}
		}
		System.out.println(biggestSum);
		uptime();
	}
}
