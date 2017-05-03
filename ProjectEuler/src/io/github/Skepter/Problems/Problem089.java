package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem089 extends RT {

	/*
	 * For a number written in Roman numerals to be considered valid there are
	 * basic rules which must be followed. Even though the rules allow some
	 * numbers to be expressed in more than one way there is always a "best" way
	 * of writing a particular number.
	 * 
	 * For example, it would appear that there are at least six ways of writing
	 * the number sixteen:
	 * 
	 * IIIIIIIIIIIIIIII VIIIIIIIIIII VVIIIIII XIIIIII VVVI XVI
	 * 
	 * However, according to the rules only XIIIIII and XVI are valid, and the
	 * last example is considered to be the most efficient, as it uses the least
	 * number of numerals.
	 * 
	 * The 11K text file, roman.txt, contains one thousand numbers written in
	 * valid, but not necessarily minimal, Roman numerals; see
	 * https://projecteuler.net/about=roman_numerals for the definitive rules
	 * for this problem.
	 * 
	 * Find the number of characters saved by writing each of these in their
	 * minimal form.
	 * 
	 * Note: You can assume that all the Roman numerals in the file contain no
	 * more than four consecutive identical units.
	 * 
	 * 145ms
	 */
	public static void main(final String[] args) {
		int count = 0;
		for (String string : Utils.readFromFile("roman.txt")) {

			int number = convertRomanToInt(string);
			String condensedRoman = convertIntToRoman(number);
			if (condensedRoman.length() < string.length()) {
				count += (string.length() - condensedRoman.length());
			}
		}
		System.out.println(count);
		uptime();
	}

	public static String convertIntToRoman(int i) {
		String output = "";
		while (i > 0) {
			if (i >= 1000) {
				i -= 1000;
				output = output + "M";
				continue;
			} else if (i >= 900) {
				i -= 900;
				output = output + "CM";
				continue;
			} else if (i >= 500) {
				i -= 500;
				output = output + "D";
				continue;
			} else if (i >= 400) {
				i -= 400;
				output = output + "CD";
				continue;
			} else if (i >= 100) {
				i -= 100;
				output = output + "C";
				continue;
			} else if (i >= 90) {
				i -= 90;
				output = output + "XC";
				continue;
			} else if (i >= 50) {
				i -= 50;
				output = output + "L";
				continue;
			} else if (i >= 40) {
				i -= 40;
				output = output + "XL";
				continue;
			} else if (i >= 10) {
				i -= 10;
				output = output + "X";
				continue;
			} else if (i >= 9) {
				i -= 9;
				output = output + "IX";
				continue;
			} else if (i >= 5) {
				i -= 5;
				output = output + "V";
				continue;
			} else if (i >= 4) {
				i -= 4;
				output = output + "IV";
				continue;
			} else if (i >= 1) {
				i -= 1;
				output = output + "I";
				continue;
			}
		}
		return output;
	}

	public static int convertRomanToInt(final String roman) {
		int count = 0;
		for (int i = 0; i < roman.length() - 1; i++) {
			if (charToInt(roman.charAt(i)) < charToInt(roman.charAt(i + 1))) {
				count -= charToInt(roman.charAt(i));
			} else {
				count += charToInt(roman.charAt(i));
			}
		}
		count += charToInt(roman.charAt(roman.length() - 1));
		return Math.abs(count);
	}

	public static int charToInt(final char character) {
		return RomanNumbers.valueOf(String.valueOf(character)).getNumericalValue();
	}

	public enum RomanNumbers {
		M(1000, "M"), D(500, "D"), C(100, "C"), L(50, "L"), X(10, "X"), V(5, "V"), I(1, "I");

		private int i;
		private String chr;

		RomanNumbers(int i, String chr) {
			this.i = i;
			this.chr = chr;
		}

		int getNumericalValue() {
			return i;
		}

		String getRomanCharacter() {
			return chr;
		}
	}

}
