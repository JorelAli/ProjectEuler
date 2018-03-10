package io.github.jorelali.problems;

import java.math.BigInteger;

import io.github.jorelali.utils.RT;

public class Problem016 extends RT {

	//What is the sum of the digits of the number 2^1000?
	public static void main(final String[] args) {
		final String s = BigInteger.valueOf(2).pow(1000).toString();
		int count = 0;
		for (int i = 0; i < s.length(); i++)
			count += Integer.parseInt(String.valueOf(s.charAt(i)));
		System.out.println(count);
		uptime();
	}
}
