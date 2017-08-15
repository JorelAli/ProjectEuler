package io.github.skepter.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import io.github.skepter.utils.Incomplete;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem145 extends RT implements Incomplete {

	/*Some positive integers n have the property that the sum [ n + reverse(n) ] 
	 * consists entirely of odd (decimal) digits. For instance, 36 + 63 = 99 
	 * and 409 + 904 = 1313. We will call such numbers reversible; so 36, 63, 409, and 904 are reversible. 
	 * Leading zeroes are not allowed in either n or reverse(n).

	There are 120 reversible numbers below one-thousand.

	How many reversible numbers are there below one-billion (10^9)
	
	748355

	Program took 2411669ms
	*/
	
	static Pattern pattern = Pattern.compile("0|2|4|6|8");

	public static void main(final String[] args) {
		
		/*
		 * Odd number + odd number = even
		 * Even number + even number = even
		 * 
		 * Odd + even = odd.
		 */
		
		
		
		
		
		
		
		int count = 0;
		Set<Integer> integerSet = new HashSet<Integer>();
		//only have to check the numbers from 1 to 500 million
		for(int i = 1; i <= 500000000; i++) {
			if(i == 1000000) {
				uptime();
			}
				
			if(!integerSet.contains(i)) {
				int reverse = Utils.getReverse(i);
				int num = i + reverse;
				
				boolean even = isEven(i);
				boolean reverseEven = isEven(reverse);
				
				if(even ^ reverseEven) {
					//if(!isEven(num)) {
						if(isAllOdd(num)) {
							integerSet.add(i);
							integerSet.add(reverse);
							count++;
						}
					//}
				}
			}
		}
		System.out.println(count);
		uptime();
	}
	
	private static boolean isEven(int i) {
		return i % 2 == 0;
	}
	
	public static boolean isAllOdd(int n) {
		return !(pattern.matcher(String.valueOf(n)).matches());
	}
	
//	public static boolean isAllOdd(int number) {
//	boolean odd = true;
//	String s = String.valueOf(number);
//	if(s.mat)
//	for (int i = 0; i < s.length(); i++) {
//		if (isEven(Integer.parseInt(String.valueOf(s.charAt(i))))) {
//			odd = false;
//		}
//	}
//	return odd;
//}
	
//  FIRST ATTEMPT
// 
//	static int i = 0;
//
//	public static void main(final String[] args) throws InterruptedException {
//		List<Thread> threads = new ArrayList<Thread>();
//		Thread thread = new Thread() {
//			public void run() {
//				i += findReversables(0, 1000000);
//			}
//		};
//		Thread thread1 = new Thread() {
//			public void run() {
//				i += findReversables(1000001, 10000000);
//			}
//		};
//		Thread thread2 = new Thread() {
//			public void run() {
//				i += findReversables(10000001, 100000000);
//			}
//		};
//		Thread thread3 = new Thread() {
//			public void run() {
//				i += findReversables(100000001, 1000000000);
//			}
//		};
//		threads.add(thread);
//		threads.add(thread1);
//		threads.add(thread2);
//		threads.add(thread3);
//		for (Thread t : threads) {
//			t.start();
//			t.join();
//		}
//		System.out.println(i);
//		uptime();
//	}
//
//	public static int findReversables(int min, int max) {
//		int count = -5;
//		for (int i = min; i <= max; i++) {
//			if (isEven(i) && isEven(Utils.getReverse(i)))
//				continue;
//			if (isAllOdd(i + Utils.getReverse(i))) {
//				count++;
//			}
//		}
//		return count;
//	}
//
//	public static boolean isEven(int number) {
//		if (number % 2 == 0)
//			return true;
//		return false;
//	}
//
//	public static boolean isAllOdd(int number) {
//		boolean odd = true;
//		String s = String.valueOf(number);
//		for (int i = 0; i < s.length(); i++) {
//			if (isEven(Integer.parseInt(String.valueOf(s.charAt(i))))) {
//				odd = false;
//			}
//		}
//		return odd;
//	}
}
