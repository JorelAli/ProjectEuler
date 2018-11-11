package io.github.jorelali.problems;

import java.util.List;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem081 extends RT {

	/* https://projecteuler.net/problem=81 */
	public static void main(final String[] args) {
		List<String> stringMatrix = Utils.readFromFile("p081_matrix.txt");
		//List<String> stringMatrix = Utils.readFromFile("p081_matrix_5x5.txt");
		
		int size = 80;
		
		int[][] matrix = new int[size][size];
		
		for (int i = 0; i < stringMatrix.size(); i++) {
			String str = stringMatrix.get(i);
			String[] numbers = str.split(",");
			for(int j = 0; j < numbers.length; j++) {
				matrix[i][j] = Integer.parseInt(numbers[j]);
			}
		}
		
		int[][] newMatrix = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(i == 0 && j == 0) {
					newMatrix[0][0] = matrix[0][0];
				} else if(i == 0 && j > 0) {
					newMatrix[i][j] = matrix[i][j] + newMatrix[i][j - 1];
				} else if(j == 0 && i > 0) {
					newMatrix[i][j] = matrix[i][j] + newMatrix[i - 1][j];
				} else {
					newMatrix[i][j] = matrix[i][j] + Math.min(newMatrix[i - 1][j], newMatrix[i][j - 1]);
				}
				 
			}
		}
		
		System.out.println(newMatrix[size - 1][size - 1]);
				
		uptime();
	}
}
