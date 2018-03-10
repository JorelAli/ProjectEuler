package io.github.jorelali.problems;

import java.util.HashSet;

import io.github.jorelali.utils.RT;

public class Problem029 extends RT {

	/* https://projecteuler.net/problem=29 */
	public static void main(final String[] args) {
		HashSet<Double> set = new HashSet<Double>();
		
		for (int a = 2; a <= 100; a++) {
			for(int b = 2; b <= 100; b++) {
				set.add(Math.pow(a, b));
			}
		}
		
		System.out.println(set.size());
		uptime();
	}
}
