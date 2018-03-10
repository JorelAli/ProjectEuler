package io.github.jorelali.problems;

import java.util.HashSet;
import java.util.Set;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem062 extends RT {

	/*
	 * https://projecteuler.net/problem=62 
	 * Program took 16 seconds, 093
	 * milliseconds
	 */
	public static void main(final String[] args) {
		Set<Long> cubes = new HashSet<Long>();
		int max = 10000;
		for (long i = 0; i <= max; i++) {
			cubes.add(i * i * i);
		}
		for (long i = 0; i <= max; i++) {
			int count = 0;
			for (long cube : cubes) {
				if (Utils.isPermutation(cube, (i * i * i)) && cube != i * i * i) {
					count++;
				}
			}
			if (count == 5 - 1) {
				System.out.println(i * i * i);
				break;
			}

		}
		uptime();
	}
}
