package io.github.jorelali.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;

public class Problem087 extends RT {

	/*
	 * How many numbers below fifty million can be expressed as the sum of a
	 * prime square, prime cube, and prime fourth power? 
	 * 
	 * Program took 916 milliseconds
	 */
	public static void main(final String[] args) {
		
		//In fact, there are exactly four numbers below fifty that can be expressed in such a way:
		/*
		 * Revised algorithm note [3] Is there a way to prove given a number x that
		 * there is a solution WITHOUT having to compute said solution?
		 */
		
		/*
		 * Revised algorithm note [4] 
		 * 50,000,000 - 84^4 = 212,864.
		 * 50,000,000 - 85^4 = -2,200,625.
		 * => max power of 4 is 83
		 * 
		 * 50,000,000 - 368^3 = 163,968
		 * 50,000,000 - 369^3 = -243,409
		 * => max power of 3 is 367
		 * 
		 * -> max power of 2 is 7069 (sqrt 50mill, and then nearest max prime)
		 */
		
		//Revised algorithm note [5] Current algorithm takes an estimated 18 mins
		
		//Use a greedy algorithm with backtracking.
		
		/*
		 * Example of planned algorithm:
		 * Solution for 49 = 5^2 + 2^3 + 2^4
		 * 
		 * [1] Start from highest power.
		 * 49 - 1^4 = 48		<<-- Not prime
		 * 49 - 2^4 = 33
		 * 49 - 3^4 = -32.
		 * Therefore, backtrack to using 2^4 and save.
		 * 
		 * now, 33 - 2^3 = 25
		 * 
		 * 33 - 1^3 = 32		<<-- Not prime
		 * 33 - 2^3 = 25
		 * 33 - 3^3 = 6
		 * 33 - 4^3 = -31.		<<-- Not prime
		 * Backtrack to using 3^3 = 6
		 * 
		 * 6 - 1^2 = 5			<<-- Not prime
		 * 6 - 2^2 = 2
		 * 6 - 3^2 = -3.
		 * Backtrack to 33 and use 2^3 instead of 3^3 (decrease base by 1)
		 * 
		 * 25 - 1^2 = 24		<<-- Not prime
		 * 25 - 2^2 = 21
		 * 25 - 3^2 = 16
		 * 25 - 4^2 = 9			<<-- Err [2] 4 is not prime
		 * 25 - 5^2 = 0.
		 * End.
		 */
		
		//Revised algorithm note [2] - USE PRIMES!!
		
		
		//Program took 02 seconds, 942 milliseconds
//		int count = 0;
//		for(int i = 1; i < 50_000_000; i++) {
////			//Some arbitrary operation
//			if(solve(i))
//				count++;
//			System.out.println(i);
//		}
//		System.out.println(count);
		
		//int inputVal = 49;
		//solve(inputVal);
		
		//System.out.println(greedy3rdPower(greedy4thPower(49)));
		
		List<Integer> primesFor4thPower = SieveWithBitset.getPrimes(83);
		List<Integer> primesFor3rdPower = SieveWithBitset.getPrimes(367);
		List<Integer> primesFor2ndPower = SieveWithBitset.getPrimes(7069);
		Set<Long> numSet = new HashSet<>();
		
		//Number of loop iterations = 1524532
		//System.out.println(primesFor4thPower.size() * primesFor3rdPower.size() * primesFor2ndPower.size());
		
		//Generate all possible sequences of primes
		for(int x = 0; x < primesFor2ndPower.size(); x++) {
			for(int y = 0; y < primesFor3rdPower.size(); y++) {
				for(int z = 0; z < primesFor4thPower.size(); z++) {
					long bigNum = (long) (Math.pow(primesFor2ndPower.get(x), 2) + Math.pow(primesFor3rdPower.get(y), 3) + Math.pow(primesFor4thPower.get(z), 4));
					numSet.add(bigNum);
				}
			}
		}
		
		//Remove all greater than 50 million
		System.out.println(numSet.stream().filter((num) -> num < 50_000_000).count());
		
		
		uptime();
		
	}
	
	public static boolean solve(int inputVal) {
		int resultVal = inputVal;
		
		int resultVal4 = (int) (resultVal - Math.pow(greedy4thPower(resultVal), 4));
		//System.out.println(resultVal4); //33 :)
		
		int resultVal3 = (int) (resultVal4 - Math.pow(greedy3rdPower(resultVal4), 3));
		//System.out.println(resultVal3); //6 :)
		
		int resultVal2 = (int) (resultVal3 - Math.pow(greedy2ndPower(resultVal3), 2));
		//System.out.println(resultVal2); //2 :)

		if(resultVal2 != 0) {
			//Begin to backtrack from resultVal3
			resultVal3 = (int) (resultVal4 - Math.pow(greedy3rdPower(resultVal4) - 1, 3));
			//System.out.println(resultVal3); //25 :D
			
			//And recalculate resultVal2
			resultVal2 = (int) (resultVal3 - Math.pow(greedy2ndPower(resultVal3), 2));
			
			if(resultVal2 != 0) {
				//System.out.println(resultVal2);
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public static int greedy4thPower(int input) {
		int base = 1;
		while(input - Math.pow(base, 4) >= 0) {
			base++;
		}
		return base - 1;
	}
	
	public static int greedy3rdPower(int input) {
		int base = 1;
		while(input - Math.pow(base, 3) >= 0) {
			base++;
		}
		return base - 1;
	}
	
	public static int greedy2ndPower(int input) {
		int base = 1;
		while(input - Math.pow(base, 2) >= 0) {
			base++;
		}
		return base - 1;
	}
	
		// Attempt 1
//		for(int x = 1; ; x++) {
//			if((Math.pow(x, 2) + Math.pow(x, 3) + Math.pow(x, 4)) > 50) {
//				System.out.println(x - 1);
//				break;
//			}
//		}
//		
//		//Max possible value is 7071 (sqrt 50 million)
//		
//		List<Integer> primes = SieveWithBitset.getPrimes(5000);
//		Set<Long> numSet = new HashSet<>();
//		
//		for(int x = 0; x < primes.size(); x++) {
//			for(int y = 0; y < primes.size(); y++) {
//				for(int z = 0; z < primes.size(); z++) {
//					long bigNum = (long) (Math.pow(primes.get(x), 2) + Math.pow(primes.get(y), 3) + Math.pow(primes.get(z), 4));
//					numSet.add(bigNum);
//				}
//			}
//		}
//		
//		System.out.println(numSet.size());
}
