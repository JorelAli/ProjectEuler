package io.github.jorelali.foreignutils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import io.github.jorelali.utils.LoadingBar;

/**
 * Generates primes using BigInteger's probable prime function.
 * Uses a certainty value of 1.
 * 
 * Significantly slower than SieveWithBitset, but can be used
 * to find values of primes up to a point and use said
 * variable in the SieveWithBitset
 * @author Jorel
 *
 */
public class ManyPrimeGenerator {

	public static List<Integer> getPrimes(final int numberOfPrimes) {
		List<Integer> primes = new ArrayList<Integer>();
		LoadingBar bar = new LoadingBar("Generating Primes", numberOfPrimes);
		primes.add(2);
		for(int i = 3; primes.size() < numberOfPrimes; i+=2) {
			if(BigInteger.valueOf(i).isProbablePrime(1)) {
				bar.updateBar(primes.size());
				primes.add(i);
			}
		}
		bar.destroy();
		return primes;
	}
	
}
