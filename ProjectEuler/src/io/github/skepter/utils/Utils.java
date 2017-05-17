package io.github.skepter.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
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

public class Utils {

	/**
	 * Returns the sum of digits of a number
	 */
	public static long sumOfDigits(final String s) {
		long count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '.')
				count += Long.parseLong(String.valueOf(s.charAt(i)));
		}
		return count;
	}
	
	/**
	 * Returns the sum of digits of a number
	 */
	public static int sumOfDigits(final int input) {
		int count = 0;
		String s = String.valueOf(input);
		for (int i = 0; i < s.length(); i++) {
			count += Integer.parseInt(String.valueOf(s.charAt(i)));
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
	 * Gets the reverse of an integer: 1234 turns into 4321
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
	
	
//	/**
//	 * Performs the combinations function (nCr)
//	 */
//	public static int combinations(final int n, final int r) {
//		return factorial(n) / (factorial(r) * factorial(n - r));
//	}


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
	 * Gets prime factors of a number input cannot be less than or equal to 0
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
	 * Gets prime factor set of a number (List has no repeated factors) input
	 * cannot be less than or equal to 0
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
	 * Returns the greatest common divisor between a and b. gcd(8, 12) = 4
	 */
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	/**
	 * Returns the greatest common divisor between a and b. gcd(8, 12) = 4
	 */
	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	/**
	 * Returns the totient function
	 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
	 */
	@Deprecated
	public static int totient(int a) {
		int count = 0;
		for (int i = 1; i <= a; i++) {
			if (a % (gcd(a, i) == 1 ? a + 1 : gcd(a, i)) != 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Checks if a string is a permutation of another string
	 * isPermutation("hello", "hlloe") is true.
	 */
	public static boolean isPermutation(String a, String b) {
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		Arrays.sort(aArr);
		Arrays.sort(bArr);
		return Arrays.equals(aArr, bArr);
	}

	/**
	 * Checks if an integer is a permutation of another integer
	 * isPermutation("1234", "4132") is true.
	 */
	public static boolean isPermutation(int a, int b) {
		return isPermutation(String.valueOf(a), String.valueOf(b));
	}

	/**
	 * Checks if an integer is a permutation of another integer
	 * isPermutation("1234", "4132") is true.
	 */
	public static boolean isPermutation(long a, long b) {
		return isPermutation(String.valueOf(a), String.valueOf(b));
	}

	
	/**
	 * Returns ln(a^b), where ^ represents power and ln is the natural logarithm
	 */
	public static double ln(int a, int b) {
		return b * Math.log(a);
	}
	
	/**
	 * Returns if a number is an integer
	 */
	public static boolean isInteger(double d) {
		return(d % 1 == 0);
	}
	
	/**
	 * Checks if a big decimal is an integer
	 */
	public static boolean isInteger(BigDecimal bd) {
		return bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0;
	}
	
	/**
	 * Converts a base 10 number to another base
	 */
	public static int convertBase(int i, int base) {
		return Integer.parseInt(Integer.toString(i, base));
	}
	
	/**
	 * Converts a base 10 number to another base
	 */
	public static long convertBase(long i, int base) {
		return Long.parseLong(Long.toString(i, base));
	}
	
	/**
	 * Converts a base 10 number to another base
	 */
	public static String convertBaseToString(long i, int base) {
		return Long.toString(i, base);
	}

	/**
	 * Calculates the factorial of a number
	 */
	public static int factorial(int input) {
		if(input == 0) {
			return 1;
		} else if(input < 0) {
			throw new ArithmeticException("Cannot calculate factorial for negative number: " + input);
		} else { 
			int count = 1;
			for(int i = 1; i <= input; i++) {
				count *= i;
			}
			return count;
		}
	}
	
	/**
	 * Calculates the factorial of a number
	 */
	public static long factorial(long input) {
		if(input == 0) {
			return 1L;
		} else if(input < 0) {
			throw new ArithmeticException("Cannot calculate factorial for negative number: " + input);
		} else { 
			long count = 1;
			for(long i = 1; i <= input; i++) {
				count *= i;
			}
			return count;
		}
	}
	
	/**
	 * Changes the output of System.out.println(). Put this at the top of your code.
	 */
	public static void outputToFile(String fileName) {
		try {
			System.setOut(new PrintStream(new FileOutputStream(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the number of digits in a number to the power of another<br>
	 * So 4^5 = 1024, so length = 4
	 */
	public static int lengthOfNumber(int base, int power) {
		return (int) (Math.floor(power * Math.log10(base)) + 1);
	}
	
}
