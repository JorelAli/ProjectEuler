package io.github.skepter.problems;

import java.util.Arrays;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem061 extends RT {

	/* https://projecteuler.net/problem=61 */
	public static void main(final String[] args) {
		
		System.out.println(Arrays.toString(Utils.digitsArr(15827)));
		
//		for(int i = 1;; i++) {
//			if(Utils.digits(p3(i)) == null);
//		}
		
		uptime();
	}
	
	static int p3(int n) {
		return n * (n + 1) / 2;
	}
	
	static int p4(int n) {
		return n * n;
	}
	
	static int p5(int n) {
		return n * ((3 * n) - 1) / 2;
	}
	
	static int p6(int n) {
		return n * ((2 * n) - 1);
	}
	
	static int p7(int n) {
		return n * ((5 * n) - 3) / 2;
	}
	
	static int p8(int n) {
		return n * ((3 * n) - 2);
	}
}
