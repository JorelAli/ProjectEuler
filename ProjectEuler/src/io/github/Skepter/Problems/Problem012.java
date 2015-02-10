package io.github.Skepter.Problems;

import io.github.Skepter.Utils.Incomplete;

import java.util.ArrayList;
import java.util.List;

public class Problem012 implements Incomplete {

	//What is the value of the first triangle number to have over five hundred divisors?
	public static void main(final String[] args) {
		final long old = System.currentTimeMillis();
		//calculate triangle numbers
		//1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
		// 1 + 2 + 3 + 4 + 5 + 6 etc.

		int n = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += i;
			if (getFactors(count).size() >= 500) {
				n = i;
				break;
			}
		}
		System.out.println(getFactors(count).size() + " factors");
		System.out.println(n + "th term: " + count);
		System.out.println((System.currentTimeMillis() - old) + "ms");
	}

	public static List<Integer> getFactors(final int j) {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= j; i++)
			if ((j % i) == 0)
				list.add(i);
		return list;
	}
}
