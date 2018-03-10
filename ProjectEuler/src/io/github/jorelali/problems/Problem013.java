package io.github.jorelali.problems;

import java.math.BigInteger;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem013 extends RT {

	/* Find the first 10 digits of the sum of the baseString */
	public static void main(final String[] args) {
		BigInteger count = BigInteger.ZERO;
		for(String str : Utils.readFromFile("p013_numbers.txt")) {
			count = count.add(new BigInteger(str));
		}
		System.out.println(count.toString().substring(0, 10));
		uptime();
	}
}
