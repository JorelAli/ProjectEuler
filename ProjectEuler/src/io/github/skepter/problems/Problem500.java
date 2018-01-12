package io.github.skepter.problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem500 extends RT {

	/*
	 * http://primes.utm.edu/glossary/xpage/tau.html
	 * https://www.desmos.com/calculator/pkeexjjmay
	 */
	public static void main(final String[] args) {
		int CONST = 300;
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(CONST);

		//System.out.println(BigInteger.valueOf(2).pow(500500 - 1).subtract(BigInteger.ONE).mod(BigInteger.valueOf(500500507)));

		Utils.printMap(getPrimeFactorTable(BigInteger.valueOf(2).pow(500500 - 200).subtract(BigInteger.ONE), primes));
		
		System.out.println(BigInteger.valueOf(2).pow(500500).subtract(BigInteger.valueOf(16)).multiply(BigInteger.valueOf(30)).add(BigInteger.valueOf(120)).mod(BigInteger.valueOf(500500507)));
		
		
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
		
		//getDivisors(4200, SieveWithBitset.sieveOfEratosthenes(4200));
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
