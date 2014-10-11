package io.github.Skepter;

import java.math.BigInteger;

public class Problem016 {

	//What is the sum of the digits of the number 2^1000?
	public static void main(final String[] args) {
		final BigInteger b = new BigInteger("2");
		final BigInteger x = b.pow(1000);
		final String s = x.toString();
		int count = 0;
		for (int i = 0; i < s.length(); i++)
			count += Integer.parseInt(String.valueOf(s.charAt(i)));
		System.out.println(count);
	}
}
