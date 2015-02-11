package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;

public class Problem017 extends RT {

	/*If the numbers 1 to 5 are written out in words: one, two, three, four, five, then 
	 * there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

	If all the numbers from 1 to 1000 (one thousand) inclusive were 
	written out in words, how many letters would be used?

	NOTE: Do not count spaces or hyphens. For example, 
	342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) 
	contains 20 letters. 
	
	The use of "and" when writing out numbers is in compliance with British usage.*/
	public static void main(final String[] args) {
		/*
		 * Check SIZE (length), the digit and if hundred or whatever has to be parsed.
		 */
		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			int[] arr = split(i);
			switch (arr.length) {
			case 1:
				/* 1 - 9 */
				count += getLength(getString(i));
				break;
			case 2:
				if (i < 20) {
					/* 10 - 19*/
					count += getLength(getString(i));
				} else {
					/* 20 - 99 */
					count += getLength(getString(Integer.parseInt(arr[0] + "0")) + ((arr[1] == 0) ? "" : " " + getString(arr[1])));
				}
				break;
			case 3:
				/* 100 - 999 */
				count += getLength(getString(arr[0]) + " " + hundred() + " " + ((arr[1] == 0 && arr[2] == 0) ? "" : and()) + " " + ((arr[1] == 1) ? getString(Integer.parseInt(String.valueOf(arr[1]) + String.valueOf(arr[2]))) : ((arr[1] == 0) ? "" : getString(Integer.parseInt(arr[1] + "0"))) + ((arr[2] == 0) ? "" : " " + getString(arr[2]))));
				break;
			case 4:
				/* 1000 */
				count += getLength(getString(arr[0]) + " " + thousand());
				break;
			}
		}
		System.out.println(count);
		uptime();
	}

	public static int getLength(String number) {
		System.out.println(number.replace(" ", "") + " (" + number.replace(" ", "").length() + ")");
		return number.replace(" ", "").length();
	}

	public static int[] split(int value) {
		char[] chars = String.valueOf(value).toCharArray();
		int[] arr = new int[chars.length];
		for (int i = 0; i < chars.length; i++)
			arr[i] = Integer.parseInt(String.valueOf(chars[i]));
		return arr;
	}

	public static String hundred() {
		return "hundred";
	}

	public static String thousand() {
		return "thousand";
	}

	public static String and() {
		return "and";
	}

	public static String getString(int i) {
		switch (i) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		case 20:
			return "twenty";
		case 30:
			return "thirty";
		case 40:
			return "forty";
		case 50:
			return "fifty";
		case 60:
			return "sixty";
		case 70:
			return "seventy";
		case 80:
			return "eighty";
		case 90:
			return "ninety";
		}
		return null;
	}
}
