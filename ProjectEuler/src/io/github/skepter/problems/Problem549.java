package io.github.skepter.problems;

import java.util.HashMap;
import java.util.Map;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem549 extends RT {

	static Map<Long, Long> s = new HashMap<Long, Long>();
	
	/*
	 * https://projecteuler.net/problem=549
	 * 
	 * The smallest number m such that 10 divides m! is m=5. The smallest number
	 * m such that 25 divides m! is m=10.
	 * 
	 * Let s(n) be the smallest number m such that n divides m!. So s(10)=5 and
	 * s(25)=10. Let S(n) be ∑s(i) for 2 ≤ i ≤ n. S(100)=2012.
	 * 
	 * Find S(10^8).
	 */
	public static void main(final String[] args) {
		assert s(10) == 5;
		assert s(25) == 10;
		//assert S(100) == 2012;
		System.out.println(S(100));
		uptime();
	}
	
	
	
	public static long S(long n) {
		int count = 0;
		for(int i = 2; i <= n; i++) {
			long val = s(i);
			count += val;
		}
		return count;
	}
	
	public static long s(long n) {
		return s.computeIfAbsent(n, (key) -> {
			for(long m = 2;; m++)
				if(Utils.factorial(m) % key == 0)
					return m;
		});
		
	}
}
