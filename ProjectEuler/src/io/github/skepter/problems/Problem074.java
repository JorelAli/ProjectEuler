package io.github.skepter.problems;

import java.util.HashSet;
import java.util.Set;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem074 extends RT {

	/*	
   	The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

	1! + 4! + 5! = 1 + 24 + 120 = 145
	
	Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:
	
	169 → 363601 → 1454 → 169
	871 → 45361 → 871
	872 → 45362 → 872
	
	It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,
	
	69 → 363600 → 1454 → 169 → 363601 (→ 1454)
	78 → 45360 → 871 → 45361 (→ 871)
	540 → 145 (→ 145)
	
	Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.
	
	How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
		
		Program took 16 seconds, 720 milliseconds
		
	*/
	public static void main(final String[] args) {
		int count = 0;
		for(int i = 1; i < 1000000; i++) {
			if(chain(i) == 60) {
				count++;
			}
		}
		System.out.println(count);
		uptime();
	}
	
	//Calculates the length of the chain of repeating factorial sums
	public static long chain(long input) {
		
		Set<Long> sequence = new HashSet<>();
		sequence.add(input);
		long facSum = factorialSum(input);
		while(!sequence.contains(facSum)) {
			sequence.add(facSum);
			facSum = factorialSum(facSum);
		}
		
		return sequence.size();
	}
	
	public static long factorialSum(long input) {
		return Utils.digits(input).stream().mapToLong(Utils::factorial).sum();
	}
	
	
}
