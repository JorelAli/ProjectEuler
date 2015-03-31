package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;

import java.math.BigInteger;

public class Problem015 extends RT {

	/*Starting in the top left corner of a 2×2 grid, 
	 * and only being able to move to the right and down, 
	 * there are exactly 6 routes to the bottom right corner.


	How many such routes are there through a 20×20 grid?*/

	/*
	 * Solution = 40C20
	 */
	public static void main(final String[] args) {
		System.out.println(combinations(40, 20));
		uptime();
	}

	static BigInteger combinations(final int N, final int r) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < r; k++) {
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(BigInteger.valueOf(k + 1));
		}
		return ret;
	}
}
