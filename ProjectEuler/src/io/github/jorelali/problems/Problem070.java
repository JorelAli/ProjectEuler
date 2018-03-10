package io.github.jorelali.problems;

import java.util.List;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem070 extends RT {

	/**/
	public static void main(final String[] args) {
		List<Integer> primes = SieveWithBitset.getPrimes(10000000);
		System.out.println("Primes generated");
		for(int i = 1; ; i++) {
			System.out.println(i + ", " + Utils.totient(i, primes));
		}
		//uptime();
	}
}
