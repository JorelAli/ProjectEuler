package io.github.Skepter.Problems;

import java.util.ArrayList;
import java.util.List;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem037 extends RT {

	/*
	 * https://projecteuler.net/problem=37 The number 3797 has an interesting
	 * property. Being prime itself, it is possible to continuously remove
	 * digits from left to right, and remain prime at each stage: 3797, 797, 97,
	 * and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from
	 * left to right and right to left.
	 * 
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 */
	public static void main(final String[] args) {
		List<Integer> primes = new ArrayList<Integer>();
		for(int i = 10; i <= 10000; i++) {
			if(Utils.isPrime(i)) {
				primes.add(i);
			}
		}
		//Utils.printListSingleLine(primes);
		
		for(int i : primes) {
			int truncatedValue = Integer.parseInt(String.valueOf(i).substring(0, String.valueOf(i).length() - 1));
			if(Utils.isPrime(truncatedValue)) {
				System.out.println(i + ": " + truncatedValue);
			}
		}
		uptime();
	}
}
