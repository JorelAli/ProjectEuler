package io.github.Skepter.Problems;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem065 extends RT {

	public static int pointer = 0;
	public static List<Integer> list;
	public static int term = 100;
	
	/* https://projecteuler.net/problem=65 */
	public static void main(final String[] args) {
		/*
		 * Find the numerical value of 100th convergence. Multiply by numbers
		 * until you get an integer to get the numerator
		 */
				
		//Array sequence for value of e
		list = new ArrayList<Integer>();
		int k = 1;
		for(int i = 1; i<= 103; i++) {
			list.add(1);
			list.add(2*k);
			k++;
			list.add(1);
		}
//		Utils.printListSingleLine(list);
		BigDecimal hTerm = getNumerator(BigDecimal.valueOf(2D).add(BigDecimal.ONE.divide(denominator(BigDecimal.valueOf((long) list.get(0))), 1000, RoundingMode.HALF_DOWN)));
//		double hundredthTerm = getNumerator(2D + 1D/denominator(list.get(0)));
//		System.out.println(BigDecimal.valueOf(hundredthTerm).toString());
//		System.out.println(Utils.sumOfDigits(BigDecimal.valueOf(hundredthTerm).toString()));
		
		System.out.println(hTerm.longValueExact());
		//System.out.println(Utils.sumOfDigits(hTerm.toString()));
		
		uptime();
	}
	
	public static BigDecimal denominator(BigDecimal k) {
		pointer++;
		//System.out.println("pointer: " + pointer + ", " + k);
		if(pointer==term-1){
			return k;
		}
		return k.add(BigDecimal.ONE.divide(denominator(BigDecimal.valueOf((long) list.get(pointer))), 1000, RoundingMode.HALF_DOWN));
	}
	
	public static BigDecimal getNumerator(BigDecimal n) {
		System.out.println("Trying to find numerator");
		for(double i = 1;; i++) {
			if(isIntegerValue(n.multiply(BigDecimal.valueOf(i)))) {
				return n.multiply(BigDecimal.valueOf(i));
			}
		}
	}
	
	/*
	 * http://stackoverflow.com/a/12748321/4779071
	 */
	private static boolean isIntegerValue(BigDecimal bd) {
		return bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0;
	}
	
	@Deprecated
	public static double denominator(double k) {
		pointer++;
		//System.out.println("pointer: " + pointer + ", " + k);
		if(pointer==term-1){
			return k;
		}
		return k + 1D/denominator(list.get(pointer));
	}
	
	@Deprecated
	public static double getNumerator(double n) {
		for(double i = 1;; i++) {
			if(i * n == Math.floor(i * n)) {
				return i*n;
			}
		}
	}
}
