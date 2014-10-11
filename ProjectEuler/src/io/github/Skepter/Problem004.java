package io.github.Skepter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem004 {

	/*
	 * A palindromic number reads the same both ways. 
	 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public static void main(final String[] args) {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 100; i <= 999; i++)
			for (int j = 100; j <= 999; j++)
				if (isPalindrome(i * j))
					list.add(i * j);
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
	}

	static boolean isPalindrome(final int i) {
		final String str = String.valueOf(i);
		final String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}
}