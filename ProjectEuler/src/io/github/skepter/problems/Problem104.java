package io.github.skepter.problems;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem104 extends RT {

	/*
	 * Given that Fk is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 pandigital, find k.
	 * */
	public static void main(final String[] args) {
		//Utils.isNPandigital("", 1, 9);
		
		
		
		//System.out.println(fibonacci(2749));
		
		System.out.println(last(betterFib(541).toString()));
		System.out.println(first(betterFib(2749).toString()));
		
		
		for(int i = 3; ; i++) {
			try {
				if(last(betterFib(i).toString()) && first(betterFib(i).toString())) {
					System.out.println("Result: " + i);
					break;
				}
			} catch(Exception e) {}
			System.out.println(i);
		}
		
		
		uptime();
	}
	
	static BigDecimal rt5 = Utils.nRootNewtonRaphson(BigDecimal.valueOf(5), BigDecimal.valueOf(2.236), 2, 50, 200);
	
	static BigDecimal phi = BigDecimal.ONE.add(new BigDecimal(Math.sqrt(5))).divide(new BigDecimal(2));
	static BigDecimal psi = BigDecimal.ONE.subtract(new BigDecimal(Math.sqrt(5))).divide(new BigDecimal(2));
	
	public static BigInteger betterFib(int k) {
		return BigDecimal.ONE.add(rt5).divide(new BigDecimal(2)).pow(k).divide(rt5, BigDecimal.ROUND_HALF_UP).add(BigDecimal.valueOf(0.5D)).toBigInteger();
	}
	
	public static BigInteger fibonacci(int k) {
		BigDecimal result = phi.pow(k).subtract(psi.pow(k)).divide(new BigDecimal(Math.sqrt(5)));
		return result.toBigInteger();
	}
	
	public static boolean first(String str) {
		return (Utils.isNPandigital(str.substring(0, 9), 1, 9));
	}
	
	public static boolean last(String str) {
		return (Utils.isNPandigital(str.substring(str.length() - 9, str.length()), 1, 9));
	}
	
}
