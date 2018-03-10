package io.github.jorelali.problems;

import java.math.BigInteger;

import io.github.jorelali.utils.RT;

public class Problem072 extends RT {

	/* https://projecteuler.net/problem=71 
	 * 
	 * https://oeis.org/A006842
	 * https://en.wikipedia.org/wiki/Farey_sequence
	 * 
	 * |Fn| = 1 + sum(totient(m)) for m = 1 to n
	 * */
	
	//Solution works (1.5 minutes, but needs better precision)
	static double Fn(double n) {
		return (0.5D * (n + 3) * n) - sum(n);
	}
	
	static double sum(double n) {
		double sum = 0;
		for(double d = 2; d <= n; d++) {
			sum += Fn(Math.floor(n / d));
		}
		return sum;
	}
	
	static BigInteger F_n(BigInteger n) {
		return n.add(BigInteger.valueOf(3)).multiply(n).divide(BigInteger.valueOf(2)).subtract(SUM(n));
	}
	
	static BigInteger SUM(BigInteger n) {
		BigInteger sum = BigInteger.ZERO;
		for(BigInteger d = BigInteger.valueOf(2); d.compareTo(n) <= 0; d.add(BigInteger.ONE)) {
			sum.add(F_n(n.divide(d)));
		}
		return sum;
	}
	
	
	public static void main(final String[] args) {
	
		
		
		
		long n = 1000000;
		System.out.println(F_n(BigInteger.valueOf(n)).subtract(BigInteger.valueOf(2)));
		
		//Remove 2 to exclude cases 0/1 and 1/1
		//System.out.println(Fn(n) - 2);
		
		uptime();
	}
}
