package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem038 extends RT {

	/* https://projecteuler.net/problem=38 
	 * Program took 483 milliseconds */
	public static void main(final String[] args) {
		long maxValue = 0;
		for(int i = 1; i<= 100000; i++) {
			if(String.valueOf(i).startsWith("9")) {
				String concatenation = "";
				for(int j = 1; j <= 10; j++) {
					concatenation = concatenation + (i*j);
					if(Utils.isNPandigital(concatenation, 1, 9)) {
						if(Long.valueOf(concatenation) > maxValue) {
							maxValue = Long.valueOf(concatenation);
						}
					}
				}
			}
		}
		System.out.println(maxValue);
		uptime();
	}
}
