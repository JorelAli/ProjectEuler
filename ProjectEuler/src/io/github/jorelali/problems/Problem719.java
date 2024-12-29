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
		// for(long l = 1; l <= max; l++) {
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

	static boolean isSNumber(long l) {
		final double sqrt = Math.sqrt(l);

		// First property of S-numbers: It has to be a perfect
		// square. We can easily filter out non-S-numbers by
		// checking if it's a perfect square or not
		if (!Utils.isInteger(sqrt)) {
			return false;
		} else {
			for (List<Long> split : generateSplits(Utils.digits(l))) {
				if (split.size() > 1 && split.stream().reduce(0L, Long::sum) == sqrt) {
					return true;
				}
			}
			return false;
		}
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
