package io.github.jorelali.problems;

import java.util.ArrayList;
import java.util.List;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem081 extends RT {

	/* https://projecteuler.net/problem=81 */
	public static void main(final String[] args) {
		List<String> matrix = Utils.readFromFile("p081_matrix.txt");
		//TODO: Do the test with the 5x5 grid,
		// Then using the same code, apply it for the 80x80 grid
		
		//Strategies: Use the dynamic programming from problem 18 and 67
		
		
		uptime();
		
		
		
	}
	
	public static List<Integer[]> transformToArray(List<String> strings) {
		
		//Transform the matrix so it lies on its diagonal.
		//For example, with the 5x5 matrix, make it so the top element is 131,
		//then a list of [201, 673]
		//then [630, 96, 234]
		//etc.
		
		List<Integer[]> list = new ArrayList<Integer[]>();
		for(String str : strings) {
			List<Integer> intArr = new ArrayList<Integer>();
			for(String number : str.split(",")) {
				intArr.add(Integer.parseInt(number));
			}
			list.add(intArr.toArray(new Integer[intArr.size()]));
		}
		
		//List complete. Now we just have to transform it by "rotating" it
		
		//THEN Convert to a List<Integer[]>
		
		
		
		return null;
	}
}
