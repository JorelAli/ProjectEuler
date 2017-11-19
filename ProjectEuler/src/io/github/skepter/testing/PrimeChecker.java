package io.github.skepter.testing;

import java.math.BigInteger;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

/**
 * Class used to test out prime checking algorithms
 */
public class PrimeChecker extends RT {

	public static void main(String[] args) {
		
		//in order from highest prime to lower primes
		//int[] Mersenne = new int[] {74207281, 57885161, 43112609, 42643801, 37156667, 32582657};
		
//		for(int i = Mersenne.length - 1; i >= 0; i--) {
//			System.out.println((i + 1) + ": " + BigInteger.valueOf(2).pow(Mersenne[i]).subtract(BigInteger.ONE).isProbablePrime(1000));;
//		}
		
		
		//System.out.println(BigInteger.valueOf(2).pow(74207281).subtract(BigInteger.ONE).isProbablePrime(1000));
													// 37156667
		int[] powers = new int[] {	2, 3, 5, 7, 13, 17, 19, 31, 61, 89, 107, 127, 521, 607, 1279, 2203, 2281, 3217, 4253, 4423, 9689, 9941, 11213, 19937, 21701, 23209, 44497, 86243, 110503, 132049, 216091, 756839, 859433, 1257787, 1398269, 2976221, 3021377, 6972593, 13466917, 20996011, 24036583, 25964951, 30402457, 32582657, 37156667};

		for(int i = 0; i < powers.length; i++) {
			begin();
			System.out.println(powers[i] + ": " + BigInteger.valueOf(2).pow(powers[i]).subtract(BigInteger.ONE).isProbablePrime(1000));
			System.out.println( BigInteger.valueOf(2).pow(powers[i]).subtract(BigInteger.ONE).toString());
			end();
		}
		
		
		
		uptime();
//		for(int i = 3; i <= 100; i+=2) {
//			System.out.println(i + ": " + isPrime(i, 1000));
//		}
//		
		//System.out.println(millerRabinVariant(21));
		
		//System.out.println(millerRabin(221));
		
		//I discovered there's a way of doing this using BigIntegers.
	}
	
	public static boolean isPrime(int i, int certainty) {
		return BigInteger.valueOf(i).isProbablePrime(certainty);
	}
	
	public static boolean millerRabinVariant(int n) {
		if(n % 2 == 0) {
			throw new IllegalArgumentException("Must input an odd number");
		}
		
		int d = 0;
		int s = 0;
		
		//Finding values r and d
		for(int i = 2;;i++) {
			if(Utils.isInteger(((double) (n - 1)) / Math.pow(2, i))) {
				s = i;
				d = (int) (((double) (n - 1)) / Math.pow(2, i));
				break;
			}
		}
		//To be used for stupidly large values
		//int[] A = new int[]{2, Math.min(n-1, (int) Math.floor(2 * Math.log(n) * Math.log(n)))};
		int[] A = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		for(int a : A) {
			if((Math.pow(a, d) % n) != (1 % n)) {
				boolean allR = true;
				for(int r : new int[]{0, s-1}) {
					if((Math.pow(a, Math.pow(2, r) * d) % n) == (1 % n)) {
						allR = false;
						break;
					}
				}
				if(allR) {
					return false;
				}
			}
		}
		
		return true;
	}
}
