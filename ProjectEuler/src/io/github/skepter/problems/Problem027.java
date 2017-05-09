package io.github.skepter.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.RT;

public class Problem027 extends RT {

	/*
	 * https://projecteuler.net/problem=27
	 * 
	 * Given the prime numbers below 1000:
	 * 
	 * {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
	 * 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149,
	 * 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227,
	 * 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307,
	 * 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389,
	 * 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467,
	 * 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571,
	 * 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653,
	 * 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751,
	 * 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853,
	 * 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947,
	 * 953, 967, 971, 977, 983, 991, 997}
	 * 
	 * The coefficient of b must be one of these numbers, as when n = 0, the
	 * formula produces b
	 * 
	 * The coefficient of a ranges from -999 to 999 inclusive
	 * 
	 * Program took 131 milliseconds
	 */
	
	public static Set<Integer> primes = new HashSet<Integer>();
	
	public static void main(final String[] args) {
		primes.addAll(SieveWithBitset.sieveOfEratosthenes(1000000));
		
		//Primes under 1000 for coefficient of b
		List<Integer> primesUnder1000 = SieveWithBitset.sieveOfEratosthenes(1000);

		//Looping through values of B
		
		int maxConsecutive = 0;
		int maxA = 0;
		int maxB = 0;
		
		for(int i = 0; i < 168; i++) {
			for(int a = -999; a <= 999; a++) {
				int n = 0;
				while(isPrime(computeFormula(n, a, primesUnder1000.get(i)))) {
					n++;
				}
				if(n > maxConsecutive) {
					maxConsecutive = n;
					maxA = a;
					maxB = primesUnder1000.get(i); 
				}
				//System.out.println("n = " + n + ", a = " + a + ", b = " + primesUnder1000.get(i));
			}
			
//			for(int n = 0; n < 1000; n++) {
//				
//					if(isPrime(computeFormula(n, a, primesUnder1000.get(i)))) {
//						System.out.println("n = " + n + ", a = " + a + ", b = " + primesUnder1000.get(i));
//					}
//				}
//			}
		}
		
		System.out.println(maxA * maxB);
		uptime();
	}
	
	private static int computeFormula(int n, int a, int b) {
		return ((n * n) + (a * n) + (b));
	}
	
	private static boolean isPrime(int i) {
		return primes.contains(i);
	}
}
