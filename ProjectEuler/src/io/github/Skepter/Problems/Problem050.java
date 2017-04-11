package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem050 extends RT {

	/**/
	public static void main(final String[] args) {
		//maximise sumOfPrimes(a) - sumOfPrimes(b);
		int count = 0;
		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < 1000; j++) {
				if(count < (sumOfPrimes(i) - sumOfPrimes(j))) {
					if(count > 1000000) {
						System.out.println(count);
						uptime();
						return;
					}
					count = sumOfPrimes(i) - sumOfPrimes(j);
				}
			}
		}
		System.out.println(count);
		uptime();
	}
	
	public static int sumOfPrimes(int max) {
		int count = 0;
		for(int i = 1; i < max; i++){
			if(Utils.isPrime(i)) {
				count += i;
			}
		}
		return count;
	}
}
