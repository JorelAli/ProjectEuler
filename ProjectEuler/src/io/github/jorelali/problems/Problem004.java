package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem004 extends RT{

	/*
	 * A palindromic number reads the same both ways. 
	 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 * 
	 * 220ms
	 */
	public static void main(final String[] args) {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 100; i <= 999; i++)
			for (int j = 100; j <= 999; j++)
				if (Utils.isPalindrome(i * j))
					list.add(i * j);
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
		uptime();
	}
}