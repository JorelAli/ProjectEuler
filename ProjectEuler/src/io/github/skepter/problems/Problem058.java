package io.github.skepter.problems;

import java.util.Set;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.RT;

public class Problem058 extends RT {

	/*
	 * https://projecteuler.net/problem=58
	 * 
	 * Primes generated 22861 Program took 04 minutes, 41 seconds, 538
	 * milliseconds
	 * 
	 */
	public static void main(final String[] args) {

		Set<Integer> primes = SieveWithBitset.getPrimes(500000000);
		System.out.println("Primes generated");

		// int gridSize = 7;

		for (int gridSize = 7;; gridSize++) {
			long count = 1;
			long primeCount = 0;
			int previousNumber = 1;
			for (int increment = 2; increment <= (gridSize - 1); increment += 2) {
				// System.out.println("Incrementing by " + increment);
				for (int i = 0; i < 4; i++) {
					// System.out.println(previousNumber);
					previousNumber += increment;
					// System.out.println(previousNumber);

					if (primes.contains(previousNumber)) {
						primeCount++;
					}
					count++;
				}
			}

			// System.out.println("Grid size: " + gridSize + " - " + (double)
			// primeCount / (double) count);
			if ((double) primeCount / (double) count < 0.1) {
				System.out.println(gridSize);
				break;
			}

		}

		uptime();
	}
}
