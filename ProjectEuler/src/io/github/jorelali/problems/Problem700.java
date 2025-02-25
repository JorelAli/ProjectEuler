package io.github.jorelali.problems;

import java.math.BigInteger;

import io.github.jorelali.utils.RT;

public class Problem700 extends RT {

	public static BigInteger sequence(int n) {
		BigInteger a = new BigInteger("1504170715041707");
		BigInteger b = new BigInteger("4503599627370517"); // note that this number is prime!
		return a.multiply(BigInteger.valueOf(n)).mod(b);
	}

	/**/
//	public static void main(final String[] args) {
//		BigInteger smallestEulerCoinFoundSoFar = new BigInteger("1504170715041707"); // The first eulerCoin
//		BigInteger count = smallestEulerCoinFoundSoFar;
//		System.out.println("1: " + smallestEulerCoinFoundSoFar);
//		for (int i = 1;; i++) {
//			BigInteger nextSequence = sequence(i);
//
//			// If this next sequence is smaller than the smallest eulercoin found so far...
//			if (nextSequence.compareTo(smallestEulerCoinFoundSoFar) < 0) {
//				smallestEulerCoinFoundSoFar = nextSequence;
//				count = count.add(nextSequence);
//				System.out.println(i + ": " + nextSequence);
//			}
//			
//			// This uses modulo. If we get 1504170715041707n mod 4503599627370517 = 0,
//			// then there's no possible eulercoin that can be found that'll be smaller!
//			if (nextSequence.compareTo(BigInteger.ZERO) == 0) {
//				break;
//			}
//		}
//		System.out.println(count);
//		uptime();
//	}
	
	
//	public static void main(final String[] args) {
//        BigInteger modulus = new BigInteger("4503599627370517");
//        BigInteger multiplier = new BigInteger("1504170715041707");
//        BigInteger current = multiplier; // Start with the first Eulercoin
//        BigInteger smallestEulerCoin = multiplier;
//        BigInteger sum = multiplier;
//
//        System.out.println("1: " + current);
//
//        // Iterate to find Eulercoins
//        while (true) {
//            // Compute the next term in the sequence
//            current = current.add(multiplier).mod(modulus);
//
//            // Check if it is an Eulercoin
//            if (current.compareTo(smallestEulerCoin) < 0) {
//                smallestEulerCoin = current;
//                sum = sum.add(current);
//                System.out.println("Eulercoin: " + smallestEulerCoin);
//            }
//
//            // Break when the sequence stabilizes (optional optimization)
//            if (current.equals(BigInteger.ZERO)) {
//                break;
//            }
//        }
//
//        System.out.println("Sum of all Eulercoins: " + sum);
//    }
	/**
	 * 1: 1504170715041707
	 * 3: 8912517754604
	 * 506: 2044785486369
	 * 2527: 1311409677241
	 * 4548: 578033868113
	 * 11117: 422691927098
	 * 17686: 267349986083
	 * 24255: 112008045068
	 * 55079: 68674149121
	 * 85903: 25340253174
	 * 202630: 7346610401
	 * 724617: 4046188430
	 * 1246604: 745766459
	 * 6755007: 428410324
	 * 12263410: 111054189
	 * 42298633: 15806432
	 * 326125654: 15397267
	 * 609952675: 14988102
	 * 893779696: 14578937
	 * 1177606717: 14169772
	 * 1461433738: 13760607
	 * 1745260759: 13351442
	 * 2029087780: 12942277
	 * Whoops integer overflow!
	 * -1986789147: 2864155
	 * -1702962126: 2454990
	 * -1419135105: 2045825
	 */
}
