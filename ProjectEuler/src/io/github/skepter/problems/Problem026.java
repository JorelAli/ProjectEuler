package io.github.skepter.problems;

import java.math.BigInteger;
import java.util.Set;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.fractions.BigBigFraction;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem026 extends RT {

	/*
	 * https://projecteuler.net/problem=26
	 * 
	 * Find the value of d < 1000 for which 1/d contains the longest recurring
	 * cycle in its decimal fraction part. Program took 235 milliseconds
	 * 
	 */
	public static void main(final String[] args) {
		// https://www.quora.com/What-determines-the-number-of-digits-for-recurring-decimals/answer/Anders-Kaseorg?srid=Acs0

		int maxLength = 0;
		int maxValue = 0;

		Set<Integer> primes = Utils.convertListToSet(SieveWithBitset.sieveOfEratosthenes(1000));
		primes.remove(2);
		primes.remove(5);
		for (int i = 1; i < 1000; i++) {
			if (primes.contains(i)) {
				for (int pow = 1; pow <= 1000; pow++) {

					BigInteger nines = BigInteger.TEN.pow(pow).subtract(BigInteger.ONE);
					BigBigFraction fraction = new BigBigFraction(BigInteger.ONE, BigInteger.valueOf(i));
					if (fraction.multiply(BigBigFraction.valueOf(nines)).simplify().getDenominator()
							.longValue() == 1L) {
						if (pow > maxLength) {
							maxLength = pow;
							maxValue = i;
						}
						// System.out.println(i + ", " + pow);
						break;
					}

					// if(Utils.isInteger((Math.pow(10, pow) -1) * 1D/i)) {
					// System.out.println(i + ", " + pow);
					// if(pow > maxLength) {
					// maxLength = pow;
					// maxValue = i;
					// }
					// break;
					// }

				}
			}
		}
		System.out.println(maxValue);
		uptime();
	}
}
