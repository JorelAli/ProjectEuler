package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.fractions.BigFraction;

public class Problem100 extends RT {

	/**/
	public static void main(final String[] args) {
		for (long l = 1000000000000L;; l++) {
			/*
			 * 21/1.4 = 15
			 * (85+35)/1.4 = 85.714
			 * 
			 * 10^12/1.4 = 714,285,714,286 <<-- Check for values of a around here
			 */
			
			long a = 500000000000L;
			BigFraction fraction = new BigFraction(1, (l * (l - 1)));
			BigFraction fraction2 = new BigFraction(a * (a - 1), 1);
			if(fraction.multiply(fraction2).equals(new BigFraction(1,2))) {
				System.out.println(a);
				break;
			}
		}
		uptime();
	}
}
