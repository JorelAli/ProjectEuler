package io.github.jorelali.problems;

import java.math.BigInteger;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem055 extends RT {

	/*
	 * https://projecteuler.net/problem=55 Lychrel numbers
	 * 
	 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
	 * 
	 * Not all numbers produce palindromes so quickly. For example,
	 * 
	 * 349 + 943 = 1292, 1292 + 2921 = 4213 4213 + 3124 = 7337
	 * 
	 * That is, 349 took three iterations to arrive at a palindrome.
	 * 
	 * Although no one has proved it yet, it is thought that some numbers, like
	 * 196, never produce a palindrome. A number that never forms a palindrome
	 * through the reverse and add process is called a Lychrel number. Due to
	 * the theoretical nature of these numbers, and for the purpose of this
	 * problem, we shall assume that a number is Lychrel until proven otherwise.
	 * In addition you are given that for every number below ten-thousand, it
	 * will either (i) become a palindrome in less than fifty iterations, or,
	 * (ii) no one, with all the computing power that exists, has managed so far
	 * to map it to a palindrome. In fact, 10677 is the first number to be shown
	 * to require over fifty iterations before producing a palindrome:
	 * 4668731596684224866951378664 (53 iterations, 28-digits).
	 * 
	 * Surprisingly, there are palindromic numbers that are themselves Lychrel
	 * numbers; the first example is 4994.
	 * 
	 * How many Lychrel numbers are there below ten-thousand?
	 * 
	 * Program took 168 milliseconds
	 */
	public static void main(final String[] args) {
		assert isLychrel(BigInteger.valueOf(196));
		int count = 0;
		for(int i = 1; i <= 10000; i++) {
			if(isLychrel(BigInteger.valueOf(i))) {
				count++;
			}
		}
		System.out.println(count);
		uptime();
	}
	
	private static boolean isLychrel(BigInteger input) {		
		for(int i = 0; i < 50; i++) {
			if(Utils.isPalindrome(reverse(input).add(input).toString())) {
				return false;
			} else {
				input = reverse(input).add(input);
			}
		}
		return true;
	}
	
	private static BigInteger reverse(BigInteger i) {
		final String str = i.toString();
		final String reversedString = new StringBuilder(str).reverse().toString();
		return new BigInteger(reversedString);
	}
}
