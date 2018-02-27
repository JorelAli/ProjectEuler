package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem086 extends RT {

	/**/
	public static void main(final String[] args) {
		
		int count = 0;
		for(int x = 1; x <= 100; x++) {
			for(int y = 1; y <= 100; y++) {
				if((x * x) + (y * y) == 100) {
					System.out.println(x + ", " + y);
					count++;
				}
			}
		}
		System.out.println(count);
		
		
		/*
		 * 1 x [98 x 1]
		 * 1 x [97 x 2]
		 * 1 x [96 x 3]
		 * .
		 * .
		 * .
		 * 2 x [97 x 1]
		 */
		
		uptime();
	}
}
