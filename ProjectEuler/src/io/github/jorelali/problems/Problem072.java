package io.github.jorelali.problems;

import java.util.HashMap;
import java.util.Map;

import io.github.jorelali.utils.RT;

public class Problem072 extends RT {

	/* https://projecteuler.net/problem=72
	 * 
	 * Solve |Fn|, where F is a Farey sequence and n is 1,000,000
	 * 
	 * https://en.wikipedia.org/wiki/Farey_sequence
	 * https://en.wikipedia.org/wiki/Farey_sequence#Sequence_length_and_index_of_a_fraction
	 * 
	 * We could use the totient function, but that's a pain to compute
	 * so instead we'll use the formula which you can find on Wikipedia:
	 * 
	 *   |Fn| = (1/2)(n+3)n - (SUM(|F(floor(n/d))|) from d = 2 to n)
	 * 
	 * Program took 130 milliseconds
	 * */
	
	// Cache things because we're constantly computing the same thing
	// If we wanted to shove the whole thing into computeIfAbsent, we
	// can use a ConcurrentSkipListMap which is thread-safe and avoids
	// the ConcurrentModificationException in recursive calls... although
	// using this is slower (adds ~80ms to the time)
	static Map<Long, Long> cache = new HashMap<>();
	
	public static long cardinality(long n) {		
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		
		long sum = 0;
		for(long d = 2; d <= n; d++) {
			sum += cardinality(Math.floorDiv(n, d));
		}
		
		final long result = (long) (0.5 * (n + 3) * (n) - sum);
		
		if (!cache.containsKey(n)) {
			cache.put(n, result);
		}
		
		return result;
	}
	
	public static void main(final String[] args) {
		System.out.println(cardinality(1000000) - 2); // Ignore 0/1 and 1/1
		uptime();
	}
}
