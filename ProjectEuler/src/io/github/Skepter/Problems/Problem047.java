package io.github.Skepter.Problems;

import java.util.List;
import java.util.Set;

import io.github.Skepter.ForeignUtils.SieveWithBitset;
import io.github.Skepter.Utils.LoadingBar;
import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem047 extends RT {

	/*
	 * https://projecteuler.net/problem=47
	 * 
	 * The first two consecutive numbers to have two distinct prime factors are:
	 * 
	 * 14 = 2 × 7 
	 * 15 = 3 × 5
	 * 
	 * The first three consecutive numbers to have three distinct prime factors
	 * are:
	 * 
	 * 644 = 2² × 7 × 23 
	 * 645 = 3 × 5 × 43 
	 * 646 = 2 × 17 × 19.
	 * 
	 * Find the first four consecutive integers to have four distinct prime
	 * factors each. What is the first of these numbers?
	 * 
	 * Program took 01 minutes, 26 seconds, 353 milliseconds <<-- Time until it reaches output. 
	 */
	public static void main(final String[] args) {
		int max = 500000;
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(max);
		LoadingBar bar = new LoadingBar("Problem 47", max);
		for(int i = 1; i <= max; i++) {
			Set<Integer> i1 = Utils.getPrimeFactorSet(i, primes);
			Set<Integer> i2 = Utils.getPrimeFactorSet(i+1, primes);
			Set<Integer> i3 = Utils.getPrimeFactorSet(i+2, primes);
			Set<Integer> i4 = Utils.getPrimeFactorSet(i+3, primes);
			if(i1.size() == 4 && i2.size() == 4 && i3.size() == 4 && i4.size() == 4) {
				System.out.println(i);
				uptime();
				return;
			}
			bar.updateBar(i);
		}
	}
}
