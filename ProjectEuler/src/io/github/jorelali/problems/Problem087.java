package io.github.jorelali.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;

public class Problem087 extends RT {

	/**/
	public static void main(final String[] args) {
		
		
		for(int x = 1; ; x++) {
			if((Math.pow(x, 2) + Math.pow(x, 3) + Math.pow(x, 4)) > 50) {
				System.out.println(x - 1);
				break;
			}
		}
		
		//Max possible value is 7071 (sqrt 50 million)
		
		List<Integer> primes = SieveWithBitset.getPrimes(5000);
		Set<Long> numSet = new HashSet<>();
		
		for(int x = 0; x < primes.size(); x++) {
			for(int y = 0; y < primes.size(); y++) {
				for(int z = 0; z < primes.size(); z++) {
					long bigNum = (long) (Math.pow(primes.get(x), 2) + Math.pow(primes.get(y), 3) + Math.pow(primes.get(z), 4));
					numSet.add(bigNum);
				}
			}
		}
		
		System.out.println(numSet.size());
		
		
		uptime();
	}
}
