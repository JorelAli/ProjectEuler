package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.jorelali.utils.RT;

public class Problem033 extends RT {

	/* https://projecteuler.net/problem=33 
	 * 97ms*/
	public static void main(final String[] args) {
		/*
		 * Gets a list of all numbers which have digits
		 * which appear in both numerator and denominator
		 */
		List<String> fractions = new ArrayList<String>();
		for(int i = 10; i <= 99; i++) {
			for(int j = 10; j <= 99; j++) {
				//iterate the digits for the first number and check if they exist in the second number.
				//if so, print out numerator/denominator
				for(char c : String.valueOf(i).toCharArray()) {
					if(String.valueOf(j).contains(String.valueOf(c)) && i < j /* Must be less than 1 */) {
						fractions.add(i + "/" + j);
					}
				}
			}	
		}
		
		/*
		 * Filters out that list whether the first digit of the denominator
		 * is the second digit of the numerator (and vice versa)
		 * 
		 * e.g. 49 and 98 have 9 in them, one at the end and one at the start
		 */
		Set<String> cancellableFractions = new HashSet<String>();
		for(String str : fractions) {
			double num = Double.parseDouble(str.split("/")[0]);
			double denom = Double.parseDouble(str.split("/")[1]);
			if(num == denom) {
				continue;
			}
			//check first & last digits
			if(str.split("/")[0].charAt(0) == str.split("/")[1].charAt(str.split("/")[1].length() - 1)) {
				cancellableFractions.add(str);
			}
			//check second and third digits
			if(str.split("/")[0].charAt((str.split("/")[0].length() - 1)) == str.split("/")[1].charAt(0)) {
				cancellableFractions.add(str);
			}
		}
		
		/*
		 * Cancels out similar digits 
		 */
		double finalNum = 1.0D;
		double finalDenom = 1.0D;
		for(String str : cancellableFractions) {
			//check first & last digits
			if(str.split("/")[0].charAt(0) == str.split("/")[1].charAt(str.split("/")[1].length() - 1)) {
				
				double initNum = Double.parseDouble(str.split("/")[0]);
				double initDenom = Double.parseDouble(str.split("/")[1]);
				
				double num = Double.parseDouble(String.valueOf(str.split("/")[0].charAt(1)));
				double denom = Double.parseDouble(String.valueOf(str.split("/")[1].charAt(0)));
				
				if(num/denom == initNum/initDenom) {
					finalDenom *= denom;
					finalNum *= num;
					//System.out.println(str + ": " + num + "/" + denom);
				}
				
			}
			//check second and third digits
			if(str.split("/")[0].charAt((str.split("/")[0].length() - 1)) == str.split("/")[1].charAt(0)) {
				
				double initNum = Double.parseDouble(str.split("/")[0]);
				double initDenom = Double.parseDouble(str.split("/")[1]);
				
				double num = Double.parseDouble(String.valueOf(str.split("/")[0].charAt(0)));
				double denom = Double.parseDouble(String.valueOf(str.split("/")[1].charAt(1)));

				if(num/denom == initNum/initDenom) {
					finalDenom *= denom;
					finalNum *= num;
					//System.out.println(str + ": " + num + "/" + denom);
				}
			}
		}

		System.out.println(finalNum/finalDenom); //Returns 0.01 which is the same as 1/100. (therefore denominator = 100)
		uptime();
	}
}
