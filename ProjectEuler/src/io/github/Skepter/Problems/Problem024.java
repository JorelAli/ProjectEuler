package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;

public class Problem024 extends RT {

	/*
	 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible 
	 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically 
	 * or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

		012   021   102   120   201   210

		What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	 */
	public static void main(final String[] args) {
		/*
		 * 3 numbers - 0, 1, 2
		 * Possible permutations = 3! = 6
		 * 
		 * 10 numbers - 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		 * Possible permutations = 10! = 3,628,800
		 * 
		 * Need the 1,000,000th permutation.
		 * 
		 * This means there's 362,880 starting with 0, 362,880 starting with 1.... etc. etc.
		 * Therefore, we're looking for the (1,000,000/362,880th permutation from the list)
		 * = 2.7557319224th
		 *  
		 */
		
		for(int i = 1000000000; i < 1000000000; i++) {
			//if(String.valueOf(i).contains(s))
		}
		uptime();
	}
	
	public static boolean isPermutation(int i) {
		
		return false;
	}
	
}
