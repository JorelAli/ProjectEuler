package io.github.skepter.problems;

import java.util.HashSet;
import java.util.Set;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem041 extends RT {

	/*
	 * https://projecteuler.net/problem=41 We shall say that an n-digit number
	 * is pandigital if it makes use of all the digits 1 to n exactly once. For
	 * example, 2143 is a 4-digit pandigital and is also prime.
	 * 
	 * What is the largest n-digit pandigital prime that exists?
	 * 
	 * Program took 09 seconds, 631 milliseconds
	 */
	public static void main(final String[] args) {

		/*
		 * It's not prime if it divides by 3. We can check if it divides by 3 if
		 * the sum of digits is divisible by 3
		 * 
		 * n = 9: 45
		 * n = 8: 36
		 * n = 7: 28 <<--
		 * n = 6: 21
		 * n = 5: 15
		 * n = 4: 10 <<--
		 * n = 3: 6
		 * n = 2: 3
		 * n = 1: 1
		 * 
		 * It's not going to be n = 4 (I tried that already and got 4231, which was incorrect)
		 */
		Set<Integer> primes = new HashSet<Integer>();
		primes.addAll(SieveWithBitset.sieveOfEratosthenes(100000000));
		int max = 0;
		int count = 0;
		LoadingBar bar = new LoadingBar("Problem41", primes.size());
		for (int i : primes) {
				if (Utils.isNPandigital(i, 1, 7)) {
					if (i > max) {
						max = i;
					}
			}
			count++;
			bar.updateBar(count);
		}
		System.out.println(max);
		uptime();
	}
}
