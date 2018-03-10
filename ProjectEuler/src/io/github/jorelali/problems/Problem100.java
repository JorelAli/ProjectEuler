package io.github.jorelali.problems;

import java.math.BigDecimal;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem100 extends RT {

	//https://www.desmos.com/calculator/p6h3gbm4wj
	public static void main(final String[] args) {
		int count = 0;
		for(long l = 1000000000000L;;l++) {
			count++;
			BigDecimal result = function(new BigDecimal(l));
			if(result.toString().endsWith("0000000000"))  {
				System.out.println(result.toString());
				System.out.println(l);
				
				break;
			}
			if(count % 100000 == 0) {
				System.out.println(count);
				//System.out.println(result.toString());
			}
		}
		uptime();
	}
	
	public static BigDecimal function(BigDecimal input) {
		
		BigDecimal result = input.multiply(input.subtract(BigDecimal.ONE));
		result.add(new BigDecimal(0.5));
		result = result.divide(new BigDecimal(2));
		result = Utils.nRootNewtonRaphson(result, result, 2, 50, 50);
		result = result.add(new BigDecimal(0.5));
		return result;
	}
	
	
	//Attempt 1
//	/**/
//	public static void main(final String[] args) {
//		for (long l = 1000000000000L;; l++) {
//			/*
//			 * 21/1.4 = 15
//			 * (85+35)/1.4 = 85.714
//			 * 
//			 * 10^12/1.4 = 714,285,714,286 <<-- Check for values of a around here
//			 */
//			
//			long a = 714285714286L;
//			BigFraction fraction = new BigFraction(1, (l * (l - 1)));
//			BigFraction fraction2 = new BigFraction(a * (a - 1), 1);
//			if(fraction.multiply(fraction2).equals(new BigFraction(1,2))) {
//				System.out.println(a);
//				break;
//			}
//		}
//		uptime();
//	}
}

	