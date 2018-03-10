package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;

public class Problem092 extends RT {

	/*
	 * https://projecteuler.net/problem=92
	 * 
	 * Program took 03 seconds, 971 milliseconds
	 */
	public static void main(final String[] args) {
		int count = 0;
		for (int i = 1; i <= 10000000; i++) {
			if (generateChain(i) == 89)
				count++;
		}
		System.out.println(count);
		uptime();
	}

	private static int generateChain(int i) {
		int chain = i;
		if (chain == 1 || chain == 89) {
			return i;
		} else {
			int count = 0;
			String iStr = String.valueOf(i);
			for (char c : iStr.toCharArray()) {
				count += Integer.parseInt(String.valueOf(c)) * Integer.parseInt(String.valueOf(c));
			}
			chain = count;
		}
		return generateChain(chain);
	}
}
