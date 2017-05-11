package io.github.skepter.problems;

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
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = Integer.parseInt(list.get(i).split(",")[j]);
				}
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
		uptime();
	}
}
