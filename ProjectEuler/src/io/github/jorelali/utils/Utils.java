package io.github.jorelali.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
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
import java.util.stream.Collectors;

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
	
	public static void assert_(boolean b) {
		if(!b) {
			throw new AssertionError();
		}
	}
	
	/**
	 * Returns the sum of digits of a number
	 */
	public static int sumOfDigits(final int input) {
		int count = 0;
		String s = String.valueOf(input);
		for (int i = 0; i < s.length(); i++) {
			count += Integer.parseInt(Character.toString(s.charAt(i)));
		}
		return count;
	}

	/**
	 * Returns a list of the digits of a number
	 */
	public static List<Integer> digits(int value) {
		return Arrays.stream(digitsArr(value)).boxed().collect(Collectors.toList());
	}
	
	/**
	 * Returns a list of the digits of a number
	 */
	public static List<Long> digits(long value) {
		return Arrays.stream(digitsArr(value)).boxed().collect(Collectors.toList());
	}

	public static long[] digitsArr(long input) {
		String s = String.valueOf(input);
		// 0 ASCII = 48
		return s.chars().boxed().mapToLong(i -> i - 48).toArray();
	}
	
	/**
	 * Returns an array of the digits of a number
	 */
	public static int[] digitsArr(int value) {
		String s = String.valueOf(value);
		// 0 ASCII = 48
		return s.chars().boxed().mapToInt(i -> i - 48).toArray();
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
	 * Converts a Set<> into a (modifiable) List<>
	 */
	public static <T> List<T> convertSetToList(Set<T> set) {
		List<T> list = new ArrayList<T>();
		list.addAll(set);
		return list;
	}

	/**
	 * Converts a List<> into a (modifiable) Set<>
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
	 * Gets prime factor set of a number (List has no repeated factors) input
	 * cannot be less than or equal to 0
	 * Gives numbers in the form:
	 * <n, number of times n appears>
	 */
	public static Map<Integer, Integer> getPrimeFactorMap(int input, List<Integer> primes) {
		Map<Integer, Integer> factors = new HashMap<Integer, Integer>();
		for (int i : primes) {
			while (input % i == 0) {
				factors.put(i, factors.getOrDefault(i, 0) + 1);
				input /= i;
			}
		}
		return factors;
	}

	/**
	 * Synonyms for the GCD include the greatest common factor (GCF), the
	 * highest common factor (HCF), the highest common divisor (HCD), and the
	 * greatest common measure (GCM)<br><br>
	 *  
	 * Returns the greatest common divisor between a and b. gcd(8, 12) = 4
	 */
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	/**
	 * Synonyms for the GCD include the greatest common factor (GCF), the
	 * highest common factor (HCF), the highest common divisor (HCD), and the
	 * greatest common measure (GCM)<br><br>
	 *  
	 * Returns the greatest common divisor between a and b. gcd(8, 12) = 4
	 */
	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	/**
	 * Synonyms for the GCD include the greatest common factor (GCF), the
	 * highest common factor (HCF), the highest common divisor (HCD), and the
	 * greatest common measure (GCM)<br><br>
	 *  
	 * Returns the greatest common divisor between a and b. gcd(8, 12) = 4
	 * 
	 * Implemented using the <a href="https://en.wikipedia.org/wiki/Binary_GCD_algorithm">Binary GCD algorithm</a>
	 * Using implementation from <a href="https://www.geeksforgeeks.org/steins-algorithm-for-finding-gcd/">Geeks for Geeks</a>
	 */
	public static int fastGCD(int a, int b) {
		// GCD(0, b) == b; GCD(a, 0) == a,
        // GCD(0, 0) == 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;
 
        // Finding K, where K is the greatest
        // power of 2 that divides both a and b
        int k;
        for (k = 0; ((a | b) & 1) == 0; ++k)
        {
            a >>= 1;
            b >>= 1;
        }
 
        // Dividing a by 2 until a becomes odd
        while ((a & 1) == 0)
            a >>= 1;
 
        // From here on, 'a' is always odd.
        do
        {
            // If b is even, remove
            // all factor of 2 in b
            while ((b & 1) == 0)
                b >>= 1;
 
            // Now a and b are both odd. Swap
            // if necessary so a <= b, then set
            // b = b - a (which is even)
            if (a > b)
            {
                // Swap u and v.
                int temp = a;
                a = b;
                b = temp;
            }
 
            b = (b - a);
        } while (b != 0);
 
        // restore common factors of 2
        return a << k;
	}

	/**
	 * Computes Euler's Totient function
	 * @param n The number to compute
	 * @param primes A list of primes to help with computation
	 * @return Euler's Totient function
	 */
	public static int totient(int n, List<Integer> primes) {
		if(n <= 0) {
			throw new IllegalArgumentException("input cannot be less than or equal to 0");
		}
		double count = 1;
		for(int i : Utils.getPrimeFactorSet(n, primes)) {
			count *= (1D - 1D / (double) i);
		}
		return (int) (count * n);
	}
	
	//Old totient functions, no longer used anymore (due to being slow/not working)
//	static Map<Integer, Integer> totientMap = new HashMap<>();
//	
//	public static int totientCache(int a, Set<Integer> primes) {
//		if(totientMap.containsKey(a)) {
//			return totientMap.get(a);
//		}
//		int result = totient(a, primes);
//		totientMap.put(a, result);
//		return result;
//	}
//	
//	/**
//	 * Returns the totient function
//	 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
//	 */
//	@Deprecated
//	public static int totient(int a, Set<Integer> primes) {
//		
//		if(a == 2 || a == 1) {
//			return 1;
//		}
//		
//		//φ(nm) = φ(n)φ(m) IFF one of them is prime
//		for(int prime : primes) {
//			if(a % prime == 0 && gcd(a, prime) == 1) {
//				a /= prime;
//				return oldTotient(prime) * totientCache(a, primes);
//			}
//		}
//		
//		return oldTotient(a);
//	}
//	
//	@Deprecated
//	public static int oldTotient(int a) {
//		int count = 0;
//		for (int i = 1; i <= a; i++) {
//			if (a % (gcd(a, i) == 1 ? a + 1 : gcd(a, i)) != 0) {
//				count++;
//			}
//		}
//		return count;
//	}

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
	
	/**
	 * Calculates the n-root of a number and gives it to a precise value
	 * (precision) using the Newton-Raphson method for approximation.
	 * 
	 * @See https://en.wikipedia.org/wiki/Newton's_method#Examples
	 * @param x
	 *            is the value to find the n root for.
	 * @param x0
	 *            is the initial estimate.
	 * @param root
	 *            is the root to find. For example, n = 2 gives the square root
	 *            and n = 3 gives the cube root.
	 * @param iterations
	 *            indicates how many iterations to perform the NewtonRaphson
	 *            method.
	 * @param precision
	 *            is the number of decimal places to be precise. (Generally, use
	 *            precision + 1 to get a desired precision)
	 */
	public static BigDecimal nRootNewtonRaphson(BigDecimal x, BigDecimal x0, int root, int iterations, int precision) {
		iterations--;
		if (iterations == 0) {
			return x0;
		} else {
			BigDecimal numerator = x0.pow(root).subtract(x);
			BigDecimal denominator = x0.multiply(BigDecimal.valueOf(root));
			BigDecimal x1 = x0.subtract(numerator.divide(denominator, precision, RoundingMode.HALF_DOWN));
			return nRootNewtonRaphson(x, x1, root, iterations, precision);
		}
	}
	
	/**
	 * Converts a number to its respective array:
	 * 1234 = [1, 2, 3, 4]
	 * 
	 * @param i The value to convert to array
	 * @param length If length is -1, it will create an array of length of the number.
	 * @param filler If length is used (i.e. not -1), it will fill remaining indexes with the filler number
	 * <br>
	 * For example, toArray(12345, 7, -1) will return [-1, -1, 1, 2, 3, 4, 5]
	 *	
	 */
	public static int[] toArray(int i, int length, int filler) {
//		System.out.println("Converting " + i + " to an array of length " + length + " with filler " + filler);
		if(length == -1) { 
			int[] arr = new int[String.valueOf(i).length()];
			int index = 0;
			for(char c : String.valueOf(i).toCharArray()) {
				arr[index++] = Integer.parseInt(Character.toString(c));
			}
			return arr;
		} else {
			int[] arr = new int[length];
			int loop = 0;
			for(; loop < length - String.valueOf(i).length(); loop++) {
				arr[loop] = filler;
			}
			System.arraycopy(toArray(i, -1, 0), 0, arr, loop, String.valueOf(i).length());
			return arr;
		}
	}
	
	public static boolean isPrime(int i, int certainty) {
		return BigInteger.valueOf(i).isProbablePrime(certainty);
	}
	
	/**
	 * Checks if a number is prime. Can confirm that it can determine numbers <
	 * 982,451,653 (the 50th million prime) accurately
	 * 
	 * @param i The number to check if prime
	 * @return True is prime, False if not prime
	 */
	public static boolean isPrime(int i) {
		return isPrime(i, 20);
	}

	// https://stackoverflow.com/questions/10305153/generating-all-possible-permutations-of-a-list-recursively
	public static <E> List<List<E>> generatePermutations(List<E> original) {
		if (original.isEmpty()) {
			List<List<E>> result = new ArrayList<>();
			result.add(new ArrayList<>());
			return result;
		}
		E firstElement = original.get(0);
		
		// Need to tweak the original answer to not modify the original list!
		List<E> newOriginal = new ArrayList<>();
		for(int i = 1; i < original.size(); i++) {
			newOriginal.add(original.get(i));
		}
		original = newOriginal;
		
		List<List<E>> returnValue = new ArrayList<>();
		List<List<E>> permutations = generatePermutations(original);
		for (List<E> smallerPermutated : permutations) {
			for (int index = 0; index <= smallerPermutated.size(); index++) {
				List<E> temp = new ArrayList<>(smallerPermutated);
				temp.add(index, firstElement);
				returnValue.add(temp);
			}
		}
		return returnValue;
	}
	
}
