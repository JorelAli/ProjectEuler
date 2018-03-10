package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem042 extends RT {

	/* The nth term of the sequence of triangle numbers is given by, 
	 * tn = ½n(n+1); so the first ten triangle numbers are:

	1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

	By converting each letter in a word to a number corresponding to its alphabetical 
	position and adding these values we form a word value. For example, the word value 
	for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we 
	shall call the word a triangle word.

	Using words.txt a 16K text file containing 
	nearly two-thousand common English words, how many are triangle words?
	
	242ms*/

	public static List<Integer> triangles = new ArrayList<Integer>();

	public static void main(final String[] args) {
		init();
		//read file, turn it into a list
		String input = Utils.readFromFile("words.txt").get(0);
		String input1 = input.replace("\"", "");
		List<String> str = Arrays.asList(input1.split(","));
		//go through each word to see if it is triangle or not
		int count = 0;
		for (String s : str)
			if (isTriangleWord(s.toLowerCase()))
				count++;
		System.out.println(count);
		uptime();
	}

	public static boolean isTriangleWord(String str) {
		int count = 0;
		for (char c : str.toCharArray())
			count += Utils.letterToNumber(c);
		return triangles.contains(count);
	}

	//Generate the first 10,000 triangle numbers
	public static void init() {
		for (int i = 1; i <= 10000; i++)
			triangles.add((i * (i + 1)) >> 1);
	}
}