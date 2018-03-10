package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;

public class Problem001 extends RT  {

	//Find sum of all multiples of 3 and 5 up to 1000
	//086ms
	public static void main(final String[] args) {
		System.out.println(sum(3) + sum(5) - sum(15));
		uptime();
	}
	
	public static int sum(int k) {
		int count = 0;
		for(int i = 0; i < 1000; i+= k)
			count += i;
		return count;
	}
}
