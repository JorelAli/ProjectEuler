package io.github.skepter.problems;

import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;

public class Problem206 extends RT {

	/*
	 * https://projecteuler.net/problem=206 Find the unique positive integer
	 * whose square has the form 1_2_3_4_5_6_7_8_9_0, where each “_” is a single
	 * digit.
	 * 
	 * Program took 34 seconds, 424 milliseconds
	 */
	public static void main(final String[] args) {
		
		LoadingBar bar = new LoadingBar("Problem 206", 378925613);
		int a = 0;
		for(long i = 1010101010; i <= 1389026623; i++) {
			if(isValid(i * i)) {
				System.out.println(i);
				uptime();
				return;
			}
			a++;
			bar.updateBar(a);
		}
		
//		for (int a = 0; a <= 9; a++) {
//			for (int b = 0; b <= 9; b++) {
//				for (int c = 0; c <= 9; c++) {
//					for (int d = 0; d <= 9; d++) {
//						for (int e = 0; e <= 9; e++) {
//							for (int f = 0; f <= 9; f++) {
//								for (int g = 0; g <= 9; g++) {
//									for (int h = 0; h <= 9; h++) {
//										for (int i = 0; i <= 9; i++) {
//											double number = Double.parseDouble("1" + a + "2" + b + "3" + c + "4" + d
//													+ "5" + e + "6" + f + "7" + g + "8" + h + "9" + i + "0");
//											if (isInteger(Math.sqrt(number))) {
//												System.out.println(BigDecimal.valueOf(Math.sqrt(number)).toString());
//												uptime();
//												return;
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}

	}

	private static boolean isValid(long l) {
		char[] arr = String.valueOf(l).toCharArray();
		if(arr[0] == '1' && arr[2] == '2' && arr[4] == '3' && arr[6] == '4' && arr[8] == '5' && arr[10] == '6'
				&& arr[12] == '7' && arr[14] == '8' && arr[16] == '9' && arr[18] == '0') {
			return true;
		} else {
			return false;
		}
	}
}
