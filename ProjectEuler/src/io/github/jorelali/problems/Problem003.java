package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.List;

import io.github.jorelali.utils.RT;

public class Problem003 extends RT {

	//What is the largest prime factor of the number 600851475143 ?
	//101ms
	public static void main(final String[] args) {
		long l = 600851475143L;
		final List<Integer> list = new ArrayList<Integer>();
		//loop through numbers from 2 to 600851475143
		for (int i = 2; i <= l; i++)
			while ((l % i) == 0) {
				list.add(i);
				l /= i;
			}
		System.out.println(list.get(list.size() - 1));
		uptime();
	}
}
