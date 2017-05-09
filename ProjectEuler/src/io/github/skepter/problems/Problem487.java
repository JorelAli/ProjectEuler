package io.github.skepter.problems;

import io.github.skepter.utils.Incomplete;
import io.github.skepter.utils.RT;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem487 extends RT implements Incomplete {

	//	Let fk(n) be the sum of the kth powers of the first n positive integers.
	//
	//	For example, f2(10) = 1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2 + 7^2 + 8^2 + 9^2 + 10^2 = 385.
	//
	//	Let Sk(n) be the sum of fk(i) for 1 ≤ i ≤ n. For example, S4(100) = 35375333830.
	//
	//	What is ∑ (S10000(10^12) mod p) over all primes p between 2x10^9 and 2x10^9 + 2000?

	static Map<Integer, BigInteger> valueToAddCache = new HashMap<Integer, BigInteger>();
	static Map<Integer, BigInteger> functionFCache = new HashMap<Integer, BigInteger>();

	public static void main(final String[] args) {
		System.out.println(functionS(4, 100));
		System.out.println(functionS(2, 10));
		//		System.out.println(functionS(10000, 1000000000000L));
		uptime();

	}

	//create a cache of functionF's results

	public static BigInteger functionF(final int exponent, final int max) {
		BigInteger count = BigInteger.ZERO;
		for (int i = 1; i <= max; i++) {
			final BigInteger valueToAdd = new BigInteger(String.valueOf(i));
			//			count = count.add(valueToAdd.pow(k));
			count = count.add(valueToAddCache.computeIfAbsent(i, value -> valueToAdd.pow(exponent)));

			//			System.out.println(count);
		}
		return count;
	}

	public static BigInteger functionS(final int fExponent, final long max) {
		BigInteger count = BigInteger.ZERO;
		for (int i = 1; i <= max; i++) {
			//count = count.add(functionF(fExponent, i));
			final int iClone = i;
			count = count.add(functionFCache.computeIfAbsent(i, value -> {
				return functionF(fExponent, iClone);
			}));
		}
		return count;
	}

	public static BigInteger finalFunction() {
		return null;
	}
}
