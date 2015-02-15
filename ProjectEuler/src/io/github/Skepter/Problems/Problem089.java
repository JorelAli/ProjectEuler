package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem089 extends RT {

	/*For a number written in Roman numerals to be considered valid there are 
	 * basic rules which must be followed. Even though the rules allow some 
	 * numbers to be expressed in more than one way there is always a "best" 
	 * way of writing a particular number.

	For example, it would appear that there are at least six ways of writing 
	the number sixteen:

	IIIIIIIIIIIIIIII
	VIIIIIIIIIII
	VVIIIIII
	XIIIIII
	VVVI
	XVI

	However, according to the rules only XIIIIII and XVI are valid, and the 
	last example is considered to be the most efficient, as it uses the least number of numerals.

	The 11K text file, roman.txt,
	contains one thousand numbers written in valid, but not necessarily minimal, Roman numerals; 
	see https://projecteuler.net/about=roman_numerals for the definitive rules for this problem.

	Find the number of characters saved by writing each of these in their minimal form.

	Note: You can assume that all the Roman numerals in the file contain no more than four 
	consecutive identical units.*/
	public static void main(final String[] args) {
		for (String string : Utils.readFromFile("roman.txt"))
			System.out.println(string + ": " + convertRomanToInt(string));
		uptime();
	}

	public static int convertRomanToInt(final String roman) {
		int count = 0;
		for (int i = 0; i < roman.length() - 1; i++) {
			if (charToInt(roman.charAt(i)) < charToInt(roman.charAt(i+1))) {
				count -= charToInt(roman.charAt(i));
			} else {
				count += charToInt(roman.charAt(i));
			}
		}
        count += charToInt(roman.charAt(roman.length() - 1));
		return Math.abs(count);
	}

	public static int charToInt(final char character) {
		switch (character) {
		case 'M':
			return 1000;
		case 'D':
			return 500;
		case 'C':
			return 100;
		case 'L':
			return 50;
		case 'X':
			return 10;
		case 'V':
			return 5;
		case 'I':
			return 1;
		default:
			return 0;
		}
	}
}
