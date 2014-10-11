package io.github.Skepter;
import io.github.Skepter.resources.Utils;


public class Problem036 {

	//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i <= 1000000; i++) {
			if(Utils.isPalindrome(i) && Utils.isPalindrome(Integer.toBinaryString(i))) {
				count += i;
			}
		}
		System.out.println(count);
	}
}
