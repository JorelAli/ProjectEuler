package io.github.Skepter;
import io.github.Skepter.resources.SieveWithBitset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem035 {

	/*
	 * The number, 197, is called a circular prime 
	 * because all rotations of the digits: 197, 
	 * 971, and 719, are themselves prime.

	There are thirteen such primes below 100: 
	2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 
	and 97.

	How many circular primes are there below one million?
	 */
	public static void main(String[] args) {
		//		for(int i : getCircleNumbers(12345))
		//			System.out.println(i);
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(1000000);
		Set<Integer> set = new HashSet<Integer>();
		for (int i : primes) {
			//System.out.println(i);
			if (check(primes, i)) {
				set.add(i);
			}
		}
		System.out.println(set.size());
	}

	private static boolean check(List<Integer> primes, int i) {
		List<Boolean> bools = new ArrayList<Boolean>();
		for (int circles : getCircleNumbers(i)) {
			if (primes.contains(circles)) {
				bools.add(true);
			} else {
				bools.add(false);
			}
		}
		return bools.contains(false) ? false : true;
	}

	private static List<Integer> getCircleNumbers(int integer) {
		String str = String.valueOf(integer);
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			String charToAdd = String.valueOf(str.charAt(str.length() - 1));
			str = charToAdd + str.substring(0, str.length() - 1);
			ints.add(Integer.parseInt(str));
		}
		return ints;

	}
}
