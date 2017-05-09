package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Problem030 extends RT {

	/* https://projecteuler.net/problem=30 
	 * Find the sum of all the numbers that can be 
	 * written as the sum of fifth powers of their digits.
	 * 1249ms*/
	public static void main(final String[] args) {
		List<Integer> thingy = new ArrayList<Integer>();
		/*1 million is a good place to stop at (I tried with 10 million
		 * and got the same result)*/
		for(int i = 2; i <= 1000000; i++) {
			int count = 0;
			for(int digit : Utils.digits(i)) {
				count += Math.pow(digit, 5);
			}
			if(count == i) {
				thingy.add(i);
			}
		}
		int count = 0;
		for(int value : thingy) {
			count += value;
		}
		System.out.println(thingy);
		System.out.println(count);
		uptime();
	}
}
