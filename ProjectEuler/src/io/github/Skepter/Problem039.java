package io.github.Skepter;

import io.github.Skepter.Utils.RT;

import java.util.HashMap;
import java.util.Map;

public class Problem039 extends RT {

	/*If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, 
	 * there are exactly three solutions for p = 120.

	{20,48,52}, {24,45,51}, {30,40,50}

	For which value of p ≤ 1000, is the number of solutions maximised?*/
	
	//Takes around 16 minutes!
	public static void main(final String[] args) {
		//int p = 1000;
		int triangles = 0;
		int perimeter = 0;
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

		for (int i = 0; i <= 1000; i++) {
			cache.computeIfAbsent(i, m -> pow(m));
		}

		for (int p = 0; p <= 1000; p++) {
			int solutions = 0;
			/* Basic loop */
			for (int a = 0; a <= p; a++) {
				for (int b = 0; b <= p; b++) {
					for (int c = 0; c <= p; c++) {
						/* Check is a is less than b is less than c */
						if (a < b && b < c) {
							/* Check if it equals p (perimeter) */
							if (a + b + c == p) {
								/* Check if it is a right angled triangle using pythagoras' theorum */
								if (cache.computeIfAbsent(a, i -> pow(i)) + cache.computeIfAbsent(b, i -> pow(i)) == cache.computeIfAbsent(c, i -> pow(i))) {
									solutions++;
								}
							}
						}
					}
				}
			}
			if (triangles < solutions) {
				triangles = solutions;
				perimeter = p;
			}
			System.out.println(p + "/" + 1000);
		}
		System.out.println(triangles + ": " + perimeter);
		uptime();
	}

	private static int pow(int i) {
		return i * i;
	}
}
