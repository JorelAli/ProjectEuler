package io.github.Skepter.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.github.Skepter.ForeignUtils.SieveWithBitset;
import io.github.Skepter.Problems.Problem037;

public class Utils {

	/**
	 * Returns the sum of digits of a number
	 */
	public static long sumOfDigits(final String s) {
		long count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '.')
				count += Long.parseLong(String.valueOf(s.charAt(i)));
		}
		return count;
	}

	/**
	 * Returns a list of the digits of a number
	 */
	public static List<Integer> digits(int value) {
		String s = String.valueOf(value);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++)
			list.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		return list;
	}

	/**
	 * Returns the product of digits of a number
	 */
	public static long productOfDigits(long l) {
		long remainder = 0, product = 1;
		while (l != 0) {
			remainder = l % 10;
			l = l / 10;
			product = product * remainder;
		}
		return product;
	}

	/**
	 * Converts letters to numbers (a = 1, b = 2... z = 26)
	 */
	public static int letterToNumber(char c) {
		return (String.valueOf(c).toLowerCase().toCharArray()[0] - 'a' + 1);
	}

	/**
	 * Checks if an integer is a palindrome (the same as in reverse)
	 */
	public static boolean isPalindrome(final int i) {
		return isPalindrome(String.valueOf(i));
	}

	/**
	 * Gets the reverse of an integer
	 */
	public static int getReverse(final int i) {
		final String str = String.valueOf(i);
		final String reversedString = new StringBuilder(str).reverse().toString();
		return Integer.parseInt(reversedString);
	}

	/**
	 * Checks if a String is a palindrome (the same as in reverse)
	 */
	public static boolean isPalindrome(final String str) {
		final String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}

	/**
	 * Checks if a number is prime<br>
	 * If using this function multiple times, consider extracting it and using
	 * the function once
	 * 
	 * @see Problem037
	 */
	public static boolean isPrime(int i) {
		if (i <= 0) {
			return false;
		}
		return SieveWithBitset.sieveOfEratosthenes(i).contains(i);
	}

	/**
	 * Prints a list
	 */
	public static void printList(final Collection<?> list) {
		for (final Object i : list)
			System.out.println(i);
	}

	/**
	 * Prints a list to onto a single line
	 */
	public static void printListSingleLine(final Collection<?> list) {
		System.out.println(Arrays.toString(list.toArray()).toString());
	}

	/**
	 * Prints an array
	 */
	public static void printArray(Object[] input) {
		for (Object item : input) {
			System.out.println(item);
		}
	}

	/**
	 * Prints an array onto a single line
	 */
	public static void printArraySingleLine(Object[] input) {
		System.out.println(Arrays.toString(input).toString());
	}

	/**
	 * Prints a map
	 */
	public static void printMap(Map<?, ?> map) {
		for (Object key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
	}

	/**
	 * Allows you to read data from files in /ResourceFiles/
	 */
	public static List<String> readFromFile(String fileName) {
		try {
			List<String> lines = new ArrayList<String>();
			final URL url = Utils.class.getResource("/ResourceFiles/" + fileName);
			final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				lines.add(inputLine);
			}
			in.close();
			return lines;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Reverses a map (replaces values with keys)
	 */
	public static <A, B> Map<B, A> reverse(Map<A, B> map) {
		Map<B, A> newMap = new HashMap<B, A>();
		for (Entry<A, B> entry : map.entrySet()) {
			newMap.put(entry.getValue(), entry.getKey());
		}
		return newMap;
	}

	/**
	 * Performs the combinations function (nCr)
	 */
	public static BigInteger combinations(final int N, final int r) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < r; k++) {
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(BigInteger.valueOf(k + 1));
		}
		return ret;
	}

	/**
	 * Converts a Set<> into a List<>
	 */
	public static <T> List<T> convertSetToList(Set<T> set) {
		List<T> list = new ArrayList<T>();
		list.addAll(set);
		return list;
	}
	
	/**
	 * Converts a List<> into a Set<>
	 */
	public static <T> Set<T> convertListToSet(List<T> list) {
		Set<T> set = new HashSet<T>();
		set.addAll(list);
		return set;
	}

	/**
	 * Returns an array of truncated combinations<br>
	 * Input = (hello, false)<br>
	 * Output = [hello, hell, hel, he, h]<br>
	 * <br>
	 * Input = (hello, true)<br>
	 * Output = [hello, ello, llo, lo, o]<br>
	 */
	public static String[] getTruncatedArray(String input, boolean reverse) {
		if (reverse) {
			String[] arr = new String[input.length()];
			for (int i = 1; i < input.length(); i++) {
				arr[i - 1] = input.substring(i - 1, input.length());
			}
			arr[0] = input;
			arr[input.length() - 1] = input.substring(input.length() - 1, input.length() - 0);
			return arr;
		} else {
			String[] arr = new String[input.length()];
			for (int i = 1; i < input.length(); i++) {
				arr[i - 1] = input.substring(0, i);
			}
			arr[input.length() - 1] = input;
			return arr;
		}
	}

	/**
	 * Returns true if the number is n-pandigital. For example,
	 * nPandigital(12345, 1, 5) returns true because it is pandigital for
	 * numbers up to 5
	 */
	public static boolean isNPandigital(String input, int lowerN, int upperN) {
		for (int i = lowerN; i <= upperN; i++) {
			if (!input.contains(String.valueOf(i))) {
				return false;
			}
			input = input.replaceFirst(String.valueOf(i), "");
		}
		return input.equals("");
	}

	/**
	 * Returns true if the number is n-pandigital. For example,
	 * nPandigital(12345, 1, 5) returns true because it is pandigital for
	 * numbers up to 5
	 */
	public static boolean isNPandigital(int input, int lowerN, int upperN) {
		return isNPandigital(String.valueOf(input), lowerN, upperN);
	}

	/**
	 * Returns true if the number is n-pandigital. For example,
	 * nPandigital(12345, 1, 5) returns true because it is pandigital for
	 * numbers up to 5
	 */
	public static boolean isNPandigital(long input, int lowerN, int upperN) {
		return isNPandigital(String.valueOf(input), lowerN, upperN);
	}

	/**
	 * Checks if a string has duplicate charactors
	 */
	public static boolean hasDuplicateCharacters(String str) {
		List<Character> charSet = new ArrayList<Character>();
		for (char c : str.toCharArray())
			if (charSet.contains(c)) {
				return true;
			} else {
				charSet.add(c);
			}
		return false;
	}

	/**
	 * Gets prime factors of a number
	 * input cannot be less than or equal to 0
	 */
	public static List<Integer> getPrimeFactors(int input, List<Integer> primes) {
		List<Integer> factors = new ArrayList<Integer>();
		for (int i : primes) {
			while (input % i == 0) {
				factors.add(i);
				input /= i;
			}
		}
		return factors;
	}
	
	/**
	 * Gets prime factor set of a number (List has no repeated factors)
	 * input cannot be less than or equal to 0
	 */
	public static Set<Integer> getPrimeFactorSet(int input, List<Integer> primes) {
		Set<Integer> factors = new HashSet<Integer>();
		for (int i : primes) {
			while (input % i == 0) {
				factors.add(i);
				input /= i;
			}
		}
		return factors;
	}
	
	/**
	 * Returns the greatest common divisor between a and b.
	 * gcd(8, 12) = 4
	 */
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	/**
	 * Returns the greatest common divisor between a and b.
	 * gcd(8, 12) = 4
	 */
	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	/**
	 * Returns the phi function
	 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
	 */
	public static int phi(int a) {
		int count = 0;
		for(int i = 1; i <= a; i++) {
			if(a % (gcd(a, i) == 1 ? a+1 : gcd(a, i)) != 0) {
				count++;
			}
		}
		return count;
	}

}
