package io.github.Skepter;

import java.math.BigInteger;

public class Problem487 {

	//	Let fk(n) be the sum of the kth powers of the first n positive integers.
	//
	//	For example, f2(10) = 1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2 + 7^2 + 8^2 + 9^2 + 10^2 = 385.
	//
	//	Let Sk(n) be the sum of fk(i) for 1 ≤ i ≤ n. For example, S4(100) = 35375333830.
	//
	//	What is ∑ (S10000(10^12) mod p) over all primes p between 2x10^9 and 2x10^9 + 2000?
	public static void main(final String[] args) {
		//		System.out.println(functionF(2, 10));
		//		System.out.println(functionS(4, 100));

		//		System.out.println(functionS(10000, 1));
		System.out.println(functionS(4, 50));
	}

	public static BigInteger functionF(final int k, final int n) {
		BigInteger count = BigInteger.ZERO;
		for (int i = 1; i <= n; i++) {
			final BigInteger valueToAdd = new BigInteger(String.valueOf(i));
			count = count.add(valueToAdd.pow(k));
			/*
			 * What you want to do here is take the last few numbers, add them up
			 * and then use those for the next ones 
			 * and then you're reducing calculation amount and thus
			 * speeding up the final output
			 */
			System.out.println(count);
		}
		return count;
	}

	public static BigInteger functionS(final int k, final long n) {
		BigInteger count = BigInteger.ZERO;
		for (int i = 1; i <= n; i++)
			count = count.add(functionF(k, i));
		return count;
	}

	public static BigInteger finalFunction() {
		return null;
	}
}
