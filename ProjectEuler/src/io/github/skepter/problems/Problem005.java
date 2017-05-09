package io.github.skepter.problems;

import io.github.skepter.utils.RT;

public class Problem005 extends RT{

	/*
	 * 2520 is the smallest number that can be divided by 
	 * each of the numbers from 1 to 10 without any remainder.
	 * What is the smallest positive number that is evenly 
	 * divisible by all of the numbers from 1 to 20?
	 * 
	 * 580ms
	 */
	public static void main(final String[] args) {
		for (int i = 1; i < Integer.MAX_VALUE; i++)
			if(check(i)) {
				System.out.println(i);
				break;
			}
		uptime();
	}

	private static boolean check(final int checkInt) {
		for (int i = 1; i <= 20; i++) 
			if (!((checkInt % i) == 0))
				return false;
		return true;
	}
}
