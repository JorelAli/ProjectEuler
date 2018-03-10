package io.github.jorelali.problems;

import java.util.HashSet;
import java.util.Set;

import io.github.jorelali.utils.RT;

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
		
		Program took 01 seconds, 532 milliseconds

		
	*/
	
	static int[] factorial;
	
	public static void main(final String[] args) {
		factorial = new int[] {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		
		//System.out.println(factorialSum(169));
		
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
	public static int chain(int input) {
		
		Set<Integer> sequence = new HashSet<>();
		sequence.add(input);
		int facSum = factorialSum(input);
		while(!sequence.contains(facSum)) {
			sequence.add(facSum);
			facSum = factorialSum(facSum);
		}
		
		return sequence.size();
	}
	
	//Factorial values will only be from 0 to 9, so we can just use an array to store those values
	public static int factorialSum(int input) {
		int count = 0;
		while(input > 0) {
			int index = input % 10;
			input /= 10;
			count += factorial[index];
		}
		return count;
	}
	
	
}
