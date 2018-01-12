package io.github.skepter.problems;

import java.util.List;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem070 extends RT {

	/**/
	public static void main(final String[] args) {
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(10000000);
		System.out.println("Primes generated");
		for(int i = 1; ; i++) {
			System.out.println(i + ", " + Utils.totient(i, primes));
		}
		//uptime();
	}
}
