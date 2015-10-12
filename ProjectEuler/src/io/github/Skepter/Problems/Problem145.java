package io.github.Skepter.Problems;

import io.github.Skepter.Utils.Incomplete;
import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

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

	static int i = 0;

	public static void main(final String[] args) throws InterruptedException {
		List<Thread> threads = new ArrayList<Thread>();
		Thread thread = new Thread() {
			public void run() {
				i += findReversables(0, 1000000);
			}
		};
		Thread thread1 = new Thread() {
			public void run() {
				i += findReversables(1000001, 10000000);
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				i += findReversables(10000001, 100000000);
			}
		};
		Thread thread3 = new Thread() {
			public void run() {
				i += findReversables(100000001, 1000000000);
			}
		};
		threads.add(thread);
		threads.add(thread1);
		threads.add(thread2);
		threads.add(thread3);
		for (Thread t : threads) {
			t.start();
			t.join();
		}
		System.out.println(i);
		uptime();
	}

	public static int findReversables(int min, int max) {
		int count = -5;
		for (int i = min; i <= max; i++) {
			if (isEven(i) && isEven(Utils.getPalindrome(i)))
				continue;
			if (isAllOdd(i + Utils.getPalindrome(i))) {
				count++;
			}
		}
		return count;
	}

	public static boolean isEven(int number) {
		if (number % 2 == 0)
			return true;
		return false;
	}

	public static boolean isAllOdd(int number) {
		boolean odd = true;
		String s = String.valueOf(number);
		for (int i = 0; i < s.length(); i++) {
			if (isEven(Integer.parseInt(String.valueOf(s.charAt(i))))) {
				odd = false;
			}
		}
		return odd;
	}
}
