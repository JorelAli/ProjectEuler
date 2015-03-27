package io.github.Skepter.Problems;

import io.github.Skepter.Utils.Incomplete;
import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem042 extends RT implements Incomplete{

	/* The nth term of the sequence of triangle numbers is given by, 
	 * tn = ½n(n+1); so the first ten triangle numbers are:

	1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

	By converting each letter in a word to a number corresponding to its alphabetical 
	position and adding these values we form a word value. For example, the word value 
	for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we 
	shall call the word a triangle word.

	Using words.txt a 16K text file containing 
	nearly two-thousand common English words, how many are triangle words?*/

	public static Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	public static void main(final String[] args) {
		String input = Utils.readFromFile("words.txt").get(0);
		String input1 = input.replace("\"", "");
		List<String> str = Arrays.asList(input1.split(","));
		uptime();
	}

	public static boolean isTriangleWord(String str) {

		return false;
	}

	public static boolean isTriangle(int number) {
		int n1 = number * (number + 1);
		int n2 = n1 >> 1;
		return false;
	}

	public static void init() {
		for (int i = 1; i <= 10000; i++) {
			map.put(i, isTriangle(i));
		}
	}
}