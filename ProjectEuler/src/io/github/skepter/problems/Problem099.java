package io.github.skepter.problems;

import java.util.List;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem099 extends RT {

	/* https://projecteuler.net/problem=99 */
	public static void main(final String[] args) {
		List<String> list = Utils.readFromFile("p099_base_exp.txt");
		double max = 0.0D;
		int line = 0;
		for (int i = 0; i <= 999; i++) {
			double a = Double.parseDouble(list.get(i).split(",")[0]);
			double b = Double.parseDouble(list.get(i).split(",")[1]);
			double out = b * Math.log(a);
			if (out > max) {
				max = out;
				line = i + 1; // Stupid OBOEs
			}
		}
		System.out.println(line);
		uptime();
	}
}
