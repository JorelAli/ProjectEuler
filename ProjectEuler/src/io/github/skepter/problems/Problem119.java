package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem119 extends RT {

	/* https://projecteuler.net/problem=119 */
	public static void main(final String[] args) {
		int max = Integer.MAX_VALUE;
		int count = 0;
		for(int i = 10; i < max; i++) {
			if(i % Utils.sumOfDigits(i) == 0) {
				if(Utils.isInteger(Math.log(i) / Math.log(Utils.sumOfDigits(i)))) {
					count++;
					System.out.println(count + ": " + i);
					if(count == 30) {
						break;
					}
				}
			}
		}

		uptime();
	}
}
