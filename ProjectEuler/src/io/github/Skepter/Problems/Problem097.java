package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;

import java.math.BigInteger;

public class Problem097 extends RT {

	/*Find last 10 digits of 28433×2^(7830457)+1
	 * 
	 * 11051ms */
	public static void main(final String[] args) {
		//28433×27830457+1
		BigInteger x = new BigInteger("28433"); 
		BigInteger y = new BigInteger("2");
		BigInteger z = y.pow(7830457);
		BigInteger a = x.multiply(z);
		BigInteger total = a.add(BigInteger.ONE);
		
		int length = total.toString().length();
		System.out.println(total.toString().substring(length - 10, length));
		uptime();
	}
}
