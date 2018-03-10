package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem053 extends RT {

	/*
	 * https://projecteuler.net/problem=53 Combinatoric selections
	 */
	public static void main(final String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= i; j++) {
				if (Utils.combinations(i, j).toString().length() > 6) {
					count++;
				}
			}
		}
		System.out.println(count);
		uptime();
	}
}
