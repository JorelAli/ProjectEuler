package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import io.github.jorelali.foreignutils.SieveWithBitset;
import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem315 extends RT {

	/* https://projecteuler.net/problem=315
	 * Program took 04 seconds, 265 milliseconds */
	public static void main(final String[] args) {
		
		// Initialise HashMap
		new LEDNumber();

		// Test rig
		//ArrayList<Integer> primes = new ArrayList<>();
		//primes.add(137);

		// Create an ArrayList of all prime numbers between 10^7 and 2x10^7
		ArrayList<Integer> primes = SieveWithBitset.getPrimes(2 * (int) Math.pow(10, 7)).stream()
				.filter(i -> i > Math.pow(10, 7)).collect(Collectors.toCollection(ArrayList::new));
		Collections.sort(primes);

		//Test cases (testing digitalRoot
		// System.out.println(Arrays.toString(digitalRoot(137, null))); //Should equal [137, 11, 2]
		// System.out.println(LEDNumber.getDifference(137, 11)); //Should equal 7
		// System.out.println(LEDNumber.getDifferenceDigit(0, 5)); // = 3
		
		//Testing Utils.toArray() function
		// System.out.println(Arrays.toString(Utils.toArray(1234, -1, 0))); // = [1, 2, 3, 4]
		// System.out.println(Arrays.toString(Utils.toArray(12345, 7, -1))); // = [-1, -1, 1, 2, 3, 4, 5]
		// System.out.println(Arrays.toString(Utils.toArray(12345, 5, -1))); // = [1, 2, 3, 4, 5]

		// Sam
		int sam = 0;
		for (int prime : primes) {
			for(int i : digitalRoot(prime, null)) {
				sam += LEDNumber.getDifference(-1, i);
			}
		}
		sam *= 2;

		// Max
		int max = 0;

		//Loop through primes
		for (int i = 0; i < primes.size(); i++) {
			//Calculate transitions to turn on the display
			max += LEDNumber.getDifference(-1, primes.get(i));
			
			//Calculate transitions for each of the digital root numbers in consecutive order
			for(int j = 0; j < digitalRoot(primes.get(i), null).length - 1; j++) {
				max += LEDNumber.getDifference(digitalRoot(primes.get(i), null)[j], digitalRoot(primes.get(i), null)[j+1]);
			}
			
			//Calculate transitions to turn off the display
			int[] finalArr = digitalRoot(primes.get(i), null);
			max += LEDNumber.getDifference(-1, finalArr[finalArr.length - 1]);
		}
		
		//System.out.println("Total number of transitions(Sam): " + sam);
		//System.out.println("Total number of transitions(Max): " + max);
		System.out.println(sam - max);
		uptime();
	}

	/**
	 * Returns an array of the values of the digital root of a number
	 * @param i The number to find the digital root for
	 * @param list Used internally. Set this to null
	 * @return An array. For example digitalRoot(137) returns [137, 11, 2]
	 */
	public static int[] digitalRoot(int i, List<Integer> list) {
		if(list == null) {
			list = new ArrayList<Integer>();
		}

		if(i > 9) {
			list.add(i);
			i = Utils.sumOfDigits(i);
			if(i > 9)
				return digitalRoot(i, list);
			else
				list.add(i);
		}
		
		return list.stream().mapToInt(j -> j).toArray();
	}
}

/**
 * Class to manage the LED numbers
 */
class LEDNumber {

	static HashMap<Integer, boolean[]> map;

	/**
	 * A mapping of the numbers to whether specific segments are on or off
	 * First value
	 */
	public LEDNumber() {
		map = new HashMap<Integer, boolean[]>();
		map.put(-1, new boolean[7]); // Case when the LED is off (all false)
		map.put(0, new boolean[] { true, true, true, false, true, true, true });
		map.put(1, new boolean[] { false, false, true, false, false, true, false });
		map.put(2, new boolean[] { true, false, true, true, true, false, true });
		map.put(3, new boolean[] { true, false, true, true, false, true, true });
		map.put(4, new boolean[] { false, true, true, true, false, true, false });
		map.put(5, new boolean[] { true, true, false, true, false, true, true });
		map.put(6, new boolean[] { true, true, false, true, true, true, true });
		map.put(7, new boolean[] { true, true, true, false, false, true, false });
		map.put(8, new boolean[] { true, true, true, true, true, true, true });
		map.put(9, new boolean[] { true, true, true, true, false, true, true });
	}
	
	/**
	 * Calculates the difference between the number of transitions from one number to another (where
	 * each number has 1 or more digits)
	 * @param before Initial number
	 * @param now Next number to compare
	 * @return Difference in values
	 * 
	 * @see io.github.jorelali.utils.Utils#toArray(i, length, filler)
	 */
	public static int getDifference(int before, int now) {

		int count = 0;

		//Get the max array length
		int arrLength = Math.max(String.valueOf(before).length(), String.valueOf(now).length());

		//If -1, fill array with -1s
		int[] beforeArr;
		if (before == -1) {
			beforeArr = new int[arrLength];
			for (int i = 0; i < arrLength; i++) {
				beforeArr[i] = -1;
			}
		} else {		
			beforeArr = Utils.toArray(before, arrLength, -1);
		}

		int[] nowArr;
		if (now == -1) {
			nowArr = new int[arrLength];
			for (int i = 0; i < arrLength; i++) {
				nowArr[i] = -1;
			}
		} else {
			nowArr = Utils.toArray(now, arrLength, -1);
		}

		for (int i = 0; i < arrLength; i++) {
			count += getDifferenceDigit(beforeArr[i], nowArr[i]);
		}

		return count;
	}

	/**
	 * Calculates the difference between individual digits
	 * @param before First digit
	 * @param now Second digit
	 * @return
	 * 
	 * e.g. (1, 7) -> 2<br>
	 * (0, 5) -> 3 
	 */
	public static int getDifferenceDigit(int before, int now) {
		boolean[] b = map.get(before);
		boolean[] n = map.get(now);

		int count = 0;
		for (int i = 0; i <= 6; i++) {
			if ((b[i] && !n[i]) || (!b[i] && n[i])) {
				count++;
			}
		}
		return count;
	}

}