package io.github.skepter.problems;

import io.github.skepter.utils.RT;

public class Problem040 extends RT {

	/*
	 * An irrational decimal fraction is created by concatenating the positive integers:

	0.123456789101112131415161718192021...

	It can be seen that the 12th digit of the fractional part is 1.

	If dn represents the nth digit of the fractional part, find the value of the following expression.

	d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
	 */

	static String string;

	public static void main(final String[] args) {
		StringBuilder builder = new StringBuilder();
		//Has to be 0 or get(1) would be 2 and it would be off center.
		for (int i = 0; i < 1000000; i++) {
			builder.append(i);
		}
		string = builder.toString();
		System.out.println(get(1) * get(10) * get(100) * get(1000) * get(10000) * get(100000) * get(1000000));
		uptime();
	}

	public static int get(int i) {
		return Integer.parseInt(String.valueOf(string.charAt(i)));
	}
}
