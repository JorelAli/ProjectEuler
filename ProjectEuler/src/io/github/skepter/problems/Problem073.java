package io.github.skepter.problems;

import java.util.List;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem073 extends RT {

	/* https://projecteuler.net/problem=71 
	 * 
	 * https://oeis.org/A006842
	 * https://en.wikipedia.org/wiki/Farey_sequence
	 * 
	 * Farey neighbours:
	 * 
	 * If a/b and c/d are next to each other, then:
	 * c/d - a/b = 1/(bd)
	 * 
	 * So: if a/b < 3/7, then 3/7 - a/b = 1/(7b)
	 * 
	 * Therefore, we have this equation:
	 * 1) 3b-7a = 1
	 * 
	 * Given that we want to find the value a (numerator), we have the function:
	 * a = (3b-1)/7
	 * 
	 * Program took 271 milliseconds
	 * */
	
	static void farey(int n)
	{
	    // We know first two terms are 0/1 and 1/n
	    double x1 = 0; 
	    double y1 = 1; 
	    double x2 = 1; 
	    double y2 = n;
	 
	    System.out.format("%.0f/%.0f %.0f/%.0f", x1, y1, x2, y2);
	 
	    double x, y = 0;  // For next terms to be evaluated
	    while (y != 1.0)
	    {
	        // Using recurrence relation to find the next term
	        x = Math.floor((y1 + n) / y2) * x2 - x1;
	        y = Math.floor((y1 + n) / y2) * y2 - y1;
	 
	        // Print next term
	        System.out.format(" %.0f/%.0f", x, y);
	 
	        // Update x1, y1, x2 and y2 for next iteration
			x1 = x2;
			x2 = x;
			y1 = y2;
			y2 = y;
		}
	}
	
	
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
		Utils.outputToFile("problem073.txt");
		System.out.println(length(12000));
		farey(12000);
		//double max = 0;
//		for(int d = 1; d <= 12000; d++) {
//			System.out.println(Utils.totient(d, primes));
//			
//		}
		uptime();
		
	//Initial attempt
		
		
//		Stack<Fraction> fractions = new Stack<Fraction>();
//		int max = 10000;
//		for(int d = 1; d <= max; d++) {
//			for(int n = 1; n < d; n++) {
//				fractions.push( new Fraction(n ,d));
//			}
//		}
//
//		uptime();
//		System.out.println(fractions.size()); // 49,995,000 with max = 10000
//		
//		
//		//Collections.sort(fractions);
//		for (int i = 0; i < fractions.size(); i++) {
//			Fraction fraction = fractions.get(i);
//			if(fraction.getNumerator() == 3 && fraction.getDenominator() == 7) {
//				System.out.println(fractions.get(i-1).getNumerator());
//			}
//		}
//		//fractions.forEach(a -> System.out.println(a.toString()));
//		
//		uptime();
	}
}
