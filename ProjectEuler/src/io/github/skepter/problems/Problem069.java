package io.github.skepter.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem069 extends RT {

	static Map<Integer, Integer> totientMap = new HashMap<>();
	
	/* https://projecteuler.net/problem=69 */
	public static void main(final String[] args) {
		
		double max = 0.0D;
		int maxN = 0;
		int m = 1000000;
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(m);		
		/*
		 * Hash our primes into the totientMap
		 */
		for(int prime : primes) {
			totientMap.put(prime, prime - 1);
		}
		totientMap.put(1, 1);
		
		System.out.println("Primes hashed");
		
		LoadingBar bar = new LoadingBar("Problem 69", m);
		for(int i = 1; i <= m; i++) {
			long totient = totient(i, primes);//Utils.totient(i, primes);
			if(i/totient > max) {
				max = i/totient;
				maxN = i;
			}
			bar.updateBar(i);
		}
		System.out.println(maxN);
		uptime();
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
				List<Integer> primeFactors = Utils.getPrimeFactors(i, primes);
				
				int a = i / primeFactors.get(0);
				int b = primeFactors.get(0);
				
				int gcd = Utils.gcd(a, b);
				return (totient(a, primes) * totient(b, primes) * gcd) / totient(gcd, primes);
//			}
		});
		
	}
}
