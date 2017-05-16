package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.List;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem571 extends RT {

	/* https://projecteuler.net/problem=571 */
	public static void main(final String[] args) {
		assert isSuperPandigital(978, 5);
		List<Long> list = new ArrayList<Long>();
		long max = Long.MAX_VALUE;
		for(long i = 2; i <= max; i++) {
			if(i % 1000000 == 0) {
				System.out.println(i);
			}
			//System.out.println(i);
			if(isSuperPandigital(i, 10)) {
				list.add(i);
				if(list.size() == 10) {
					break;
				}
			}
		}
		long count = 0L;
		for(long l : list) {
			count += l;
		}
		System.out.println(count);
		uptime();
	}
	
	private static boolean isSuperPandigital(long input, int maxBase) {
		for(int i = 2; i <= maxBase; i++) {
			if(isPandigital(Utils.convertBaseToString(input, i), i) == false) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isPandigital(String input, long n) {
		for(long i = 0; i < n; i++) {
			if(!input.contains(String.valueOf(i))) {
				return false;
			}
		}
		return true;
	}
}
