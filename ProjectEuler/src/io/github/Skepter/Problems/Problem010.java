package io.github.Skepter.Problems;
import io.github.Skepter.ForeignUtils.SieveWithBitset;
import io.github.Skepter.Utils.RT;

import java.math.BigInteger;
import java.util.List;

public class Problem010 extends RT {

	/* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.*/
	
	/** Method doesn't work as int isn't big enough */
	
	//1179908154
	//142913828922
    //644323ms, 644s
//	public static void main(String[] args) {
//		final long before = System.currentTimeMillis();
//		int count = 0;
//		for (int i = 2; i < 2000000; i++) {
//			if (isPrime(i)) {
//				count += i;
//				System.out.println(i);
//			}
//		}
//		System.out.println(count);
//		final long after = System.currentTimeMillis() - before;
//		System.out.println(after + "ms, " + (after / 1000) + "s");
//	}
//
//	static boolean isPrime(int n) {
//		for (int i = 2; i < n; i++)
//			if (n % i == 0)
//				return false;
//		return true;
//	}
	
	public static void main(final String[] args) {
		begin();
		final List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(20000000);
		BigInteger bi = BigInteger.ZERO;
		for(final int i : primes)
			bi = bi.add(new BigInteger(String.valueOf(i)));
		System.out.println(bi);
		end();
	}
}
