package io.github.Skepter.Problems;

import java.util.HashSet;
import java.util.Set;

import io.github.Skepter.Utils.LoadingBar;
import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem032 extends RT {

	/*
	 * https://projecteuler.net/problem=32
	 * 
	 * We shall say that an n-digit number is pandigital if it makes use of all
	 * the digits 1 to n exactly once; for example, the 5-digit number, 15234,
	 * is 1 through 5 pandigital.
	 * 
	 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
	 * multiplicand, multiplier, and product is 1 through 9 pandigital.
	 * 
	 * Find the sum of all products whose multiplicand/multiplier/product
	 * identity can be written as a 1 through 9 pandigital.
	 * 
	 * HINT: Some products can be obtained in more than one way so be sure to
	 * only include it once in your sum.
	 * 
	 * Program took 29 seconds, 686 milliseconds
	 */
	public static void main(final String[] args) {
		int max = 5000;
		Set<Integer> productSet = new HashSet<Integer>();
		LoadingBar bar = new LoadingBar("Problem 32", max);
		for (int i = 0; i <= max; i++) {
			bar.updateBar(i);
			for (int j = 0; j <= max; j++) {
				if (Utils.isNPandigital(String.valueOf(i) + String.valueOf(j) + String.valueOf(i * j), 1, 9)) {
					productSet.add(i * j);
					// System.out.println("i = " + i + ", j = " + j + ", product
					// = " + i*j);
				}
			}
		}
		int count = 0;
		for (int i : productSet) {
			count += i;
		}
		System.out.println(count);
		uptime();
	}
}
