package io.github.skepter.problems;

import java.math.BigInteger;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.fractions.BigBigFraction;

public class Problem057 extends RT {

	/* https://projecteuler.net/problem=57 */
	public static void main(final String[] args) {	
		int count = 0;
		for(int i = 1; i <= 1000; i++) {
			String fraction = getExpansion(i).toString();
			if(fraction.split("/")[0].length() > fraction.split("/")[1].length()) {
				count++;
			}
		}
		System.out.println(count);
		uptime();
	}
	
	private static BigBigFraction getExpansion(int max) {
		BigBigFraction fraction = new BigBigFraction(BigInteger.ONE, BigInteger.valueOf(2L));
		for(int i = 0; i <= (max-2); i++) {
			fraction.add(new BigBigFraction(BigInteger.valueOf(2L), BigInteger.valueOf(1)));
			fraction.flip();
		}
		fraction.add(new BigBigFraction(BigInteger.ONE, BigInteger.ONE));
		return fraction;
	}
}
