package io.github.Skepter.Problems;

import java.util.HashMap;
import java.util.Map;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem026 extends RT {

	/*
	 * https://projecteuler.net/problem=26
	 * 
	 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
	 * */
	public static void main(final String[] args) {
		Map<Integer, Double> numbersWithoutRepetition = new HashMap<Integer, Double>();
		
		for(int i = 1; i < 1000; i++) {
			boolean hasRepetitions = true;
			for(int j = 0; j <= 9; j++) {
				if(repeats(1D/i, j, 5)) {
					hasRepetitions = false;
				}
			}
			if(hasRepetitions) {
				numbersWithoutRepetition.put(i, 1D/i);
			}
		}
		
		Utils.printMap(numbersWithoutRepetition);
		uptime();
	}
	
	/*
	 * Checks if the double repeats a digit a set number of times.
	 * 
	 * So repeats(0.16666666666666, 6, 5) returns true because it contains 666666
	 */
	public static boolean repeats(double input, int digit, int length) {
		String digitArr = "";
		for(int i = 0; i < length; i++) {
			digitArr = digitArr + digit;
		}
		return String.valueOf(input).contains(digitArr);
	}
}
