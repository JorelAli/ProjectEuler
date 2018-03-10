package io.github.jorelali.problems;

import java.math.BigInteger;

import io.github.jorelali.utils.RT;

public class Problem466 extends RT {

	/* https://projecteuler.net/problem=466 */
	public static void main(final String[] args) {
		BigInteger count = BigInteger.ZERO;
		int baseVertical = 64;
		BigInteger baseHorizontal = new BigInteger("10000000000000000");
		//int baseHorizontal = new Double(Math.pow(10, 16)).intValue();
		for(int i = 1; i <= baseVertical; i++) {
			count = count.add(baseHorizontal.subtract(new BigInteger("-1")));
		}
		System.out.println(count);
		uptime();
	}
}
