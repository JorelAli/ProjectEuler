package io.github.skepter.problems;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import io.github.skepter.utils.RT;

public class Problem093 extends RT {

	/* https://projecteuler.net/problem=93 */
	public static void main(final String[] args) throws ScriptException {
		
		//Calculating number of possible answers
		int count = 0;
		for(int a = 1; a <= 9; a++) {
			for(int b = 1; b <= 9; b++) {
				for(int c = 1; c <= 9; c++) {
					for(int d = 1; d <= 9; d++) {
						if(a < b && b < c && c < d) {
							System.out.println(a + " " + b + " " + c + " " + d);
							count++;
						}
					}
				}
			}
		}
		System.out.println(count); //126 different possible answers
		
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
