package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.List;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem096 extends RT {

	/* Solve a tonne of sudoku problems */
	public static void main(final String[] args) {
		
		//Reading file into int[][]
		List<int[][]> sudokuPuzzles = new ArrayList<>();
		List<String> fileContents = Utils.readFromFile("p096_sudoku.txt");
		
		for(int i = 0; i < fileContents.size(); i += 10) {
			List<String> subList =  fileContents.subList(i, i + 10);

			int[][] arr = new int[9][9];
			
			//Loop through strings in sublist (so, each row), ignore j = 0 (which is "Grid ##")
			for(int j = 1; j < subList.size(); j++) {
				//Loop through characters in each row
				for(int c = 0; c < subList.get(j).length(); c++) {
					char cVal = subList.get(j).charAt(c);
					//"Correct" index of j for arr
					arr[j - 1][c] = Integer.parseInt(String.valueOf(cVal));
				}
			}
			sudokuPuzzles.add(arr);
		}
		
		
		
		
		uptime();
	}
	
	/**
	 * Checks if a sudoku puzzle is valid (i.e. it doesn't have
	 * numbers which are in the same row/box/column)
	 * @param puzzle
	 * @return
	 */
	public static boolean isValid(int[][] puzzle) {
		return false;
	}
}
