package io.github.skepter.problems;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem011 extends RT {

	/* https://projecteuler.net/problem=11 
	 * 82ms*/
	public static void main(final String[] args) {
		int[][] numbers = new int[20][20];
		
		//Populate array with values
		int lineNumber = 0;
		for(String string : Utils.readFromFile("problem11.txt")) {
			
			String[] numInLine = string.split(" ");
			int numNumber = 0;
			for(String num : numInLine) {
				numbers[lineNumber][numNumber] = Integer.parseInt(num);
				numNumber++;
			}
			lineNumber++;
		}
		
		int maxValue = 0;
				
		//Find all greatest products (right or left)
		for(int row = 0; row < 17; row++) {
			for(int i = 0; i < 17; i++) {
				int value = numbers[row][i] * numbers[row][i+1] * numbers[row][i+2] * numbers[row][i+3]; 
				if(value >= maxValue) {
					maxValue = value;
				}
			}
		}
				
		//Find all greatest products (up or down)
		for (int row = 0; row < 17; row++) {
			for (int i = 0; i < 17; i++) {
				int value = numbers[i][row] * numbers[i + 1][row] * numbers[i + 2][row] * numbers[i + 3][row];
				if (value >= maxValue) {
					maxValue = value;
				}
			}
		}
				
		//Find all greatest products (diagonal to the right)
		for (int row = 0; row < 17; row++) {
			for (int i = 0; i < 17; i++) {
				int value = numbers[row][i] * numbers[row+1][i+1] * numbers[row+2][i+2] * numbers[row+3][i+3];
				if (value >= maxValue) {
					maxValue = value;
				}
			}
		}
				
		//Find all greatest products (diagonal to the left)
		for (int row = 0; row < 17; row++) {
			for (int i = 19; i > 2; i--) {
				int value = numbers[row][i] * numbers[row+1][i-1] * numbers[row+2][i-2] * numbers[row+3][i-3];
				if (value >= maxValue) {
					maxValue = value;
				}
			}
		}
		System.out.println(maxValue);
				
		uptime();
	}
}
