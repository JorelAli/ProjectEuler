package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem015 extends RT {

	/*Starting in the top left corner of a 2×2 grid, 
	 * and only being able to move to the right and down, 
	 * there are exactly 6 routes to the bottom right corner.


	How many such routes are there through a 20×20 grid?*/

	/*
	 * Solution = 40C20
	 * 40 = 2 x 20 (right and down)
	 * 
	 * Program took 086 milliseconds
	 */
	public static void main(final String[] args) {
		System.out.println(Utils.combinations(40, 20));
		uptime();
	}
}
