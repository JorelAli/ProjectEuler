
package io.github.skepter.problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem549 extends RT {

	static Map<Long, Long> s = new HashMap<Long, Long>();
	
	/*
	 * https://projecteuler.net/problem=549
	 * 
	 * The smallest number m such that 10 divides m! is m=5. The smallest number
	 * m such that 25 divides m! is m=10.
	 * 
	 * Let s(n) be the smallest number m such that n divides m!. So s(10)=5 and
	 * s(25)=10. Let S(n) be ∑s(i) for 2 ≤ i ≤ n. S(100)=2012.
	 * 
	 * Find S(10^8).
	 */
	public static void main(final String[] args) {
		
		
		/*
		 * So, what if we don't actually have to calculate the factorials in the first place?
		 * For example, take n = 10;
		 * s(n) = 5.
		 * That means that out of this set {1, 2, 3, ... 10}, 5 is the largest value
		 * which, when multiplied by everything below it equals 10. That also means that
		 * 10 divides 2 * 5. (because when we have the set {1, 2, 3, 4, 5}, we can use 2 * 5 * k, where k is (1 * 3 * 4) and still get 10).
		 * 
		 *  Therefore, we only need to find numbers below n which, when multiplied, are divisible by n.
		 *  So. When you look at prime numbers for example, the value of s(n) is always n (so s(7) = 7)
		 *  
		 *  s(8) = 4 {1, 2, 3, 4, 5, 6, 7, 8}, assume we only go from the midpoint downwards (i.e. it won't be 5, 6, 7 or 8) since
		 *  8 isn't prime and 5, 6, 7 don't go into 8.
		 *  
		 *  s(12) = 4. {1, 2, 3, ... 6}
		 *  
		 *  
		 *  EXCEPT: When you do s(16) = 6. So given our set of numbers below 16: {1, 2, 3, ..., 5, 6, 7, 8, ..., 16}, we discard
		 *  the midpoint onwards giving us {1, 2, 3, 4, 5, 6, 7, 8}
		 *  We can take 2 * 8 = 16, OR 2 * 4 * 6 = 48 / 16 = 3. => k = 6
		 * 
		 * 
		 * 16 * n / 8 = 6 where n is a prime number (3)
		 * Now if you take 12, 12 * n / 6 = 4, where n is a prime number (2)
		 * 18 * n / 9 = 6, where n = 3
		 * 
		 * 
		 */
		
		
		
		/* Outline of the function I want to make:
		 * f:n -> {k, where n|k!} 
		 * k! >= n
		 * if n is prime, return n
		 * 
		 * if n > 9; k <= n/2
		 * 
		 */
		
		int maxN = 20000;
		
		Set<Integer> primes = SieveWithBitset.getPrimes(maxN);
		
		int n = 100_000_000;
		populateFactorials(maxN);
		
		Utils.printMap(Utils.getPrimeFactorMap(16, SieveWithBitset.sieveOfEratosthenes(maxN)));
		
		
		System.out.println("Factorials calculated");
		//Utils.printMap(factorialMap);
		
		for(int i = 2; i <= maxN; i++) {
			if(!primes.contains(i)) {
//				if(compute(i) > (0.5 * i)) {
//					System.out.println(i + ": " + compute(i) + "! can be divided by " + i);
//				}
		//		System.out.println(i + ": " + compute(i) + "! can be divided by " + i);
			}
		}
		
		//System.out.println(compute(12));
		
//		int sum = 0;
//		for(int i = 2; i <= n; i++) {
//			sum += compute((long) i);
//		}
//		System.out.println(sum);
		
		//System.out.println(compute(100));
//		
//		assert s(10) == 5;
//		assert s(25) == 10;
//		//assert S(100) == 2012;
//		System.out.println(S(100));
		uptime();
	}
	
	static long compute(long n) {
		//for(int i = 2; i <= n ; i++) {
			for(Entry<Long, BigInteger> entry : factorialMap.entrySet()) {
				if(entry.getValue().mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
					return entry.getKey();
				}
			}
		//}
		throw new RuntimeException("Not enough factorials calculated for " + n);
		
	}
	
	static Map<Long, BigInteger> factorialMap = new HashMap<Long, BigInteger>();
	
	public static void populateFactorials(long max) {
		BigInteger sum = BigInteger.ONE;
		for(long i = 1; i <= max; i++) {
			try {
				sum = sum.multiply(BigInteger.valueOf(i));
				factorialMap.put(i, sum);
			} catch (OutOfMemoryError e) {
				System.out.println(i);
				throw e;
			}
		}
	}
	
	
	public static long S(long n) {
		int count = 0;
		for(int i = 2; i <= n; i++) {
			long val = s(i);
			count += val;
		}
		return count;
	}
	
	public static long s(long n) {
		return s.computeIfAbsent(n, (key) -> {
			for(long m = 2;; m++)
				if(Utils.factorial(m) % key == 0)
					return m;
		});
		
	}
}
