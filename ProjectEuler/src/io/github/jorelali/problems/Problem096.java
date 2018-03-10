package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		System.out.println(isValid(sudokuPuzzles.get(0)));
		System.out.println(isComplete(sudokuPuzzles.get(0)));
		
		//Solving each puzzle
		//Starting with first puzzle for testing
		int[][] puzzle = sudokuPuzzles.get(0);
		
		uptime();
	}
	
	/**
	 * Checks if a sudoku puzzle is valid (i.e. it doesn't have
	 * numbers which are in the same row/box/column)
	 * @param puzzle
	 * @return
	 */
	public static boolean isValid(int[][] puzzle) {
		//Checking rows
		for(int i = 0; i < 9; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = 0; j < 9; j++) {
				list.add(puzzle[i][j]);
			}
			if(containsDuplicates(list))
				return false;
		}
		
		//Checking columns?
		for(int i = 0; i < 9; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = 0; j < 9; j++) {
				list.add(puzzle[j][i]);
			}
			if(containsDuplicates(list))
				return false;
		}
		
		//Checking 3x3 boxes
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				
				/**
				 * Returns a 3x3 array of the values of the minigrid grid which contains the row and column
				 * Found from my SudokuSolver project on GitHub
				 */
				
				int row = i;
				int col = j;
				List<Integer> list = new ArrayList<>();
				row = (row / 3) * 3;
				col = (col / 3) * 3;

				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						list.add(puzzle[row + r][col + c]);
					}
				}
				
				if(containsDuplicates(list))
					return false;
				
			}
		}
		
		return true;
	}
	
	/**
	 * Checks if there are duplicates in a list
	 * @param list
	 * @return
	 */
	private static boolean containsDuplicates(List<Integer> list) {
		list.removeAll(Collections.singleton(0));
		Set<Integer> set = new HashSet<>(list);
		return set.size() < list.size();
	}
	
	/**
	 * Checks if a sudoku puzzle is complete
	 * @param puzzle
	 * @return
	 */
	static boolean isComplete(int[][] puzzle) {
		Set<Integer> numbers = new HashSet<>();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				numbers.add(puzzle[i][j]);
			}
		}
		return (isValid(puzzle) && !numbers.contains(0));
	}
}
