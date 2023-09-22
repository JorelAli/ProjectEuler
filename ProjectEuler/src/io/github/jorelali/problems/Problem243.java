package io.github.jorelali.problems;

import java.util.List;

import io.github.jorelali.utils.RT;

public class Problem243 extends RT {

	/* https://projecteuler.net/problem=243
	 */
	
	// I originally wrote this for problem 72 but didn't even need it
	// Glad I needed it this time!
	public static int fareySequence(int n) {
		boolean descending = false;
		int a = 0;
		int b = 1;
		int c = 1;
		int d = n;

		if (descending) {
			a = 1;
			c = n - 1;
		}

		int count = 0;

		int k = 0;
		while (c <= n) {
			k = (n + b) / d;

			int oldA = a;
			int oldB = b;
			int oldC = c;
			int oldD = d;

			a = oldC;
			b = oldD;
			c = k * oldC - oldA;
			d = k * oldD - oldB;
			
			if (b == n) { 
				count++;
			}
		}

//		System.out.println(count);
		return count;
	}
	
	public static double R(int d) {
		return (double) fareySequence(d) / (double) (d - 1);
	}
	
	public static void main(final String[] args) {
		final double limit = 15499D/94744D; // About 0.163588
		
		// Highly composite numbers?
		List<Integer> l = List.of(1,2,4,6,12,24,36,48,60,120,180,240,360,720,840,
 1260,1680,2520,5040,7560,10080,15120,20160,25200,
 27720,45360,50400,55440,83160,110880,166320,
 221760,277200,332640,498960,554400,665280,720720,
 1081080,1441440,2162160);
		
		for(Integer i : l) {
			System.out.println(i + ": " + R(i));
		}
		
//		final double limit = 4D/10D;
//		for (int i = 1; i <= 10000;i++) {
//			System.out.println(i + "," + R(i));
			// System.out.println(R(i) < limit);
//			if (R(i) < limit) {
//				System.out.println(i);
//				break;
//			}
//		}
//		System.out.println(R(12) < 4D/10D);
//		System.out.println(R(13) < 4D/10D);
		uptime();
		
	}
}
