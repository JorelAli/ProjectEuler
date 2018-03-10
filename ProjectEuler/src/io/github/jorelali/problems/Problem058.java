package io.github.jorelali.problems;

import java.util.HashSet;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;

public class Problem058 extends RT {

	/*
	 * https://projecteuler.net/problem=58
	 * 
	 */

	/*
	 * Produces a set of the numbers in the diagonals for a set grid size
	 * (For example, grid size 7 will produce a set containing:
	 * 1, 3, 5, 7, 9,
	 * 13, 17, 21, 25,
	 * 31, 37, 43, 49
	 * 
	 * Program took 04 minutes, 05 seconds, 464 milliseconds

	 */
	static Set<Integer> diagonalList(int gridSize) {
		Set<Integer> diagonalSet = new HashSet<>();
		int previousNumber = 1;
		diagonalSet.add(previousNumber);
		for (int increment = 2; increment <= (gridSize - 1); increment += 2) {
			for (int i = 0; i < 4; i++) {
				previousNumber += increment;
				diagonalSet.add(previousNumber);
			}
		}
		return diagonalSet;
	}
	
	static boolean isPrime(int i) {
		return primes.contains(i);
	}
	
	static Set<Integer> primes;
	
	public static void main(final String[] args) {
		
		/*
		 * Step plan:
		 * Produce the list of diagonal lines
		 * Check how many of them are prime.
		 * Profit?
		 */
		
		System.out.println(diagonalList(15141).stream().mapToInt(i -> i).max().getAsInt());
		boolean ye = true;
		
		if (ye) {
			//generate primes up to 500 million
			/* 
			 * 22861^2 = 522,625,321
			 */
			primes = SieveWithBitset.getPrimesAsSet(1_000_000_000);
			System.out.println("Primes generated");
			uptime();
			for (int i = 7;; i++) {
				Set<Integer> set = diagonalList(i);
				// Number of prime numbers in the set
				long primeNumbers = set.stream().filter(Problem058::isPrime).count();
				long setSize = set.size();
				double percent = (100 * (double) primeNumbers / (double) setSize);
				System.out.println("Grid size " + i + ": " + primeNumbers + "/" + setSize + " ≈ " + percent + "%");
				if (percent < 10) {
					break;
				}
			}
		}
		uptime();
		
		//First attempt
//		Set<Integer> primes = SieveWithBitset.getPrimes(10);
//		System.out.println("Primes generated");
//
//		// int gridSize = 7;
//
//		for (int gridSize = 7;; gridSize++) {
//			long count = 1;
//			long primeCount = 0;
//			int previousNumber = 1;
//			for (int increment = 2; increment <= (gridSize - 1); increment += 2) {
//				// System.out.println("Incrementing by " + increment);
//				for (int i = 0; i < 4; i++) {
//					// System.out.println(previousNumber);
//					previousNumber += increment;
//					// System.out.println(previousNumber);
//
//					if (primes.contains(previousNumber)) {
//						primeCount++;
//					}
//					count++;
//				}
//			}
//
//			System.out.println("gridSize: " + gridSize + ", ratio: " + (((double) primeCount / (double) count) * 100));
//			
//			// System.out.println("Grid size: " + gridSize + " - " + (double)
//			// primeCount / (double) count);
//			if ((double) primeCount / (double) count < 0.1) {
//				System.out.println(gridSize);
//				break;
//			}
//
//		}
//
//		uptime();
	}
}
