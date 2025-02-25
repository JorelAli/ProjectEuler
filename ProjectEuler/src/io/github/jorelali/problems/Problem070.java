package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.jorelali.utils.RT;

public class Problem070 extends RT {

	/*
	 * 8319823
	 * Program took 03 seconds, 247 milliseconds
	 */
	public static void main(final String[] args) {
		int n = 10000000;

		long[] totients = calculateTotients(n);
		double minN = n;
		double minRatio = Integer.MAX_VALUE;

		// 1 < n < 10^7, so n can't be 1
		for (int i = 2; i < n; i++) {
			if (isPermutation(i, (int) totients[i])) {
				double ratio = (double) i / (double) totients[i];
				if (ratio < minRatio) {
					minN = i;
					minRatio = ratio;
					// System.out.println("Found new best ratio for phi(" + i + ") = " + totients[i]
					// + ": " + ratio);
				}
			}
		}

		System.out.println(minN);

		uptime();
	}

	static boolean isPermutation(int a, int b) {
		return fastSortedDigits(a).equals(fastSortedDigits(b));
	}

	static List<Integer> fastSortedDigits(int value) {
		List<Integer> list = new ArrayList<>();
		String s = String.valueOf(value);
		for (char c : s.toCharArray()) {
			list.add(((int) c) - 48); // 0 ASCII = 48
		}
		Collections.sort(list);
		return list;
	}

	public static long[] calculateTotients(int limit) {
		long[] totientValues = new long[limit + 1];

		// Initialize totientValues[i] = i for all i
		for (int i = 0; i <= limit; i++) {
			totientValues[i] = i;
		}

		// Sieve-like approach to calculate totient function for all numbers up to
		// 'limit'
		for (int prime = 2; prime <= limit; prime++) {
			if (totientValues[prime] == prime) { // Check if 'prime' is actually prime
				for (int multiple = prime; multiple <= limit; multiple += prime) {
					totientValues[multiple] = totientValues[multiple] * (prime - 1) / prime;
				}
			}
		}
		return totientValues;
	}
}
