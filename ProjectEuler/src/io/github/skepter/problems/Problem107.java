package io.github.skepter.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem107 extends RT {

	/* https://projecteuler.net/problem=107 
	 * Prim's Algorithm. */
	public static void main(final String[] args) {
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
		
		int minimumRoute = 0;
		
		for(int row = 0; row < 40; row++) {
			int min = 1000;
			int column = 0;
			List<Integer> columnsToIgnore = new ArrayList<Integer>();
			for(int i = 0; i < 40; i++) {
				if(!columnsToIgnore.contains(i)) {
					if(matrix[i][row] < min) {
						min = matrix[i][row];
						column = i;
					}
				}
			}
			columnsToIgnore.add(column);
			columnsToIgnore.add(row);
			
			minimumRoute += min;
		}
		
		System.out.println(minimumRoute);
		
		int totalWeight = 0;
		
		for(int row = 0; row < 40; row++) {
			for(int col = 0; col < 40; col++) {
				if(matrix[col][row] != 1000)
					totalWeight += matrix[col][row]; 
			}
		}
		totalWeight = totalWeight / 2;
		System.out.println(totalWeight);
		System.out.println(totalWeight - minimumRoute);
		
		
		
//		System.out.println(min);
//		System.out.println(column);
		
		System.out.println(Arrays.deepToString(matrix));
		uptime();
	}
}
