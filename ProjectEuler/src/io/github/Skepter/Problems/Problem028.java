package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;

public class Problem028 extends RT {

	/* https://projecteuler.net/problem=28 
	 * 1, 
	 * 3, 5, 7, 9, (+2 between each one)
	 * 13, 17, 21, 25 (+4)
	 * 
	 * 85ms
	 * */
	public static void main(final String[] args) {
		int gridSize = 1001;
		long count = 1;
		int previousNumber = 1;
		for(int increment = 2; increment <= (gridSize - 1); increment += 2) {
			//System.out.println("Incrementing by " + increment);
			for(int i = 0 ; i < 4; i++) {
				//System.out.println(previousNumber);
				previousNumber += increment;
				//System.out.println(previousNumber);
				count += previousNumber;
			}
		}
		System.out.println(count);
		uptime();
	}
}
