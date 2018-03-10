package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;

public class Problem021 extends RT {

	/*Let d(n) be defined as the sum of proper divisors of n 
	 * (numbers less than n which divide evenly into n).
	If d(a) = b and d(b) = a, where a ≠ b, then a and b are an 
	amicable pair and each of a and b are called amicable numbers.

	For example, the proper divisors of 220 are 
	1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
	The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

	Evaluate the sum of all the amicable numbers under 10000.*/
	public static void main(final String[] args) {
		int value = 0;
		for (int i = 1; i < 10000; i++) {
			/* For some reason, these numbers screw up the answer - they 
			 * are amicable with themselves, not a different number*/
			if (i == 6 || i == 28 || i == 496 || i == 8128)
				continue;
			if (isAmicable(i)) {
				value += i;
			}
		}
		System.out.println(value);
		uptime();
	}

	public static boolean isAmicable(int value) {
		int divisors = findDivisors(value);
		return value == findDivisors(divisors) ? true : false;
	}

	public static int findDivisors(int value) {
		int count = 0;
		for (int i = 1; i <= (value / 2); i++) {
			if (value % i == 0) {
				count += i;
			}
		}
		return count;
	}
}
