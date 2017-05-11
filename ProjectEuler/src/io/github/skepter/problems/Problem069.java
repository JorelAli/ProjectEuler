package io.github.skepter.problems;

import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem069 extends RT {

	/* https://projecteuler.net/problem=69 */
	public static void main(final String[] args) {
		double max = 0.0D;
		int m = 1000000;
		LoadingBar bar = new LoadingBar("Problem 69",m);
		for(int i = 1; i <= m; i++) {
			if(i/Utils.totient(i) > max) {
				max = i/Utils.totient(i);
			}
			bar.updateBar(i);
		}
		System.out.println(max);
		uptime();
	}
}
