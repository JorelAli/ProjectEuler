package io.github.jorelali.problems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;

public class Problem035 extends RT{

	/*
	 * The number, 197, is called a circular prime 
	 * because all rotations of the digits: 197, 
	 * 971, and 719, are themselves prime.

	There are thirteen such primes below 100: 
	2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 
	and 97.

	How many circular primes are there below one million?
	37260ms (37 seconds)
	 */
	public static void main(final String[] args) {
		//		for(int i : getCircleNumbers(12345))
		//			System.out.println(i);
		final List<Integer> primes = SieveWithBitset.getPrimes(1000000);
		final Set<Integer> set = new HashSet<Integer>();
		for (final int i : primes)
			//System.out.println(i);
			if (check(primes, i))
				set.add(i);
		System.out.println(set.size());
		uptime();
	}

	private static boolean check(final List<Integer> primes, final int i) {
		final List<Boolean> bools = new ArrayList<Boolean>();
		for (final int circles : getCircleNumbers(i))
			if (primes.contains(circles))
				bools.add(true);
			else
				bools.add(false);
		return bools.contains(false) ? false : true;
	}

	private static List<Integer> getCircleNumbers(final int integer) {
		String str = String.valueOf(integer);
		final List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			final String charToAdd = String.valueOf(str.charAt(str.length() - 1));
			str = charToAdd + str.substring(0, str.length() - 1);
			ints.add(Integer.parseInt(str));
		}
		return ints;

	}
}
