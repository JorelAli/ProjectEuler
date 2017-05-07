package io.github.Skepter.Problems;

import java.util.ArrayList;
import java.util.List;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem043 extends RT {

	/* https://projecteuler.net/problem=43 */
	public static void main(final String[] args) {
		System.out.println(Utils.isNPandigital(1406357289, 0, 9));

		/*
		 * So there's 10! (3628800) different 0 to 9 pandigital numbers
		 * 
		 */

		// a) d2d3d4=406 is divisible by 2
		// b) d3d4d5=063 is divisible by 3
		// c) d4d5d6=635 is divisible by 5
		// d) d5d6d7=357 is divisible by 7
		// e) d6d7d8=572 is divisible by 11
		// f) d7d8d9=728 is divisible by 13
		// g) d8d9d10=289 is divisible by 17

		/*
		 * a) d4 is divisible by 2, therefore, d4 must be even {0, 2, 4, 6, 8}
		 */

		/*
		 * c) d6 must be a 5 or a 0 to be divisible by 5 if d6 is 0, then d6d7d8
		 * = 011, 022, 033.... 099, but it's pandigital, therefore d6 MUST be 5.
		 */

		/*
		 * d) Numbers for divibility by 7 with 5 in the middle: {154 259 350 357
		 * 651 658 756 854 952 }
		 */

		System.out.println("Pandigital numbers divisible by 7");
		for (int i = 100; i <= 999; i++) {
			if (String.valueOf(i).toCharArray()[1] == '5' && i % 7 == 0) {
				System.out.println(i);
			}
		}

		/*
		 * e) d6d7d8 Numbers divisible by 11 and start with 5: {506 517 528 539
		 * 561 572 583 594}
		 */
		List<String> div11 = new ArrayList<String>();
		System.out.println("Numbers divisible by 11");
		for (int i = 500; i <= 599; i++) {
			if (i % 11 == 0 && !Utils.hasDuplicateCharacters(String.valueOf(i))) {
				div11.add(String.valueOf(i));
				System.out.println(i);
			}
		}

		/*
		 * f) For divisibility by 13: 104 130 143 169 182 208 234 247 260 273
		 * 286 312 364 390 403 416 429 468 481 624 637 689 702 728 741 780 793
		 * 806 819 832 871 897 910 923 936 962
		 */

		List<String> div13 = new ArrayList<String>();
		System.out.println("Pandigital numbers divisible by 13");
		for (int i = 100; i <= 999; i++) {
			if (i % 13 == 0) {
				if (!String.valueOf(i).contains("5") && !Utils.hasDuplicateCharacters(String.valueOf(i))) {
					div13.add(String.valueOf(i));
					System.out.println(i);
				}
			}
		}

		/*
		 * g) For divisibility by 17: 102 136 170 187 204 238 289 306 340 374
		 * 391 408 476 493 612 629 680 697 714 731 748 782 816 867 901 918 986
		 */
		List<String> div17 = new ArrayList<String>();
		System.out.println("Pandigital numbers divisible by 17");
		for (int i = 100; i <= 999; i++) {
			if (i % 17 == 0) {
				if (!String.valueOf(i).contains("5") && !Utils.hasDuplicateCharacters(String.valueOf(i))) {
					div17.add(String.valueOf(i));
					System.out.println(i);
				}
			}
		}

		/*
		 * f), g) The first two numbers for divisibility by 17 must be the same
		 * as the last 2 for divisibility by 13
		 */
		System.out.println("Suitable numbers for 13 and 17");
		// d7d8d9d10
		List<String> possLast4Digits = new ArrayList<String>();
		for (String a : div13) {
			for (String b : div17) {
				if (b.startsWith(a.substring(1, 3))) {
					possLast4Digits.add((a + b.substring(2, 3)));
					System.out.println(a + ", " + b + " = " + (a + b.substring(2, 3)));
				}
			}
		}

		/*
		 * e), f), g) d6d7d8d9d10 {52867, 53901, 57289}
		 */
		System.out.println("Suitable last 5 digits:");
		List<String> possLast5Digits = new ArrayList<String>();
		for (String a : div11) {
			for (String b : possLast4Digits) {
				if (b.startsWith(a.substring(1, 3))) {
					possLast5Digits.add((a + b.substring(2, 4)));
					System.out.println(a + ", " + b + " = " + (a + b.substring(2, 4)));
				}
			}
		}

		/*
		 * Using the possbile last 5 digits and our result from d), we can
		 * shorten this down, as it must end in a 2, 3 or 7
		 * 
		 * {154 259 350 357 651 658 756 854 952 }
		 */
		
		System.out.println("Suitable last 6 digits:");
		String[] div7 = {"154", "259", "350", "357", "651", "658", "756", "854", "952"};
		List<String> possLast6Digits = new ArrayList<String>();
		for (String a : div7) {
			for (String b : possLast5Digits) {
				if (b.startsWith(a.substring(1, 3))) {
					possLast6Digits.add((a + b.substring(2, 5)));
					System.out.println(a + ", " + b + " = " + (a + b.substring(2, 5)));
				}
			}
		}
		
		/*
		 * Now, using the last 6 digits:
		 * c) d4d5d6=635 is divisible by 5
		 * 
		 */
		
		List<String> div5 = new ArrayList<String>();
		for(int i = 0; i <= 999; i++) {
			if(i % 5 == 0) {
				if(i < 10) {
					div5.add("00"+ String.valueOf(i));
					continue;
				}
				if(i < 100) {
					div5.add("0"+ String.valueOf(i));
					continue;
				}
				div5.add(String.valueOf(i));
			}
		}
		System.out.println("Suitable last 7 digits:");
		List<String> possLast7Digits = new ArrayList<String>();
		for (String a : div5) {
			for (String b : possLast6Digits) {
				if (b.startsWith(a.substring(1, 3))) {
					if(!Utils.hasDuplicateCharacters((a + b.substring(2, 6)))) {
						possLast7Digits.add((a + b.substring(2, 6)));
						System.out.println(a + ", " + b + " = " + (a + b.substring(2, 6)));
					}
					
				}
			}
		}
		
		/*
		 * And so on... with divisibility of 3
		 */
		List<String> div3 = new ArrayList<String>();
		for(int i = 0; i <= 999; i++) {
			if(i % 3 == 0) {
				if(i < 10) {
					div3.add("00"+ String.valueOf(i));
					continue;
				}
				if(i < 100) {
					div3.add("0"+ String.valueOf(i));
					continue;
				}
				div3.add(String.valueOf(i));
			}
		}
		System.out.println("Suitable last 8 digits:");
		List<String> possLast8Digits = new ArrayList<String>();
		for (String a : div3) {
			for (String b : possLast7Digits) {
				if (b.startsWith(a.substring(1, 3))) {
					if(!Utils.hasDuplicateCharacters((a + b.substring(2, 7)))) {
						possLast8Digits.add((a + b.substring(2, 7)));
						System.out.println(a + ", " + b + " = " + (a + b.substring(2, 7)));
					}
					
				}
			}
		}
		
		/*
		 * And so on... with divisibility of 2
		 */
		List<String> div2 = new ArrayList<String>();
		for(int i = 0; i <= 999; i++) {
			if(i % 2 == 0) {
				if(i < 10) {
					div2.add("00"+ String.valueOf(i));
					continue;
				}
				if(i < 100) {
					div2.add("0"+ String.valueOf(i));
					continue;
				}
				div2.add(String.valueOf(i));
			}
		}
		System.out.println("Suitable last 9 digits:");
		List<String> possLast9Digits = new ArrayList<String>();
		for (String a : div2) {
			for (String b : possLast8Digits) {
				if (b.startsWith(a.substring(1, 3))) {
					if(!Utils.hasDuplicateCharacters((a + b.substring(2, 8)))) {
						possLast9Digits.add((a + b.substring(2, 8)));
						System.out.println(a + ", " + b + " = " + (a + b.substring(2, 8)));
					}
					
				}
			}
		}
		
		/*
		 * And finally, we just add the number which is missing:
		 */
		Utils.printListSingleLine(possLast9Digits);
		List<String> pandigitalNumbers = new ArrayList<String>();
		for(String s : possLast9Digits) {
			for(char c : new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}) {
				if(!s.contains(String.valueOf(c)))
					pandigitalNumbers.add(c + s);
			}
		}
		
		/*
		 * AND FINALLY, add them up
		 */
		long count = 0;
		for(String s : pandigitalNumbers) {
			count += Long.parseLong(s);
		}
		System.out.println(count);

		uptime();
	}
}
