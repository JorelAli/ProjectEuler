package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;

public class Problem076 extends RT {

	/**/
	public static void main(final String[] args) {
		//System.out.println(function(1)); // 0: 
		//System.out.println(function(2)); // 1: 1 + 1
		//System.out.println(function(3)); // 2: 2 + 1, 1 + 1 + 1
		//System.out.println(function(4)); // 4: 3 + 1, 2 + 2, 2 + 1 + 1, 1 + 1 + 1 + 1
		System.out.println(function(5)); // 6:
		uptime();
	}
	
	public static int function(int input) {
		System.out.println("--- start " + input);
		if(input == 1) {
			return 0;
		}

		int result = 0;
		for(int i = input - 1; i >= 1; i--) {
			System.out.println("currently dealing with " + i);
			int a = input - i;
			if(a == 1 || i == 1) {
				result++;
			} else {
				System.out.println("Adding recursion from " + a);
				int f = function(a);
				System.out.println("--- end " + a);
				System.out.println(f);
				result += f + 1;
			}
			System.out.println("temp result = " + result);
		}
		return result;
	}
}
