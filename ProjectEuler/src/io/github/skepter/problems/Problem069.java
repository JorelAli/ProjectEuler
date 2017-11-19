package io.github.skepter.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem069 extends RT {

	static Map<Integer, Integer> totientMap = new HashMap<>();
	static Map<Integer, List<Integer>> primeFactorsMap = new HashMap<>();
	
	/* https://projecteuler.net/problem=69 
	 * Program took 05 minutes, 20 seconds, 758 milliseconds
	 * */
	public static void main(final String[] args) {
		
		//Attempt 2, using Euler's product formula
		
		
//		int n = 10;
	
		//System.out.println(phi(n, primes));
		
		int max = 1000000;
		
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(max);

		double maxVal = 0;
		int maxIndex = 0;
		LoadingBar bar = new LoadingBar("Problem 69", max);
		for(double i = 1; i <= max; i++) {
			int phi = phi((int) i, primes);
			if(i / (double) phi > maxVal) {
				maxVal = (double) i / (double) phi;
				maxIndex = (int) i;
			}
			bar.updateBar((int) i);
		}
		
		System.out.println(maxIndex);
		
//		double count = 1;
//		for(int i : Utils.getPrimeFactorSet(n, primes)) {
//			System.out.println(i);
//			count *= (1D - 1D / (double) i);
//		}
//		System.out.println(count * n);
		

		
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
	
	public static int phi(int n, List<Integer> primes) {
		double count = 1;
		for(int i : Utils.getPrimeFactorSet(n, primes)) {
			count *= (1D - 1D / (double) i);
		}
		return (int) (count * n);
	}
	
	
	public static int totient(int input, List<Integer> primes) {
		
		return totientMap.computeIfAbsent(input, i -> {
			//Case will never exist
//			if(i == 1) {
//				return 1;
//			}
			
			//This case will never exist
//			if(primeSet.contains(i)) {
//				return i - 1;
//			} else {
				//It can be factorised.
			//primeFactorsMap.computeIfAbsent(i, val -> { return Utils.getPrimeFactors(val, primes);});
				List<Integer> primeFactors = primeFactorsMap.computeIfAbsent(i, val -> { return Utils.getPrimeFactors(val, primes);});//Utils.getPrimeFactors(i, primes);
				
				int a = i / primeFactors.get(0);
				int b = primeFactors.get(0);
				
				int gcd = Utils.gcd(a, b);
				if(gcd == 1) {
					return totient(a, primes) * totient(b, primes);
				} else {
					return (totient(a, primes) * totient(b, primes) * gcd) / totient(gcd, primes);
				}
//			}
		});
		
	}
}
