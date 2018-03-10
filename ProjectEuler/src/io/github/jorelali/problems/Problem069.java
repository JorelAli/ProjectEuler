package io.github.jorelali.problems;

import java.util.List;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem069 extends RT {

	
	
	/* https://projecteuler.net/problem=69 
	 * Program took 05 minutes, 20 seconds, 758 milliseconds - Attempt 2
	 * Program took 077 milliseconds - Attempt 3
	 * */
	public static void main(final String[] args) {
		
		//Attempt 3, Using multiplicative properties and analysis of the problem
		/*
		 * We want to maximise n/phi(n), such that n <= 1000000.
		 * Therefore, we want to make phi(n) have the biggest ratio between n
		 * 
		 * Looking at primes:
		 * phi(2) = 1. Ratio = 2
		 * phi(3) = 2. Ratio = 1.5
		 * phi(5) = 4. Ratio = 1.25
		 * 
		 * phi(6) = phi(2 * 3) = phi(2) * phi(3) = 2. Ratio = 3
		 * phi(7) = 6. Ratio = 1.1666...
		 * phi(30) = phi(2) * phi(3) * phi(5) = 8. Ratio = 3.75
		 * 
		 * The pattern lies between the prime numbers.
		 */
		
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(50);
		loop:
		for(int i = 0; i < primes.size(); i++) {
			int n = 1;
			int phiN = 1;
			for(int j = 0; j < i; j++) {
				n *= primes.get(j);
				phiN *= Utils.totient(primes.get(j), primes);
				if(n > 1000000) {
					break loop;
				}
			}
			System.out.println(n + " / " + phiN + " = " +  (n / phiN));
		}
		
		//Attempt 2, using Euler's product formula
		
		
////		int n = 10;
//	
//		//System.out.println(phi(n, primes));
//		
//		int max = 1000000;
//		
//		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(max);
//
//		System.out.println(Utils.totient(104982, primes));
//		
//		double maxVal = 0;
//		int maxIndex = 0;
//		LoadingBar bar = new LoadingBar("Problem 69", max);
//		for(double i = 1; i <= max; i++) {
//			int phi = Utils.totient((int) i, primes);
//			if(i / (double) phi > maxVal) {
//				maxVal = (double) i / (double) phi;
//				maxIndex = (int) i;
//			}
//			bar.updateBar((int) i);
//		}
//		
//		System.out.println(maxIndex);
//		
////		double count = 1;
////		for(int i : Utils.getPrimeFactorSet(n, primes)) {
////			System.out.println(i);
////			count *= (1D - 1D / (double) i);
////		}
////		System.out.println(count * n);
		

		
		//Attempt 1
		
//		double max = 0.0D;
//		int maxN = 0;
//		int m = 1000000;
//		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(m);		
//		/*
//		 * Hash our primes into the totientMap
//		 */
//		for(int prime : primes) {
//			totientMap.put(prime, prime - 1);
//		}
//		totientMap.put(1, 1);
//		
//		System.out.println("Primes hashed");
//		
//		LoadingBar bar = new LoadingBar("Problem 69", m);
//		for(int i = 1; i <= m; i++) {
//			long totient = totient(i, primes);//Utils.totient(i, primes);
//			if(i/totient > max) {
//				max = i/totient;
//				maxN = i;
//			}
//			bar.updateBar(i);
//		}
//		System.out.println(maxN);
		uptime();
	}
	
	
	//Fastest totient calculator I've created, but now obsolete (see Utils.totient)
//	static Map<Integer, Integer> totientMap = new HashMap<>();
//	static Map<Integer, List<Integer>> primeFactorsMap = new HashMap<>();
//	
//	public static int totient(int input, List<Integer> primes) {
//		
//		return totientMap.computeIfAbsent(input, i -> {
//			//Case will never exist
////			if(i == 1) {
////				return 1;
////			}
//			
//			//This case will never exist
////			if(primeSet.contains(i)) {
////				return i - 1;
////			} else {
//				//It can be factorised.
//			//primeFactorsMap.computeIfAbsent(i, val -> { return Utils.getPrimeFactors(val, primes);});
//				List<Integer> primeFactors = primeFactorsMap.computeIfAbsent(i, val -> { return Utils.getPrimeFactors(val, primes);});//Utils.getPrimeFactors(i, primes);
//				
//				int a = i / primeFactors.get(0);
//				int b = primeFactors.get(0);
//				
//				int gcd = Utils.gcd(a, b);
//				if(gcd == 1) {
//					return totient(a, primes) * totient(b, primes);
//				} else {
//					return (totient(a, primes) * totient(b, primes) * gcd) / totient(gcd, primes);
//				}
////			}
//		});
//	}
}
