package io.github.jorelali.problems;

import io.github.jorelali.utils.LoadingBar;
import io.github.jorelali.utils.RT;

public class Problem044 extends RT {

	/* https://projecteuler.net/problem=44 
	 * Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk - Pj| is minimised; what is the value of D?
	 * 
	 * Program took 12 seconds, 291 milliseconds
	 * */
	public static void main(final String[] args) {
		final int MAX = 10000; 
		int D = Integer.MAX_VALUE;
		LoadingBar bar = new LoadingBar("Problem 44", MAX);
		for(int j = 1; j <= MAX; j++) {
			for(int k = 1; k <= MAX; k++) {
				if(isPentagonal(getPentagonal(j) + getPentagonal(k)) && isPentagonal(getPentagonal(j) - getPentagonal(k))) {
					System.out.println("Found pentagonal pair: " + j + ", " + k);
					if(Math.abs(getPentagonal(k) - getPentagonal(j)) < D) {
						D = Math.abs(getPentagonal(k) - getPentagonal(j));
					}
				}
			}
			bar.updateBar(j);
		}
		System.out.println(D);
		uptime();
	}
	
	private static int getPentagonal(int i) {
		return (i * (3 * i - 1)) / 2;
	}
	
	private static boolean isPentagonal(int i) {
		double n = (1 + Math.sqrt(1 + 24 * i))/6;
		return (n % 1 == 0);
	}
}
