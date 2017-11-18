package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import io.github.skepter.foreignutils.SieveWithBitset;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem315 extends RT {

	/* https://projecteuler.net/problem=315 */
	public static void main(final String[] args) {

		new LEDNumber();

		// Test rig
		//ArrayList<Integer> primes = Arrays.stream(new int[]{137}).boxed().collect(Collectors.toCollection(ArrayList::new));

		// Create an ArrayList of all prime numbers between 10^7 and 2x10^7
		ArrayList<Integer> primes = SieveWithBitset.getPrimes(2 * (int) Math.pow(10, 7)).stream()
				.filter(i -> i > Math.pow(10, 7)).collect(Collectors.toCollection(ArrayList::new));
		Collections.sort(primes);

		System.out.println(Arrays.toString(digitalRoot(137, null))); //Should equal [137, 11, 2]
		System.out.println(LEDNumber.getDifference(137, 11)); //Should equal 7
		
		// Tests
		// System.out.println(LEDNumber.getDifferenceDigit(0, 5)); // = 3
		// System.out.println(Arrays.toString(Utils.toArray(1234, -1, 0))); // =
		// [1, 2, 3, 4]
		// System.out.println(Arrays.toString(Utils.toArray(12345, 7, -1))); //
		// = [-1, -1, 1, 2, 3, 4, 5]
		// System.out.println(Arrays.toString(Utils.toArray(12345, 5, -1))); //
		// = [1, 2, 3, 4, 5]

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
		
		//Very first one
		//max += LEDNumber.getDifference(-1, primes.get(0));
		
		for (int i = 0; i < primes.size(); i++) {
			max += LEDNumber.getDifference(-1, primes.get(i));
			for(int j = 0; j < digitalRoot(primes.get(i), null).length - 1; j++) {
				max += LEDNumber.getDifference(digitalRoot(primes.get(i), null)[j], digitalRoot(primes.get(i), null)[j+1]);
			}
			int[] finalArr = digitalRoot(primes.get(i), null);
			max += LEDNumber.getDifference(-1, finalArr[finalArr.length - 1]);
			//need to clear the clock here
			
			//max += LEDNumber.getDifference(primes.get(i), primes.get(i + 1));

		}
		
		
//		int[] finalArr = digitalRoot(primes.get(primes.size() - 1), null);
//		max += LEDNumber.getDifference(-1, finalArr[finalArr.length - 1]);
		
//		for(int i : digitalRoot(primes.get(primes.size() - 1), null)) {
//			max += LEDNumber.getDifference(-1, i);
//		}
		
		//max += LEDNumber.getDifference(-1, primes.get(primes.size() - 1));

		System.out.println("Total number of transitions(Sam): " + sam);
		System.out.println("Total number of transitions(Max): " + max);
		System.out.println("Difference = " + (sam - max));
		uptime();
	}

	
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

class LEDNumber {

	static HashMap<Integer, boolean[]> map;

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
	
	public static int getDifference(int before, int now) {

		int count = 0;

		int arrLength = Math.max(String.valueOf(before).length(), String.valueOf(now).length());

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

	/*
	 * 1, 7 -> 1 0, 5 -> 3
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
