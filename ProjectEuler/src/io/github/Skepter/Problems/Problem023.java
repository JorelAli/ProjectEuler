package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

/**/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem023 extends RT {

	/**/

	/*
	 * A perfect number is a number for which the sum of its proper divisors is
	 * exactly equal to the number. For example, the sum of the proper divisors
	 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
	 * number.
	 * 
	 * A number n is called deficient if the sum of its proper divisors is less
	 * than n and it is called abundant if this sum exceeds n.
	 * 
	 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
	 * smallest number that can be written as the sum of two abundant numbers is
	 * 24. By mathematical analysis, it can be shown that all integers greater
	 * than 28123 can be written as the sum of two abundant numbers. However,
	 * this upper limit cannot be reduced any further by analysis even though it
	 * is known that the greatest number that cannot be expressed as the sum of
	 * two abundant numbers is less than this limit.
	 * 
	 * Find the sum of all the positive integers which cannot be written as the
	 * sum of two abundant numbers.
	 */

	public static void main(String[] args) {
		/* Get all abundant numbers */
		List<Integer> abundantNumbers = new ArrayList<Integer>();
		for (int i = 1; i <= 28123 / 2; i++) {
			if (isAbundant(i))
				abundantNumbers.add(i);
		}

		/* Get all of the numbers which are sums of all of the abundant numbers */
		Set<Integer> abundantNumbersx2 = new HashSet<Integer>();
		for(int i = 0; i < abundantNumbers.size(); i++) {
			for(int j = 0; j < abundantNumbers.size(); j++) {
				abundantNumbersx2.add(abundantNumbers.get(i) + abundantNumbers.get(j));
			}
		}
		
		/* Get all of the numbers which are from 1 to 28123 */
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 28123; i++) {
			nums.add(i);
		}
		
		nums.removeAll(abundantNumbers);
	
		int counter = 0;
		for (int i : nums) {
			counter += i;
		}
		System.out.println(counter);
		uptime();
	}

	public static boolean isAbundant(int number) {
		int count = 0;
		for (int i : getDivisors(number)) {
			count += i;
		}
		return (count > number);
	}

	public static List<Integer> getDivisors(int number) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				list.add(i);
			}
		}
		return list;

	}
}
