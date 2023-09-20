package io.github.jorelali.problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

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
	
	static boolean hfc_is_one(int n, int d) {
		return Utils.fastGCD(n, d) == 1; //n == 1 || d % n != 0;
	}
	
	static double a(double b) {
		return ((3D * b) - 1D) / 7D;
	}
	
	public static void fareySequence(int n, boolean descending) {
		int a = 0;
		int b = 1;
		int c = 1;
		int d = n;
		
		if (descending) {
			a = 1;
			c = n - 1;
		}
		
		int count = 0;
		
		// System.out.println(a + "/" + b);
		
		int k = 0;
		while (c <= n) {
			k = (n + b) / d; // d
			
			int oldA = a;
			int oldB = b;
			int oldC = c;
			int oldD = d;
			
			a = oldC;
			b = oldD;
			c = k * oldC - oldA;
			d = k * oldD - oldB;
			// System.out.println(a + "/" + b);
			count++;
		}
		
		System.out.println(count - 1);
	}
	
	static Map<Long, Long> cache = new HashMap<>();
	
	public static long cardinality(long n) {
		// https://en.wikipedia.org/wiki/Farey_sequence#Sequence_length_and_index_of_a_fraction
		
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		
		if (n == 1) {
			return 2;
		}
		
		long sum = 0;
		for(long d = 2; d <= n; d++) {
			sum += cardinality(Math.floorDiv(n, d));
		}
		
		final long result = (long) (0.5 * (n + 3) * (n) - sum);
		// System.out.println("|F(" + n + ")|: " + result);
		
		if (!cache.containsKey(n)) {
			cache.put(n, result);
		}
		
		return result;
	}
	
	public static int sumOf(int from, int to, BiFunction<Integer, Integer, Integer> function) {
		int count = 0;
		for (int i = from; i <= to; i++) {
			count += function.apply(from, to);
		}
		return count;
	}
	
//	def farey_sequence(n: int, descending: bool = False) -> None:
//	    """Print the n'th Farey sequence. Allow for either ascending or descending."""
//	    a, b, c, d = 0, 1, 1, n
//	    if descending:
//	        a, c = 1, n - 1
//	    print(f"{a}/{b}")
//	    while c <= n and not descending or a > 0 and descending:
//	        k = (n + b) // d
//	        a, b, c, d = c, d, k * c - a, k * d - b
//	        print(f"{a}/{b}")
	
	
	public static void main(final String[] args) {
		
		System.out.println(cardinality(1000000) - 2);
		// fareySequence(1000000, false);
//		double max = 0;
//		
//		int i = 0;
//		for(double d = 0; d <= 8; d++) {
//			if(Utils.isInteger(a(d))) {
//				if(a(d) > max) {
//					max = a(d);
//					i++;
//				}
//			}
//		}
//		System.out.println(max);
//		System.out.println(i);
		// uptime();
		
//		int count = 0;
//		for(int d = 1; d <= 10000; d++) {
//			for(int n = 1; n < d; n++) {
//				if(hfc_is_one(n, d)) {
//					count++;
//					// System.out.println(n + " / " + d);
//				}
//			}
//		}
//		
//		System.out.println(count);
		
		// long n = 1000000;
		// System.out.println(F_n(BigInteger.valueOf(n)).subtract(BigInteger.valueOf(2)));
		
		//Remove 2 to exclude cases 0/1 and 1/1
		//System.out.println(Fn(n) - 2);
		
		uptime();
	}
}
