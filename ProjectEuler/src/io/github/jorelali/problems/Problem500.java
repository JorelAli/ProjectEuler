package io.github.jorelali.problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;

public class Problem500 extends RT {

	/*
	 * http://primes.utm.edu/glossary/xpage/tau.html
	 * https://www.desmos.com/calculator/pkeexjjmay
	 */
	public static void main(final String[] args) {
		List<Integer> primes = SieveWithBitset.getPrimes(7373522);
		System.out.println("ye");
		
//		List<Integer> primes = ManyPrimeGenerator.getPrimes(500500);
		System.out.println(primes.get(primes.size() - 1));
		int result = 1;
		for(int prime : primes) {
			result *= prime % 500500507;
		}
		System.out.println(result);
		//System.out.println(c.mod(BigInteger.valueOf(500500507L))); //345013280
		//System.out.println(BigInteger.valueOf(2).modPow(BigInteger.valueOf(2).pow(500500).subtract(BigInteger.ONE), BigInteger.valueOf(500500507))); //339969113
		
//		int CONST = 50000;
//		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(CONST);
//		
//		for(int i = 2; i <= 2500; i++)
//			System.out.println(i + ": " + getDivisors(i, primes));
		
//		System.out.println(primes.size());
//		System.out.println("Primes generated");
		
//		BigInteger number = BigInteger.ONE;
//		
//		int count = 0;
//		
//		for(int i = 2; count <= 500500 ; i++) {
//			if(BigInteger.valueOf(i).isProbablePrime(1)) {
//				//System.out.println(i);
//				number = number.multiply(BigInteger.valueOf(i));
//				count++;
//			}
//		}
//		System.out.println("done");
//		System.out.println(number.mod(BigInteger.valueOf(500500507)));
		
//		Utils.printMap(getPrimeFactorTable(120, primes));
		
	//	System.out.println(BigInteger.valueOf(2).pow(500500).mod(BigInteger.valueOf(500500507))); //339969113
		
		

		//System.out.println(BigInteger.valueOf(2).pow(500500 - 1).subtract(BigInteger.ONE).mod(BigInteger.valueOf(500500507)));

		//Utils.printMap(getPrimeFactorTable(BigInteger.valueOf(2).pow(500500 - 200).subtract(BigInteger.ONE), primes));
		
		//System.out.println(BigInteger.valueOf(2).pow(500500).subtract(BigInteger.valueOf(16)).multiply(BigInteger.valueOf(30)).add(BigInteger.valueOf(120)).mod(BigInteger.valueOf(500500507)));
		
		
		//System.out.println(getDivisors(355308955, primes));
		
		
		
//		for(int i = 2; i <= CONST; i++) {
//			System.out.println(i + "\t" + getDivisors(i, primes));
//			if(getDivisors(i, primes) >= 16) {
//				System.out.println("--- " + i + " ---");
//				Utils.printMap(getPrimeFactorTable(i, primes));
//				System.out.println("--- --- ---");
//			}
//		}
		
		//Utils.printMap(getPrimeFactorTable(240, primes));
		
		//System.out.println(getDivisors(4200, SieveWithBitset.sieveOfEratosthenes(4200)));
		uptime();
	}
	
	/**
	 * Uses the multiplicative function for finding divisors of a number (see
	 * http://primes.utm.edu/glossary/xpage/tau.html)
	 * 
	 * Uses a reduction method to perform the function.
	 */
	public static int getDivisors(int input, List<Integer> primes) {
		return getPrimeFactorTable(input, primes).values().stream().reduce(1, (a, b) -> (a * (b + 1)));
	}
	
	/**
	 * Creates a table which consists of the prime factors of a number and the
	 * number of occurances that prime factor appears.<br><br>
	 * 
	 * For example, 4200 has prime factors of 2, 2, 2, 3, 5, 5, 7.<br>
	 * Therefore, it will consist of a table of:<br>
	 * 2 -> 3<br>
	 * 3 -> 1<br>
	 * 5 -> 2<br>
	 * 7 -> 1
	 */
	public static Map<Integer, Integer> getPrimeFactorTable(int input, List<Integer> primes) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : primes) {
			while (input % i == 0) {
				if(map.containsKey(i)) {
					map.put(i, map.get(i) + 1);
				} else {
					map.put(i, 1);
				}
				input /= i;
			}
		}
		return map;
	}
	
	public static Map<Integer, Integer> getPrimeFactorTable(BigInteger input, List<Integer> primes) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : primes) {
			while (input.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
				if(map.containsKey(i)) {
					map.put(i, map.get(i) + 1);
				} else {
					map.put(i, 1);
				}
				input = input.divide(BigInteger.valueOf(i));
			}
		}
		return map;
	}
	
}
