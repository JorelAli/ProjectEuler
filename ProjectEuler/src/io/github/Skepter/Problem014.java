package io.github.Skepter;

import io.github.Skepter.Utils.RT;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Problem014 extends RT {

	/*
	 * The following iterative sequence is defined for the set of positive integers:

	n → n/2 (n is even)
	n → 3n + 1 (n is odd)

	Using the rule above and starting with 13, we generate the following sequence:

	13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
	It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
	Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

	Which starting number, under one million, produces the longest chain?

	NOTE: Once the chain starts the terms are allowed to go above one million.
	 */
	public static void main(final String[] args) {
		final Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (long i = 1; i < 1000000; i++) {
			int count = 0;
			long j = i;

			/* Stop when it gets to 1 and store it */
			while (j != 1) {
				/* If it is even, divide by 2 */
				if ((j % 2) == 0) {
					j /= 2;
				} else {
					/* Otherwise, times it by 3 and add 1 */
					j *= 3;
					j++;
				}
				count++;
			}
			map.put(i, count);
		}
		
		/* Compare which is longest */
		long key = 0;
		int max = 0;
		for (final Entry<Long, Integer> entry : map.entrySet())
			if (entry.getValue() > max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		System.out.println(key + ": " + max);
		uptime();
	}
}
