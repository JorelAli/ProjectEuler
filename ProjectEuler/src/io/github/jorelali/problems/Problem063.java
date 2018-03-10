package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem063 extends RT {

	/*
	 * https://projecteuler.net/problem=63 
	 * Program took 103 milliseconds
	 */
	public static void main(final String[] args) {
		// floor(log(x^y)) + 1 == length(x^y)
		int max = 1000;
		int count = 0;
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				if (Utils.lengthOfNumber(i, j) == j) {
					count++;
				}
			}
		}
		System.out.println(count);
		uptime();
	}
}
