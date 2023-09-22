package io.github.jorelali.problems;

import java.math.BigInteger;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem686 extends RT {

	/**/
	public static void main(final String[] args) {
		final BigInteger _123 = BigInteger.valueOf(123);
		final int MAX = 678910;
		int count = 0;
		int i = 0;
		int previousDigits = 0;
		for(; count != MAX; i++) {
			BigInteger big = BigInteger.valueOf(2).pow(i);
			
			final int digits = Utils.getDigitCount(big);
			if(digits >= 3) {
				// Faster... but this method is still way too slow
				if (big.divide(BigInteger.TEN.pow(digits - 3)).equals(_123)) {
					count++;
					// System.out.println(count + "," + digits);
					
					// Comparing digits show that the next power of 2 that starts with 123
					// is always 59, 87 or 146 (which is 59 + 87) larger than the previous one 
					System.out.println(count + "," + i + "," + (digits - previousDigits));
					previousDigits = digits;
				}
			}
			
			// Converting to a string is slow, let's use maths
//			String result = big.toString();
//			if(result.length() > 3) {
//				if(result.substring(0, 3).equals("123")) {
//					count++;
//					System.out.println(count);
//				}
//			}
			
		}
		System.out.println("p(123, " + count + ") = " + (i - 1));
		uptime();
	}
}
