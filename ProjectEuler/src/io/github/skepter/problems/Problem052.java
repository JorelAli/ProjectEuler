package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem052 extends RT {

	/*
	 * https://projecteuler.net/problem=52 It can be seen that the number,
	 * 125874, and its double, 251748, contain exactly the same digits, but in a
	 * different order.
	 * 
	 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
	 * contain the same digits.
	 * 
	 * Program took 114 milliseconds
	 */
	public static void main(final String[] args) {
		for (int i = 1;; i++) {

			if (Utils.isPermutation(i, 2 * i) && Utils.isPermutation(i, 3 * i) && Utils.isPermutation(i, 4 * i)
					&& Utils.isPermutation(i, 5 * i) && Utils.isPermutation(i, 6 * i)) {
				System.out.println(i);
				uptime();
				return;
			}
		}
	}
}
