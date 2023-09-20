package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;

public class Problem073 extends RT {

	/* https://projecteuler.net/problem=73
	 * 
	 * How many fractions lie between 1/3 and 1/2 in the sorted set
	 * of reduced proper fractions for d <= 12,000?
	 * 
	 * https://en.wikipedia.org/wiki/Farey_sequence
	 * 
	 * Using the implementation of the farey sequence generator
	 * from https://en.wikipedia.org/wiki/Farey_sequence#Next_term
	 * converted to Java. You have to make sure you keep track of
	 * the "old" values so you don't mangle everything up, unlike
	 * Python that can handle it with tuples.
	 * 
	 * Program took 143 milliseconds
	 */
	
	// I originally wrote this for problem 72 but didn't even need it
	// Glad I needed it this time!
	public static void fareySequence(int n, boolean descending) {
		int a = 0;
		int b = 1;
		int c = 1;
		int d = n;

		if (descending) {
			a = 1;
			c = n - 1;
		}

		int count = 0;
		boolean startCounting = false;

		int k = 0;
		while (c <= n) {
			k = (n + b) / d;

			int oldA = a;
			int oldB = b;
			int oldC = c;
			int oldD = d;

			a = oldC;
			b = oldD;
			c = k * oldC - oldA;
			d = k * oldD - oldB;
			if (a == 1 && b == 2) {
				startCounting = false;
				break;
			}
			if (startCounting) {
				count++;
			}
			if (a == 1 && b == 3) {
				startCounting = true;
			}
		}

		System.out.println(count);
	}
	
	public static void main(final String[] args) {
		fareySequence(12000, false);
		uptime();
		
	}
}
