package io.github.skepter.problems;

import io.github.skepter.utils.RT;

public class Problem101 extends RT {

	/* Fits and bops. */
	public static void main(final String[] args) {
		
		/*
		 *  1
			683 		//find linear sequence 1, 683, ...
			44287 		//find quadratic sequence 1, 683, 44287, ...
			838861		//find cubic sequence 1, 683, 44287, 838861, ...
			8138021
			51828151
			247165843
			954437177
			1798805207
			1238392738
		 */
		
//		for(int i = 1; i <= 10; i++)
//			System.out.println(tenDegPoly(i));
		
		
		
		
		
		uptime();
	}
	
	public static int tenDegPoly(int n) {
		return 1 - n + pow(n, 2) - pow(n, 3) + pow(n, 4) - pow(n, 5) + pow(n, 6) - pow(n, 7) + pow(n, 8) - pow(n, 9) + pow(n, 10);
	}
	
	public static int pow(int i, int pow) {
		return (int) Math.pow(i, pow);
	}
}
