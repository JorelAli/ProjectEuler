package io.github.Skepter;

import java.util.ArrayList;
import java.util.List;

public class Problem003 {

	//What is the largest prime factor of the number 600851475143 ?
	public static void main(final String[] args) {
		long l = 600851475143L;
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= l; i++)
			while ((l % i) == 0) {
				list.add(i);
				l /= i;
			}
		System.out.println(list.get(list.size() - 1));
	}
}
