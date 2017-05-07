package io.github.Skepter.Problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem079 extends RT {

	/*
	 * https://projecteuler.net/problem=79 Program took 075 milliseconds
	 */
	public static void main(final String[] args) {

		// Stores an integer 0 to 9, followed by how many times that number has
		// occurred first digit
		Map<String, Integer> occurrences1 = new HashMap<String, Integer>();
		Map<String, Integer> occurrences2 = new HashMap<String, Integer>();
		Map<String, Integer> occurrences3 = new HashMap<String, Integer>();

		List<String> list = Utils.readFromFile("p079_keylog.txt");
		for (String str : list) {
			String digit1 = str.substring(0, 1);
			String digit2 = str.substring(1, 2);
			String digit3 = str.substring(2, 3);
			occurrences1.put(digit1, occurrences1.getOrDefault(digit1, 0) + 1);
			occurrences2.put(digit2, occurrences2.getOrDefault(digit2, 0) + 1);
			occurrences3.put(digit3, occurrences3.getOrDefault(digit3, 0) + 1);
		}
		System.out.println("First digit:");
		Utils.printMap(occurrences1);
		System.out.println("Second digit:");
		Utils.printMap(occurrences2);
		System.out.println("Third digit:");
		Utils.printMap(occurrences3);

		/*
		 * By looking at the number distribution, we can take the highest values
		 * to represent values of their placement.
		 * 
		 * For example, 7 appears 21 times in position 1. 73 is found in one of
		 * the numbers, but not 37, so 73 are the first two numbers
		 * 
		 * Likewise, 90 is found in the last two, but not 09
		 * 
		 * 32 is never found, but 31 and 36 are (but 31 is far more common)
		 * 731
		 * 
		 * 162 crops up a lot, but never 12:
		 * 73162
		 * 
		 * 29 appears a LOT, HOWEVER the number 8 also appears in the trials and
		 * 28 appears now and then
		 * 
		 * 73162890
		 */
		uptime();
	}
}
