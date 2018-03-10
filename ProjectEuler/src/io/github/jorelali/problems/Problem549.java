
package io.github.jorelali.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

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
	 * 
	 * https://en.wikipedia.org/wiki/Kempner_function
	 * https://oeis.org/A002034
	 */
	
	public static void main(String[] a) {
		//Attempt 2.
		
		int maxN = 100_000_000;
		
		primes = SieveWithBitset.getPrimes(maxN);
		primeList = SieveWithBitset.sieveOfEratosthenes(maxN);
	}
	
	static List<Integer> primeList;
	
	static int kempner(int n) {
		//If prime, return n;
		if(primes.contains(n)) {
			return n;
		} else {
			Map<Integer, Integer> primeFactors = Utils.getPrimeFactorMap(n, primeList);
			if(primeFactors.size() == 1) {
				//Fancy pancy
				if(primeFactors.keySet().stream().findAny().get() > primeFactors.values().stream().findAny().get()) {
					return primeFactors.keySet().stream().findAny().get() * primeFactors.values().stream().findAny().get();
				} else {
					//do the weird factorize 16 into 6 or something
					return -1;
				}
			} else {
				//If all of the primes are distinct...
				if(primeFactors.values().stream().mapToInt(i -> i).sum() == primeFactors.values().size()) {
					//Return max prime
					return primeFactors.keySet().stream().mapToInt(i -> i).max().getAsInt();
				} else {
					//If they are in ascending order
					Set<Integer> filteredPrimes = filterPrimes(primeFactors.keySet().stream().mapToInt(i -> i).max().getAsInt());
					filteredPrimes.removeAll(primeFactors.keySet());
					if(filteredPrimes.isEmpty()) {
						//fancy formula for thing (max pu * eu)
						int maxPuEu = 0;
						for(Entry<Integer, Integer> e : primeFactors.entrySet()) {
							maxPuEu = e.getKey() * e.getValue();
						}
						return maxPuEu;
					} else {
						//Not in ascending order
						return 0;
					}
				}
				//if they're in ascending order~
			}
		}
		
//		a(1) = 1.
//
//				a(n!) = n.
//
//				a(p) = p for p prime.
//
//				a(p1*p2*...*pu) = pu if p1 < p2 < ... < pu are distinct primes.
//
//				a(p^k) = p*k for p prime and k<=p.
	}
	
	
	
	
	static Set<Integer> primes;
	
	/** Gets primes <= max */
	static Set<Integer> filterPrimes(int max) {
		return primes.stream().filter(i -> i <= max).collect(Collectors.toSet());
	}
	
	
//	Attempt 1
//	
//	public static void main(final String[] args) {
//		
//		
//		/*
//		 * So, what if we don't actually have to calculate the factorials in the first place?
//		 * For example, take n = 10;
//		 * s(n) = 5.
//		 * That means that out of this set {1, 2, 3, ... 10}, 5 is the largest value
//		 * which, when multiplied by everything below it equals 10. That also means that
//		 * 10 divides 2 * 5. (because when we have the set {1, 2, 3, 4, 5}, we can use 2 * 5 * k, where k is (1 * 3 * 4) and still get 10).
//		 * 
//		 *  Therefore, we only need to find numbers below n which, when multiplied, are divisible by n.
//		 *  So. When you look at prime numbers for example, the value of s(n) is always n (so s(7) = 7)
//		 *  
//		 *  s(8) = 4 {1, 2, 3, 4, 5, 6, 7, 8}, assume we only go from the midpoint downwards (i.e. it won't be 5, 6, 7 or 8) since
//		 *  8 isn't prime and 5, 6, 7 don't go into 8.
//		 *  
//		 *  s(12) = 4. {1, 2, 3, ... 6}
//		 *  
//		 *  
//		 *  EXCEPT: When you do s(16) = 6. So given our set of numbers below 16: {1, 2, 3, ..., 5, 6, 7, 8, ..., 16}, we discard
//		 *  the midpoint onwards giving us {1, 2, 3, 4, 5, 6, 7, 8}
//		 *  We can take 2 * 8 = 16, OR 2 * 4 * 6 = 48 / 16 = 3. => k = 6
//		 * 
//		 * 
//		 * 16 * n / 8 = 6 where n is a prime number (3)
//		 * Now if you take 12, 12 * n / 6 = 4, where n is a prime number (2)
//		 * 18 * n / 9 = 6, where n = 3
//		 * 
//		 * 
//		 */
//		
//		
//		
//		/* Outline of the function I want to make:
//		 * f:n -> {k, where n|k!} 
//		 * k! >= n
//		 * if n is prime, return n
//		 * 
//		 * if n > 9; k <= n/2
//		 * 
//		 */
//		
//		int maxN = 125;
//		
//		Set<Integer> primes = SieveWithBitset.getPrimes(maxN);
//		
//		int n = 100_000_000;
//		populateFactorials(maxN);
//		
//		//System.out.println(Utils.gcd(16, 6));
//		
//	//	Utils.printMap(Utils.getPrimeFactorMap(16, SieveWithBitset.sieveOfEratosthenes(maxN)));
//		
//		
//		System.out.println("Factorials calculated");
//		//Utils.printMap(factorialMap);
//		
//		for(int i = 2; i <= maxN; i++) {
//			//System.out.print(compute(i) + ", ");
//			//if(!primes.contains(i)) {
////				if(compute(i) > (0.5 * i)) {
////					System.out.println(i + ": " + compute(i) + "! can be divided by " + i);
////				}
//				System.out.println(i + ": " + compute(i) + "! can be divided by " + i);
//			//}
//		}
//		
//		//System.out.println(compute(12));
//		
////		int sum = 0;
////		for(int i = 2; i <= n; i++) {
////			sum += compute((long) i);
////		}
////		System.out.println(sum);
//		
//		//System.out.println(compute(100));
////		
////		assert s(10) == 5;
////		assert s(25) == 10;
////		//assert S(100) == 2012;
////		System.out.println(S(100));
//		uptime();
//	}
//	
//	static long compute(long n) {
//		//for(int i = 2; i <= n ; i++) {
//			for(Entry<Long, BigInteger> entry : factorialMap.entrySet()) {
//				if(entry.getValue().mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
//					return entry.getKey();
//				}
//			}
//		//}
//		throw new RuntimeException("Not enough factorials calculated for " + n);
//		
//	}
//	
//	static Map<Long, BigInteger> factorialMap = new HashMap<Long, BigInteger>();
//	
//	public static void populateFactorials(long max) {
//		BigInteger sum = BigInteger.ONE;
//		for(long i = 1; i <= max; i++) {
//			try {
//				sum = sum.multiply(BigInteger.valueOf(i));
//				factorialMap.put(i, sum);
//			} catch (OutOfMemoryError e) {
//				System.out.println(i);
//				throw e;
//			}
//		}
//	}
//	
//	
//	public static long S(long n) {
//		int count = 0;
//		for(int i = 2; i <= n; i++) {
//			long val = s(i);
//			count += val;
//		}
//		return count;
//	}
//	
//	public static long s(long n) {
//		return s.computeIfAbsent(n, (key) -> {
//			for(long m = 2;; m++)
//				if(Utils.factorial(m) % key == 0)
//					return m;
//		});
//		
//	}
}
