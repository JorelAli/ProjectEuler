package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem049 extends RT {

	/*
	 * https://projecteuler.net/problem=49 The arithmetic sequence, 1487, 4817,
	 * 8147, in which each of the terms increases by 3330, is unusual in two
	 * ways: (i) each of the three terms are prime, and, (ii) each of the
	 * 4-digit numbers are permutations of one another.
	 * 
	 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
	 * primes, exhibiting this property, but there is one other 4-digit
	 * increasing sequence.
	 * 
	 * What 12-digit number do you form by concatenating the three terms in this
	 * sequence? 
	 * 
	 * Program took 831 milliseconds
	 */
	public static void main(final String[] args) {
		Set<Integer> set = Utils.convertListToSet(SieveWithBitset.getPrimes(9999));
		for (int i = 1000; i <= 9999; i++) {
			if (set.contains(i)) {
				for (int j = 1; j <= 9999; j++) {
					if (isPermutation(i, i + j) && set.contains(i + j)) {
						if (isPermutation(i, i + j + j) && set.contains(i + j + j) && (i + j + j < 9999)) {
							if (i == 1487) { // We already know this, this isn't
												// the answer we're looking for.
								continue;
							}
							System.out.println(i + "" + (i + j) + "" + (i + j + j));
							uptime();
							return;
						}
					} else {
						continue;
					}
				}
			}
		}
		uptime();
	}

	private static boolean isPermutation(int i, int b) {
		List<Integer> iList = new ArrayList<Integer>();
		for (char c : String.valueOf(i).toCharArray()) {
			iList.add(Integer.valueOf(String.valueOf(c)));
		}

		List<Integer> bList = new ArrayList<Integer>();
		for (char c : String.valueOf(b).toCharArray()) {
			bList.add(Integer.valueOf(String.valueOf(c)));
		}

		Collections.sort(iList);
		Collections.sort(bList);

		return iList.equals(bList);
	}
}
