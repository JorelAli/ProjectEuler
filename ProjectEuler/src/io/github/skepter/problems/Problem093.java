package io.github.skepter.problems;

import java.util.Set;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import io.github.skepter.foreignutils.Permutations;
import io.github.skepter.utils.RT;

public class Problem093 extends RT {

	/* https://projecteuler.net/problem=93 */
	public static void main(final String[] args) throws ScriptException {
		
		//Calculating number of possible answers (126)
		//Storing number possibilities in an array for later use
		int[][] possibleNumbers = new int[126][4];
		int count = 0;
		for(int a = 1; a <= 9; a++) {
			for(int b = 1; b <= 9; b++) {
				for(int c = 1; c <= 9; c++) {
					for(int d = 1; d <= 9; d++) {
						if(a < b && b < c && c < d) {
							//System.out.println(a + " " + b + " " + c + " " + d);
							possibleNumbers[count][0] = a;
							possibleNumbers[count][1] = b;
							possibleNumbers[count][2] = c;
							possibleNumbers[count][3] = d;
							count++;
						}
					}
				}
			}
		}
		System.out.println(count); //126 different possible answers
		//System.out.println(Arrays.deepToString(possibleNumbers));
		String[] operations = {"+", "-", "*", "/"};
		
		for(int index = 0; index < 126; index++) {

			for(int op = 0; op < 4; op++) {
				String number = "";
				for(int num : possibleNumbers[index]) {
					number = number + num;
				}
				System.out.print(operations[op]);
				Set<String> permutations = new Permutations(String.valueOf(number)).getPermutations();
				permutations.forEach(System.out::println);
				
				/*
				 * Insert something here like 4P3 to choose 3 of the 4 operations or something
				 */
				
			}

		}
		
		
		/*
		 * Given that we know there are only ever going to be 3 different operations at a time
		 * (see below), how many ways of arranging brackets around it?
		 * 
		 * By permutations:
		 * How many ways of arranging brackets?
		 * 
		 * (((a # b) # c) # d)
		 * (a # b # c) # d
		 * (a # b) # (c # d)
		 * 
		 */
		
		/* Using ScriptEngine to evaluate arithmetic expressions */
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");

		/*
		 * Main plan:
		 * Produce each permutation of numbers and their respective operations.
		 * Produce each set of brackets for each thing.
		 * Pop it into the engine
		 * profit?
		 */
		
		uptime();
	}
}
