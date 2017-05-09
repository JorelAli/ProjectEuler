package io.github.skepter.problems;

import io.github.skepter.utils.RT;

public class Problem001 extends RT  {

	//Find sum of all multiples of 3 and 5 up to 1000
	//119ms
	public static void main(final String[] args) {
		int count = 0;
		for(int i = 0; i < 1000; i++) 
			if(((i % 3) == 0) || ((i % 5) == 0))
				count += i;
		System.out.println(count);
		uptime();
	}
}
