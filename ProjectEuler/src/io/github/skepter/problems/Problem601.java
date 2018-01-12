package io.github.skepter.problems;

import java.util.HashMap;
import java.util.Map;

import io.github.skepter.utils.RT;

public class Problem601 extends RT {

	static Map<Long, Long> streak = new HashMap<>();
	static Map<Input, Long> P = new HashMap<>();
	
	class Input {
		long s;
		long N;
		public Input(long s, long N) {
			this.s = s;
			this.N = N;
		}
		
	}
	
	public static void main(String[] args) {
		
		//System.out.println(streak(120));
		
		System.out.println(P(3, 14));
		System.out.println(P(6, 10000000));
		System.out.println(P(6, 10000000));

		
		
//		LoadingBar bar = new LoadingBar("Problem 601", 31);
//		long count = 0;
//		for(int i = 1; i <= 31; i++) {
//			count += P(i, (long) Math.pow(4, i));
//			bar.updateBar(i);
//		}
//		System.out.println(count);
		
		uptime();
	}
	
	public static long P(long s, long N) {
		long count = 0;
		//Only compute values from stored value to N
		for(long n = 2; n < N; n++) { //store in a fancy hashmap
			if(streak(n) == s) {
				count++;
			}
		}
		return count;
	}
	
	public static long streak(long n) {
		return streak.computeIfAbsent(n, val -> {
			long count = 0;
			int counterThing = 1;
			for(long i = val; ;i++) {
				if(i % counterThing++ != 0) {
					break;
				} else {
					count++;
				}
			}
			return count;
		});
		
	}
}
