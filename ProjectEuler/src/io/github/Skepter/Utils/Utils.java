package io.github.Skepter.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.github.Skepter.ForeignUtils.SieveWithBitset;

public class Utils {

	/**
	 * Returns the sum of digits of a number
	 * e.g. 123 = 6
	 * @param s - input string
	 * @return sum of digits
	 */
	public static long sumOfDigits(final String s) {
		long count = 0;
		for (int i = 0; i < s.length(); i++)
			count += Long.parseLong(String.valueOf(s.charAt(i)));
		return count;
	}
	
	public static List<Integer> digits(int value) {
		String s = String.valueOf(value);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++)
			list.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		return list;
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
	
	public static int letterToNumber(char c) {
		return (String.valueOf(c).toLowerCase().toCharArray()[0] - 'a' + 1);
	}

	public static boolean isPalindrome(final int i) {
		final String str = String.valueOf(i);
		final String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}

	public static int getReverse(final int i) {
		final String str = String.valueOf(i);
		final String reversedString = new StringBuilder(str).reverse().toString();
		return Integer.parseInt(reversedString);
	}

	public static boolean isPalindrome(final String str) {
		final String reversedString = new StringBuilder(str).reverse().toString();
		if (reversedString.equals(str))
			return true;
		return false;
	}

	public static boolean isPrime(int i) {
		if(i <=0 ) {
			return false;
		}
		return SieveWithBitset.sieveOfEratosthenes(i).contains(i);
	}

	public static void printList(final Collection<?> list) {
		for (final Object i : list)
			System.out.println(i);
	}

	public static void printListSingleLine(final Collection<?> list) {
		System.out.println(Arrays.toString(list.toArray()).toString());
	}

	public static void printArray(int[] input) {
		for (int item : input) {
			System.out.println(item);
		}
	}
	
	public static void printArray(String[] input) {
		for (String item : input) {
			System.out.println(item);
		}
	}
	
	public static void printMap(Map<?, ?> map) {
		for (Object key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
	}

	public static List<String> readFromFile(String fileName) {
		try {
			List<String> lines = new ArrayList<String>();
			final URL url = Utils.class.getResource("/ResourceFiles/" + fileName);
			final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while((inputLine = in.readLine()) != null) {
				lines.add(inputLine);
			}
			in.close();
			return lines;
		} catch (Exception e) {
		}
		return null;
	}
	
	public static <A, B> Map<B, A> reverse(Map<A, B> map) {
		Map<B, A> newMap = new HashMap<B, A>();
		for (Entry<A, B> entry : map.entrySet()) {
			newMap.put(entry.getValue(), entry.getKey());
		}
		return newMap;
	}
	
	public static BigInteger combinations(final int N, final int r) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < r; k++) {
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(BigInteger.valueOf(k + 1));
		}
		return ret;
	}
	
	public static <T> List<T> convertSetToList(Set<T> set) {
		List<T> list = new ArrayList<T>();
		Iterator<T> it = set.iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	/**
	 * Returns an array of truncated combinations?
	 * Input = (hello, false)
	 * Output = [hello, hell, hel, he, h]
	 * 
	 * Input = (hello, true)
	 * Output = [hello, ello, llo, lo, o]
	 * @return
	 */
	public static String[] getTruncatedArray(String input, boolean reverse) {
		if(reverse) {
			String[] arr = new String[input.length()];
			for(int i = 1; i < input.length(); i++) {
				arr[i - 1] = input.substring(i-1, input.length());
			}
			arr[0] = input;
			arr[input.length() - 1] = input.substring(input.length() - 1, input.length() - 0);
			return arr;
		} else {
			String[] arr = new String[input.length()];
			for(int i = 1; i < input.length(); i++) {
				arr[i - 1] = input.substring(0, i);
			}
			arr[input.length() - 1] = input;
			return arr;
		}
		
	}

}
