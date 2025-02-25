package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.List;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem719 extends RT {

	/*
	 * https://projecteuler.net/problem=719
	 * 
	 * Program took 01 minutes, 29 seconds, 044 milliseconds
	 */
	public static void main(final String[] args) {
//		final long max = (long) Math.sqrt(Math.pow(10, 12)); // 1,000,000
//		System.out.println(max);
//		System.out.println(Math.sqrt(1_000_000_000_000L));
		
//		System.out.println(isSNumber(81));
		
		long sum = 0;
		long max = 1_000_000_000_000L;
		// long max = 10_000;
		for(long l = 1; l*l <= max; l++) {
			// The mod-9 optimization:
			// When we split up numbers in this way (e.g. 81 -> [8, 1])
			// this preserves the digit-sum. e.g. 6724 will always have
			// a digit sum of 19 (mod 9), regardless of how it's been split up.
			// For example:
			// 6724 -> 6 + 7 + 2 + 4 = 19 (mod 9) = 1
			// 6 + 72 + 4 = 82 (mod 9) = 1
			// This situation is only true when l (mod 9) is 0 or 1, so
			// we can ignore all other cases where l (mod 9) is greater
			// than 0 or 1 to give us a ~3-4x speed improvement.
			if (l % 9 > 1) {
				continue;
			}
			
			long lSquared = l*l;
			if (isSNumber(lSquared, l)) {
				sum += lSquared;
			}
			System.out.println(l + " / 1,000,000");
		}
		System.out.println(sum);
		uptime();
	}
	
	static boolean isSNumber(long l, long lSqrt) {
		for (List<Long> split : generateSplits(Utils.digits(l))) {
			if (split.size() > 1) {
				long sum = 0;
				for (long splitL : split) {
					sum += splitL;
				}
				if (sum == lSqrt) {
					return true;
				}
			}
		}
		return false;
	}

	// Generate a list of splits. E.g. generateSplits([8, 1]) = [[8, 1], [81]]
	private static List<List<Long>> generateSplits(List<Long> digits) {
		List<List<Long>> results = new ArrayList<>();
		generateSplitsHelper(digits, new ArrayList<>(), results);
		return results;
	}

	private static void generateSplitsHelper(List<Long> remainingDigits, List<Long> currentSplit,
			List<List<Long>> results) {
		// Base case: no more digits to split
		if (remainingDigits.isEmpty()) {
			results.add(new ArrayList<>(currentSplit));
			return;
		}

		long runningNumber = 0;

		// Generate splits by taking one or more digits
		for (int i = 0; i < remainingDigits.size(); i++) {
			runningNumber = runningNumber * 10 + remainingDigits.get(i);

			// Create a new split with the current running number
			currentSplit.add(runningNumber);

			// Recursively split the rest of the digits
			generateSplitsHelper(remainingDigits.subList(i + 1, remainingDigits.size()), currentSplit, results);

			// Backtrack to explore other splits
			currentSplit.remove(currentSplit.size() - 1);
		}
	}
}
