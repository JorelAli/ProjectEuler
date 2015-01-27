package io.github.Skepter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem240 {

	//Find sum of all multiples of 3 and 5 up to 1000
	public static void main(final String[] args) {
		roll(20, 12, 10, 70);
	}

	public static void roll(int numberOfDice, int numberOfSides, int numberSum, int result) {
		/*
		 * Create lists:
		 * {1,1,1,1,1,1,1,1.......}
		 * {2,1,1,1,1,1,1,1.......}
		 * {3,1,1,1,1,1,1,1.......}
		 * 
		 * ...
		 * 
		 * {1,2,1,1,1,1,1,1.......}
		 * {1,1,1,1,1,5,1,1.......}
		 * {12,12,12,12,12,12.....}
		 */

		BigInteger in = new BigInteger(String.valueOf(numberOfSides));
		in = in.pow(numberOfDice);
		
		System.out.println(in);
		//for (int z = 1; z <= maxOutcomes; z++) {
			for (int s = 1; s <= numberOfSides; s++) {
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 1; i <= numberOfSides; i++) {
					list.add(s);
					list.add(i);
				}
				Collections.sort(list);

				int result1 = count(list.subList(list.size() - numberSum, list.size()), numberSum);
				print(list, result1);
			}
		//}
	}

	public static int count(List<Integer> list, int amount) {
		int count = 0;
		for (int i = 0; i < amount; i++) {
			count += list.get(i);
		}
		return count;
	}

	public static void print(List<?> list, Object object) {
		System.out.println(Arrays.toString(list.toArray()).toString() + " - " + object);
	}
}
