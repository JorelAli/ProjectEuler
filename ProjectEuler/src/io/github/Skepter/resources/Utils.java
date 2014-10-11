package io.github.Skepter.resources;

import java.util.List;

public class Utils {

	public static long sumOfDigits(String s) {
		long count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += Long.parseLong(String.valueOf(s.charAt(i)));
		}
		return count;
	}

	public static long productOfDigits(long l) {
		long remainder = 0, product = 1;
		while (l != 0) {
			remainder = l % 10;
			l = l / 10;
			product = product * remainder;
		}
		return product;
	}

	public static boolean isPalindrome(int i) {
		String str = String.valueOf(i);
		String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}

	public static boolean isPalindrome(String str) {
		String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}
	
	public static void printList(List<?> list) {
		for(Object i : list) {
			System.out.println(i);
		}
	}
}
