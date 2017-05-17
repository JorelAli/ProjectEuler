package io.github.skepter.problems;

import io.github.skepter.utils.RT;

public class Problem063 extends RT {

	/*
	 * https://projecteuler.net/problem=63 
	 * Program took 573 milliseconds
	 */
	public static void main(final String[] args) {
		// floor(log(x^y)) + 1 == length(x^y)
		int max = 1000;
		int count = 0;
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				if (Math.floor(Math.log10(Math.pow(i, j))) + 1 == j) {
					count++;
				}
			}
		}
		System.out.println(count);
		uptime();
	}
}
