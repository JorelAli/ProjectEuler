package io.github.jorelali.problems;

import java.util.List;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.LoadingBar;
import io.github.jorelali.utils.RT;

public class Problem050 extends RT {

	/* https://projecteuler.net/problem=50
	 * 93337ms
	 * */
	public static void main(final String[] args) {
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(1000000);
		
		//maximise sumOfPrimes(a) - sumOfPrimes(b);
		
		
		//int count = 0;
		
		int max = 0;
		int maxi = 0;
		int maxj = 0;
		
		LoadingBar b = new LoadingBar("Problem 50", 10000);
		
		for(int i = 0; i < 10000; i++) {
			//Assuming that j is less than 100
			for(int j = 0; j < 100; j++) {
				int consecutiveSum = sumOfPrimes(i) - sumOfPrimes(j);
				if(consecutiveSum <= 0) {
					continue;
				}
				
				if(primes.contains(consecutiveSum)) {
					if(consecutiveSum > max) {
						max = consecutiveSum;
						maxi = i;
						maxj = j;
					}
					//System.out.println(consecutiveSum);
				}
				
			}
			b.updateBar(i);
			
		}
		System.out.println(max + ": Using primes between " + maxj + " and " + maxi);
		uptime();
	}
	
	public static int sumOfPrimes(int max) {
		List<Integer> primes = SieveWithBitset.sieveOfEratosthenes(max);
		int count = 0;
		for(int i : primes){
			count += i;
		}
		return count;
	}
}
