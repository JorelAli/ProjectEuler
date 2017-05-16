package io.github.skepter.problems;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem059 extends RT {

	/**/
	public static void main(final String[] args) throws FileNotFoundException {
		String[] arr = Utils.readFromFile("p059_cipher.txt").get(0).split(",");
		String[] arrOriginal = Arrays.copyOf(arr, arr.length);
		Map<String, Integer> occurrence = new HashMap<String, Integer>();
		for(String str : arr) {
			occurrence.put(str, occurrence.getOrDefault(str, 0) + 1);
		}
		//Utils.printMap(occurrence);
		
		System.out.println(Character.valueOf((char) 79)); // O need to convert to 101.
		
		//79 XOR a = 101
		for(int i = 0; i < 100; i++) {
			if((79 ^ i) == 101) {
				System.out.println(i); //42
				break;
			}
		}
		
		for(int c = 0; c <= 10000; c++) {
			for (int i = 0; i < arr.length; i++) {
				String str = arr[i];
				if((Integer.parseInt(str) ^ c) < 32) {
					continue;
				}
				arr[i] = String.valueOf((char) (Integer.parseInt(str) ^ c));
			}
			
			System.out.println(Arrays.toString(arr));
			arr = Arrays.copyOf(arrOriginal, arrOriginal.length);
		}
		
		
		
		
		uptime();
	}
}
