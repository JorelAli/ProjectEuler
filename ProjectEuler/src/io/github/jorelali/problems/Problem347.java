package io.github.jorelali.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem347 extends RT {

	static List<Integer> primes;

	static int max = 10_000_000;
	
	/**/
	public static void main(final String[] args) {
		primes = SieveWithBitset.getPrimes(max);

		// Tests
		System.out.println(M(2, 3, 100)); //96
		System.out.println(M(3, 5, 100)); //75
		System.out.println(M(2, 73, 100)); //0
		
		Set<Integer> results = new HashSet<>();
		
		for(int p : primes) {
			for(int q : primes) {
				results.add(M(p, q, max));
			}
		}
		
		
//		for(int i = 0; i < primes.size(); i++) {
//			for(int j = 0; j < primes.size(); j++) {
//				results.add(M(primes.get(i), primes.get(j), 100));
//			}
//		}
		
		System.out.println(results.stream().mapToInt(i -> i).sum());
		
		System.out.println(results.stream().reduce(0, (a, b) -> a + b));
		
		uptime();
	}

	public static int M(int p, int q, int N) {
		if(N == 0) {
			return 0;
		}
		Set<Integer> factors = Utils.getPrimeFactorSet(N, primes);
		if (factors.contains(p) && factors.contains(q)) {
			factors.remove(p);
			factors.remove(q);
			if (factors.isEmpty()) {
				return N;
			} else {
				return M(p, q, N - 1);
			}
		} else {
			return M(p, q, N - 1);
		}

	}
	
}
