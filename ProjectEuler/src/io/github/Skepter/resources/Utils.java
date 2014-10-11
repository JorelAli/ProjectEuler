package io.github.Skepter.resources;

public class Utils {

	public static long sumOfDigits(final String s) {
		long count = 0;
		for (int i = 0; i < s.length(); i++)
			count += Long.parseLong(String.valueOf(s.charAt(i)));
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

	public static boolean isPalindrome(final int i) {
		final String str = String.valueOf(i);
		final String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}

	public static boolean isPalindrome(final String str) {
		final String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}
	
	public static void printList(final List<?> list) {
		for(final Object i : list)
			System.out.println(i);
	}
}
