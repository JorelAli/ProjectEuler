package io.github.skepter.problems;

import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;

public class Problem094 extends RT {

	/*
	 * https://projecteuler.net/problem=94
	 * 
	 * It is easily proved that no equilateral triangle exists with integral
	 * length sides and integral area. However, the almost equilateral triangle
	 * 5-5-6 has an area of 12 square units.
	 * 
	 * We shall define an almost equilateral triangle to be a triangle for which
	 * two sides are equal and the third differs by no more than one unit.
	 * 
	 * Find the sum of the perimeters of all almost equilateral triangles with
	 * integral side lengths and area and whose perimeters do not exceed one
	 * billion (1,000,000,000).
	 */
	public static void main(final String[] args) {
		assert getArea(5, 6) == 12.0D;
		assert hasIntegralArea(5, 6);
		
		long count = 0L;
		int max = 333333333;
		LoadingBar bar = new LoadingBar("Problem 94", max);
		for (int i = 2; i <= max; i++) {
			if (hasIntegralArea(i, i + 1)) {
				count += (3 * i) + 1;
			} 
			if (hasIntegralArea(i, i - 1)) {
				count += (3 * i) - 1;
			}
			bar.updateBar(i);
		}
		
		System.out.println(count);
		
		uptime();
	}

	/*
	 * where a is the same as b, and c is the odd one out (i + 1 or i - 1)
	 */
	private static boolean hasIntegralArea(double a, double c) {
		return getArea(a, c) % 1 == 0;
	}
	
	private static double getArea(double a, double c) {
		double d = c / 2D;
		double area = Math.sqrt((a * a) - (d * d)) * 0.5D * c;
		return area;
	}
}
