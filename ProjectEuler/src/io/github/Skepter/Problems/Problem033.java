package io.github.Skepter.Problems;

import java.util.ArrayList;
import java.util.List;

import io.github.Skepter.Utils.RT;

public class Problem033 extends RT {

	/* https://projecteuler.net/problem=33 */
	public static void main(final String[] args) {
		List<String> fractions = new ArrayList<String>();
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				//iterate the digits for the first number and check if they exist in the second number.
				//if so, print out numerator/denominator
				for(char c : String.valueOf(i).toCharArray()) {
					if(String.valueOf(j).contains(String.valueOf(c))) {
						fractions.add(i + "/" + j);
						//System.out.println(i + "/" + j);
					}
				}
			}	
		}
		
		List<String> cancellableFractions = new ArrayList<String>();
		for(String str : fractions) {
			double num = Double.parseDouble(str.split("/")[0]);
			double denom = Double.parseDouble(str.split("/")[1]);
			//check first & last digits
			if(str.split("/")[0].charAt(0) == str.split("/")[1].charAt(str.split("/")[1].length() - 1)) {
				cancellableFractions.add(str);
				//System.out.println(str);
			}
			//check second and third digits
			if(str.split("/")[0].charAt((str.split("/")[0].length() - 1)) == str.split("/")[1].charAt(0)) {
				cancellableFractions.add(str);
				//System.out.println(str);
			}
			
			//Perform cancel
			//Check numerical values
		}
		uptime();
	}
}
