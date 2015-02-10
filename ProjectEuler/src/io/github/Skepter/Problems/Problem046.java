package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Problem046 extends RT {

	/*It was proposed by Christian Goldbach that every odd composite number 
	 * can be written as the sum of a prime and twice a square.

	9 = 7 + 2×1^2
	15 = 7 + 2×2^2
	21 = 3 + 2×3^2
	25 = 7 + 2×3^2
	27 = 19 + 2×2^2
	33 = 31 + 2×1^2

	It turns out that the conjecture was false.

	What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?*/
	public static void main(final String[] args) {
		/* Just go up to a million for testing sake */
		int max = 1000000;
		int exponentMax = 100;
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> otherList = new ArrayList<Integer>();
		
		for (int i = 3; i < max; i += 2) {
			otherList.add(i);
			System.out.println(i + "/" + max);
			for (int e = 1; e < exponentMax; e++) {
				int possiblePrime = i - twiceSquare(e);
				if (possiblePrime < 0) {
					break;
				}
				if (Utils.isPrime(possiblePrime) && (possiblePrime + twiceSquare(e) == i)) {
//					System.out.println(i + " = " + possiblePrime + " + 2x" + e + "^2");
					list.add(i);
					continue;
				} else {
					if(!list.contains(i)) {
//						System.out.println(i + " DOES NOT EQUAL " + possiblePrime + " + 2x" + e + "^2");
						//break mainForLoop;
					}
				}
			}
		}
		if(list.removeAll(otherList));
		uptime();
	}

	private static int twiceSquare(int i) {
		return 2 * (i * i);
	}
}
