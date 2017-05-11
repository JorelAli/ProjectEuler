package io.github.skepter.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem107 extends RT {

	//Second attempt
	
	/* https://projecteuler.net/problem=107 
	 * Prim's Algorithm. */
	public static void main(final String[] args) {
		
		//Turns the matrix from the file into an int[][]
		int[][] matrix = new int[40][40];
		List<String> list = Utils.readFromFile("p107_network.txt");
		for(int i = 0; i < 40; i++) {
			for(int j = 0; j < 40; j++) {
				if(list.get(i).split(",")[j].equals("-")) {
					matrix[i][j] = 1000;
				} else {
					matrix[i][j] = Integer.parseInt(list.get(i).split(",")[j]);
				}
			}
		}
		
		//Gets the total weight of the network
		int totalWeight = 0;
		for(int row = 0; row < 40; row++) {
			for(int col = 0; col < 40; col++) {
				if(matrix[col][row] != 1000)
					totalWeight += matrix[col][row]; 
			}
		}
		totalWeight = totalWeight / 2;
		
		//start at row 0. Go until you find the min value.
		//Exclude row 0 and the column with the min value.
		//Go to the ROW which is the COLUMN of the min value

		Set<Integer> ignoredColumns = new HashSet<Integer>();
		
		//There may be a row which has a repeated number :/
		
		int count = 0;
		int row = 0;
		int minWeight = 0;
		while (count < 40) {
			int minValue = 1000;
			int colWithMinValue = -1;
			
			//Loop through each column from the current row to find the minimum value
			for(int col = 0; col < 40; col++) {
				if(matrix[row][col] < minValue) {
					minValue = matrix[row][col];
					colWithMinValue = col;
				}
				matrix[row][col] = 1000;
			}
			
			//ignoredColumns.add(colWithMinValue);
			//ignoredColumns.add(row);
			
//			for(int i = 0; i < 40; i++) {
//				System.out.println(Arrays.toString(matrix[i]));
//			}

			if(colWithMinValue == -1) {
				colWithMinValue = 22;
//				Utils.printListSingleLine(ignoredColumns);
//				count++;
//				System.out.println(minWeight);
//				System.out.println(totalWeight - minWeight);
//				return;
			}
			
			for(int i = 0; i < 40; i++) {
				System.out.println("count = " + count);
				matrix[i][colWithMinValue] = 1000;
			}
			for(int i = 0; i < 40; i++) {
				matrix[i][row] = 1000;
			}
			count++;
			row = colWithMinValue;
			minWeight += minValue;
		}
		System.out.println(minWeight);
		System.out.println(totalWeight - minWeight);

		
		uptime();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//First attempt
	
//	/* https://projecteuler.net/problem=107 
//	 * Prim's Algorithm. */
//	public static void main(final String[] args) {
//		int[][] matrix = new int[40][40];
//		List<String> list = Utils.readFromFile("p107_network.txt");
//		for(int i = 0; i < 40; i++) {
//			for(int j = 0; j < 40; j++) {
//				if(list.get(i).split(",")[j].equals("-")) {
//					matrix[i][j] = 1000;
//				} else {
//					matrix[i][j] = Integer.parseInt(list.get(i).split(",")[j]);
//				}
//			}
//		}
//		
//		int minimumRoute = 0;
//		List<Integer> l = new ArrayList<Integer>();
//		
//		int[][] reducedMatrix = new int[40][40];
//		List<Integer> columnsToIgnore = new ArrayList<Integer>();
//		int count = 0;
//		int row1 = 0;
//		//shouldn't use row, the row is found based on column
//		while (count < 39) {
//			
//			int min = 1000;
//			int column = 0;
//			for(int i = 0; i < 40; i++) {
//				if(matrix[i][row1] == 1000) {
//					continue;
//				}
//				if(!columnsToIgnore.contains(i)) {
//					if(matrix[i][row1] < min) {
//						min = matrix[i][row1];
//						column = i;
//					}
//				}
//			}
//			columnsToIgnore.add(column);
//			//columnsToIgnore.add(row);
//			reducedMatrix[row1][column] = min;
//			row1 = column;
//			count++;
//			minimumRoute += min;
//			l.addAll(columnsToIgnore);
//		}
////		for(int row = 0; row < 40; row++) {
////			int min = 1000;
////			int column = 0;
////			for(int i = 0; i < 40; i++) {
////				if(matrix[i][row] == 1000) {
////					continue;
////				}
////				if(!columnsToIgnore.contains(i)) {
////					if(matrix[i][row] < min) {
////						min = matrix[i][row];
////						column = i;
////					}
////				}
////			}
////			columnsToIgnore.add(column);
////			//columnsToIgnore.add(row);
////			reducedMatrix[row][column] = min;
////			minimumRoute += min;
////			l.addAll(columnsToIgnore);
////		}
//		Collections.sort(l);
//		Utils.printListSingleLine(l);
//		System.out.println(minimumRoute);
//		
//		int totalWeight = 0;
//		
//		for(int row = 0; row < 40; row++) {
//			for(int col = 0; col < 40; col++) {
//				if(matrix[col][row] != 1000)
//					totalWeight += matrix[col][row]; 
//			}
//		}
//		totalWeight = totalWeight / 2;
//		System.out.println(totalWeight);
//		System.out.println(totalWeight - minimumRoute);
//			
////		System.out.println(min);
////		System.out.println(column);
//		
//		System.out.println(Arrays.deepToString(reducedMatrix));
//		uptime();
//	}
}
