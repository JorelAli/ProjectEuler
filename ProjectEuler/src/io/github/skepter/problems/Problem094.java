package io.github.skepter.problems;

import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

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
		
		Utils.assert_(getArea(5, 6) == 12.0D);
		Utils.assert_(hasIntegralArea(5, 6));
		
		Utils.assert_(isActuallyATriangle(1, 1, 2) == false);
		
		long count = 0L;
		int max = 333_333_333;//191856
		LoadingBar bar = new LoadingBar("Problem 94", max);
		for (int i = 2; i <= max; i++) {
			//1, 1, 2 is not a triangle.
			if (hasIntegralArea(i, i + 1) && isActuallyATriangle(i, i, i + 1)) {
				count += (3 * i) + 1;
			} 
			if (hasIntegralArea(i, i - 1) && isActuallyATriangle(i, i, i - 1)) {
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
		double area = getArea(a, c);
		return (int) area == area;
	//	return getArea(a, c) % 1 == 0;
	}
	
	private static double getArea(double hypotenuse, double base) {
		double halfBase = base / 2D;
		double height = Math.sqrt((hypotenuse * hypotenuse) - (halfBase * halfBase));
		double area = base * height * 0.5D;
		return area;
	}
	
	/**
	 * Checks if 3 numbers actually produce a valid triangle:
	 * https://stackoverflow.com/a/19835249/4779071
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static boolean isActuallyATriangle(double a, double b, double c) {
		return (((a + b) > c) && ((a + c) > b) && ((b + c) > a));
	}

}
