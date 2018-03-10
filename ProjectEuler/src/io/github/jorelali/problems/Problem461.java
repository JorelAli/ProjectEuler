package io.github.jorelali.problems;

import io.github.jorelali.utils.Abandoned;
import io.github.jorelali.utils.RT;

public class Problem461 extends RT implements Abandoned {

	/*
	 * Let fn(k) = e^(k/n) - 1, for all non-negative integers k.
	 * 
	 * Remarkably, f200(6) + f200(75) + f200(89) + f200(226) = 3.141592644529… ≈
	 * π.
	 * 
	 * In fact, it is the best approximation of π of the form fn(a) + fn(b) +
	 * fn(c) + fn(d) for n = 200.
	 * 
	 * Let g(n) = a^2 + b^2 + c^2 + d^2 for a, b, c, d that minimize the error:
	 * | fn(a) + fn(b) + fn(c) + fn(d) - π | (where |x| denotes the absolute
	 * value of x).
	 * 
	 * You are given g(200) = 62 + 752 + 892 + 2262 = 64658.
	 * 
	 * Find g(10000).
	 */

	public static void main(final String[] args) {
//		int n = 200;
//		double pi = f(n, 6) + f(n, 75) + f(n, 89) + f(n, 226);
//		System.out.println(f(n, 6) + f(n, 75) + f(n, 89) + f(n, 226)); // pi
		
		int max = 1;
		int n = 10000;
		
		for(int a = 0; a < max; a++) {
			for(int b = 0; b < max; b++) {
				for(int c = 0; c < max; c++) {
					for(int d = 0; d < max; c++) {
						if ((f(n, a) + f(n, b) + f(n, c) + f(n, d) - 3.141) == 0) {
							System.out.println(f(n, a) + f(n, b) + f(n, c) + f(n, d));
							System.out.println(a);
							System.out.println(b);
							System.out.println(c);
							System.out.println(d);
							
						}
					}
				}
			}
		}
		
//		int a = 1000;
//		int b = 1000; 
//		int c = 1000;
//		int d = 15000;
//		System.out.println(f(n, a) + f(n, b) + f(n, c) + f(n, d));
		uptime(); 

	}

	public static double f(double n, double k) {
		return Math.pow(Math.E, k/n) - 1;
	}
}
