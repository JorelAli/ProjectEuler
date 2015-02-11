package io.github.Skepter.Utils;

import io.github.Skepter.ForeignUtils.SieveWithBitset;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

	public static boolean isPrime(int i) {
		return SieveWithBitset.sieveOfEratosthenes(i).contains(i);
	}
	
	public static void printList(final List<?> list) {
		for(final Object i : list)
			System.out.println(i);
	}
	
	public static void printListSingleLine(final Collection<?> list) {
		System.out.println(Arrays.toString(list.toArray()).toString());
	}

	public static void printArray(int[] split) {
		for(int item : split) {
			System.out.println(item);
		}
	}
	
}
