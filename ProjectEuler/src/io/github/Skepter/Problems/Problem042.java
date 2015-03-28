package io.github.Skepter.Problems;

import io.github.Skepter.Utils.Incomplete;
import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem042 extends RT implements Incomplete {

	/* The nth term of the sequence of triangle numbers is given by, 
	 * tn = ½n(n+1); so the first ten triangle numbers are:

	1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

	By converting each letter in a word to a number corresponding to its alphabetical 
	position and adding these values we form a word value. For example, the word value 
	for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we 
	shall call the word a triangle word.

	Using words.txt a 16K text file containing 
	nearly two-thousand common English words, how many are triangle words?*/

	//number : triangle number
	public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(final String[] args) {
		init();
		String input = Utils.readFromFile("words.txt").get(0);
		String input1 = input.replace("\"", "");
		List<String> str = Arrays.asList(input1.split(","));
		int count = 0;
		for(String s : str) {
			if(isTriangleWord(s.toLowerCase()))
				count++;
			else continue;
		}
		System.out.println(count);
		uptime();
	}

	public static boolean isTriangleWord(String str) {
		int count = 0;
		for (char c : str.toCharArray()) {
			count += Utils.letterToNumber(c);
		}
		if (getTriangleNumber(count) != -1)
			return true;
		else
			return false;
	}

	public static int getTriangleNumber(int number) {
		if (Utils.reverse(map).get(number) == null) {
			return -1;
		} else
			return Utils.reverse(map).get(number);
	}

	public static void init() {
		for (int i = 1; i <= 10000; i++) {
			int n1 = i * (i + 1);
			int n2 = n1 >> 1;
			map.put(i, n2);
		}
	}
}