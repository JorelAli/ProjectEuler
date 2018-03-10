package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;

public class Problem024 extends RT {

	/*
	 * A permutation is an ordered arrangement of objects. For example, 3124 is
	 * one possible permutation of the digits 1, 2, 3 and 4. If all of the
	 * permutations are listed numerically or alphabetically, we call it
	 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	 * 
	 * 012 021 102 120 201 210
	 * 
	 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3,
	 * 4, 5, 6, 7, 8 and 9?
	 */
	
	// 44507ms (44.5 seconds good grief :/)
	public static void main(final String[] args) {
		/*
		 * 3 numbers - 0, 1, 2 Possible permutations = 3! = 6
		 * 
		 * 10 numbers - 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 Possible permutations = 10!
		 * = 3,628,800
		 * 
		 * Need the 1,000,000th permutation.
		 * 
		 * This means there's 362,880 starting with 0, 362,880 starting with
		 * 1.... etc. etc. Therefore, we're looking for the (1,000,000/362,880th
		 * permutation from the list) = 2.7557319224th
		 * 
		 * which mean we're looking for the 274240th number from 2000000000
		 * 
		 */

		int count = 0;
		for (long i = 2000000000; i < 3000000000L; i++) {
			if(isPermutation(i)) {
				if(count == (274240 - 1)) { //oboe
					System.out.println(i + "<<--");
					break; 
				}
				count++;
				System.out.println(count + ": " + i);
			}
		}
		uptime();
	}

	public static boolean isPermutation(long i) {
		String str = String.valueOf(i);
		if (str.contains("0") && str.contains("1") && str.contains("2") && str.contains("3") && str.contains("4")
				&& str.contains("5") && str.contains("6") && str.contains("7") && str.contains("8")
				&& str.contains("9")) {
			return true;
		} else {
			return false;
		}
	}

}
