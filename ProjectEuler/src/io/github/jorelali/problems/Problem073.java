package io.github.jorelali.problems;

import java.util.List;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem073 extends RT {

	/* https://projecteuler.net/problem=71 
	 * 
	 * https://en.wikipedia.org/wiki/Farey_sequence
	 * 
	 * */
	
	
	static void farey(int n, boolean descending) {
		int a = 0;
		int b = 1;
		int c = 1;
		int d = n;
		
		if(descending) {
			a = 1;
			c = n-1;
		}
		System.out.println(a + " " + b);
		while((c <= n && !descending) || (a > 0 && descending)) {
			int k = (n + b) / d;
			a = c;
			b = d;
			c = (k*c) - a;
			d = (k*d) - b;
			System.out.println(a + " " + b);
		}
	}
	
	static int length(int n) {
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(n);
		return length(n, primes, 0) - 2;
	}
	
	/*
	 * Thanks to my university lecturer for teaching me about
	 * "Tail Recursive functions" by using an accumulator to prevent running
	 * into a StackOverflowException
	 */
	private static int length(int n, List<Integer> primes, int acc) {
		if(n == 1) {
			return acc + 2;
		}
		return length(n - 1, primes, acc + Utils.totient(n, primes));
	}
	
	public static void main(final String[] args) {
		System.out.println(length(12000));
		//farey(12000);
		//double max = 0;
//		for(int d = 1; d <= 12000; d++) {
//			System.out.println(Utils.totient(d, primes));
//			
//		}
		uptime();
		
	}
}
