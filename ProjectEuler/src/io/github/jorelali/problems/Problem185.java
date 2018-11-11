package io.github.jorelali.problems;

import java.util.Arrays;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem185 extends RT {

	/* https://projecteuler.net/problem=185 
	 * 
	 * See https://en.wikipedia.org/wiki/Mastermind_(board_game)#Genetic_algorithm
	 * 
	 * 
	 * The game Number Mind is a variant of the well known game Master Mind.
		
		Instead of coloured pegs, you have to guess a secret sequence of digits. 
		After each guess you're only told in how many places you've guessed the correct digit. 
		So, if the sequence was 1234 and you guessed 2036, you'd be told that you have one correct digit; 
		however, you would NOT be told that you also have another digit in the wrong place.
		
		For instance, given the following guesses for a 5-digit secret sequence,
		
		90342 ;2 correct
		70794 ;0 correct
		39458 ;2 correct
		34109 ;1 correct
		51545 ;2 correct
		12531 ;1 correct
		
		The correct sequence 39542 is unique.
		
		Based on the following guesses,
		
		5616185650518293 ;2 correct
		3847439647293047 ;1 correct
		5855462940810587 ;3 correct
		9742855507068353 ;3 correct
		4296849643607543 ;3 correct
		3174248439465858 ;1 correct
		4513559094146117 ;2 correct
		7890971548908067 ;3 correct
		8157356344118483 ;1 correct
		2615250744386899 ;2 correct
		8690095851526254 ;3 correct
		6375711915077050 ;1 correct
		6913859173121360 ;1 correct
		6442889055042768 ;2 correct
		2321386104303845 ;0 correct
		2326509471271448 ;2 correct
		5251583379644322 ;2 correct
		1748270476758276 ;3 correct
		4895722652190306 ;1 correct
		3041631117224635 ;3 correct
		1841236454324589 ;3 correct
		2659862637316867 ;2 correct
		
		Find the unique 16-digit secret sequence.*/
	public static void main(final String[] args) {
		String[] arr = new String[] { "5616185650518293", "3847439647293047", "5855462940810587", "9742855507068353",
				"4296849643607543", "3174248439465858", "4513559094146117", "7890971548908067", "8157356344118483",
				"2615250744386899", "8690095851526254", "6375711915077050", "6913859173121360", "6442889055042768",
				"2321386104303845", "2326509471271448", "5251583379644322", "1748270476758276", "4895722652190306",
				"3041631117224635", "1841236454324589", "2659862637316867" };
		
		for(int i = 0; i < 22; i++) {
			if(i == 14)
				continue;
			char[] newArr = arr[i].toCharArray();
			for(int c = 0; c <= 15; c++) {
				if(newArr[c] == arr[14].toCharArray()[c]) {
					newArr[c] = '-';
				}
			}
			arr[i] = String.copyValueOf(newArr);
		}
		System.out.println(Arrays.toString(arr));
		uptime();
	}
	
	public static void genetic() {
		int i = 1;
		//guess
		
		//get some response? X1 and Y1
		
		while(x[i] != P) {
			i++;
			E[i] = empty;
			h = 1;
			//init population
			
		}
	}
}
