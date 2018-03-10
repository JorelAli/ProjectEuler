package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem007 {

	//What is the 10001st prime number?
	public static void main(final String[] args) {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < Integer.MAX_VALUE; i++)
			if (isPrime(i)) {
				if (list.size() == 10001)
					break;
				list.add(i);
			}
		System.out.println(list.get(list.size() - 1));
	}
	
	//19030ms

	//checks whether an int is prime or not.
	static boolean isPrime(final int n) {
		for (int i = 2; i < n; i++)
			if ((n % i) == 0)
				return false;
		return true;
	}
}
