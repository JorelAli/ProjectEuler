package io.github.skepter.problems;

import io.github.skepter.utils.Incomplete;
import io.github.skepter.utils.RT;

public class Problem012 extends RT implements Incomplete {

	//What is the value of the first triangle number to have over five hundred divisors?
	public static void main(final String[] args) {
		//calculate triangle numbers
		//1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
		// 1 + 2 + 3 + 4 + 5 + 6 etc.

		int count = 0;
//		int max = 0;

		int numberOfFactors = 0;
		for (int i = 1;; i++) {
			count += i;

			if (numberOfFactors < getFactors(count)) {
				numberOfFactors = getFactors(count);
			}

			if (getFactors(count) >= 500) {
//				max = i;
				break;
			}
		}
//		System.out.println(getFactors(count) + " factors");
//		System.out.println(max + "th term: " + count);
		System.out.println(count);
		uptime();
	}

	public static int getFactors(int j) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(j); i++) {
			if ((j % i) == 0) {
				count++;
			}
		}
		return count *= 2;
	}
}
