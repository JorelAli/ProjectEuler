package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem571 extends RT {

	/* https://projecteuler.net/problem=571 */
	public static void main(final String[] args) {
		for(int i = 2; i <= 12; i++) {
			
			System.out.println(isSuperPandigital(Utils.convertBase(978, i), i));
		}
		uptime();
	}
	
	private static boolean isSuperPandigital(int input, int n) {
		for(int i = 0; i < n; i++) {
			if(!String.valueOf(input).contains(String.valueOf(i))) {
				return false;
			}
		}
		return true;
	}
}
