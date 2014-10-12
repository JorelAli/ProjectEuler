package io.github.Skepter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Problem014 {

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
	public static void main(String[] args) {
		long old = System.currentTimeMillis();
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (long i = 1; i < 1000000; i++) {
			int count = 0;
			long j = i;
			//System.out.println("begin: " + i);
			while (j != 1) {
				//if even
				if (j % 2 == 0) {
					j /= 2;
					count++;
				} else {
					j *= 3;
					j++;
					count++;
				}
				//System.out.println(j);
			}
			map.put(i, count);
		}
		long key = 0;
		int max = 0;
		for(Entry<Long, Integer> entry : map.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		
		System.out.println(key + ": " + max);
		//10 seconds
		System.out.println(System.currentTimeMillis() - old + "ms");
	}
}
