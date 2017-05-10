package io.github.skepter.problems;

import java.math.BigInteger;
import java.util.List;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem099 extends RT {

	/* https://projecteuler.net/problem=99 */
	public static void main(final String[] args) {
		List<String> list = Utils.readFromFile("p099_base_exp.txt");
		BigInteger max = BigInteger.ZERO;
		int line = 0;
		for(int i = 0; i <= 999; i++) {
			BigInteger a = BigInteger.valueOf(Long.valueOf(list.get(i).split(",")[0]));
			int b = Integer.parseInt(list.get(i).split(",")[1]);
			BigInteger exponent = a.pow(b);
			if(exponent.compareTo(max) > 0) {
				max = exponent;
				line = i;
			}
		}
		System.out.println(line);
		uptime();
	}
}
