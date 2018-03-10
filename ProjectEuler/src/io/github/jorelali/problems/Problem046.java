package io.github.jorelali.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.Incomplete;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem046 extends RT implements Incomplete {

	/*
	 * It was proposed by Christian Goldbach that every odd composite number can
	 * be written as the sum of a prime and twice a square.
	 * 
	 * 9 = 7 + 2�12 15 = 7 + 2�22 21 = 3 + 2�32 25 = 7 + 2�32 27 = 19 + 2�22 33
	 * = 31 + 2�12
	 * 
	 * It turns out that the conjecture was false.
	 * 
	 * What is the smallest odd composite that cannot be written as the sum of a
	 * prime and twice a square?
	 * 
	 * Program took 120 milliseconds
	 */
	public static void main(final String[] args) {
		int max = 100000;
		// http://stackoverflow.com/a/32552348/4779071
		// Contains for a HashSet is O(1) compared to O(n) for a list, therefore
		// you should never use a list if you often need to run contains.
		Set<Integer> squares = computeSquares(max);
		Set<Integer> primeSet = Utils.convertListToSet(SieveWithBitset.sieveOfEratosthenes(max));
		List<Integer> primeList = SieveWithBitset.sieveOfEratosthenes(max);
		for (int i = 3; i <= max; i+=2) {
			if (!primeSet.contains(i)) {
				boolean satisfy = false;
				checkifSuitsConjecture:
				for(int prime : primeList) {
					if(prime < i) {
						if(squares.contains(((i - prime)/2)) && i == prime + 2*((i - prime)/2)) {
							satisfy = true;
//							System.out.println(i + " = " + prime + " + 2*" + ((i - prime)/2));
							break checkifSuitsConjecture;
						}
					}
				}
				if(!satisfy) {
					System.out.println(i);
					break;
				}
			}
		}
		uptime();
	}

	public static Set<Integer> computeSquares(int max) {
		Set<Integer> squares = new HashSet<Integer>();
		for(int i = 0; i <= max; i++) {
			squares.add(i*i);
		}
		return squares;
	}
}
