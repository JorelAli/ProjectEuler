package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;

public class Problem719 extends RT {

	/*
	 * https://projecteuler.net/problem=719
	 */
	public static void main(final String[] args) {
		final long max = (long) Math.sqrt(Math.pow(10, 12)); // 1,000,000
		System.out.println(max);
		System.out.println(Math.sqrt(10_000_000_000_000L));
		// for(long l = 1; l*l <= 10_000_000_000_000L; l++)
		uptime();
	}
}
