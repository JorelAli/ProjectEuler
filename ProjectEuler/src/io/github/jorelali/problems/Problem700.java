package io.github.jorelali.problems;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;

import io.github.jorelali.utils.RT;

public class Problem700 extends RT {

	public static BigInteger sequence(int n) {
		BigInteger a = new BigInteger("1504170715041707");
		BigInteger b = new BigInteger("4503599627370517"); // note that this number is prime!

		return a.multiply(new BigInteger(n + "")).mod(b);
	}

	/**/
	public static void main(final String[] args) {
		Set<BigInteger> eulerCoins = new LinkedHashSet<>();
//		eulerCoins.add(new BigInteger("1504170715041707"));

		BigInteger count = BigInteger.ZERO;
		int numCoins = 1;
		for (int i = 1;; i++) {
			BigInteger nextSequence = sequence(i);

			boolean smallerThanAllOtherEulerCoins = true;

			for (BigInteger eulerCoin : eulerCoins) {
				if (nextSequence.compareTo(eulerCoin) >= 0) {
					smallerThanAllOtherEulerCoins = false;
					break;
				}
			}

			if (smallerThanAllOtherEulerCoins) {
				eulerCoins.add(nextSequence);
				count = count.add(nextSequence);
				System.out.println(i + ": " + nextSequence);
				numCoins++;

				// assume this is the end?
				if (nextSequence.equals(BigInteger.valueOf(15806432))) {
					break;
				}
			}
		}
		System.out.println(count);
		uptime();
	}
}
