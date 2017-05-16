package io.github.skepter.problems;

import io.github.skepter.utils.RT;

public class Problem031 extends RT {

	/* https://projecteuler.net/problem=31
	 * 
	 * In England the currency is made up of pound, £, and pence, p, and there
	 * are eight coins in general circulation:
	 * 
	 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p). It is possible to
	 * make £2 in the following way:
	 * 
	 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p How many different ways can £2
	 * be made using any number of coins?
	 * 
	 * Program took 01 seconds, 997 milliseconds
	 */
	public static void main(final String[] args) {
		int count = 0;
		for (int a = 0; a <= 200; a += 200) {
			for (int b = 0; b <= 200; b += 100) {
				for (int c = 0; c <= 200; c += 50) {
					for (int d = 0; d <= 200; d += 20) {
						for (int e = 0; e <= 200; e += 10) {
							for (int f = 0; f <= 200; f += 5) {
								for (int g = 0; g <= 200; g += 2) {
									for (int h = 0; h <= 200; h += 1) {
										if(a + b + c + d + e + f + g + h == 200) {
//											printNumbers(a, b, c, d, e, f, g, h);
											count++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
		uptime();
	}
	
	public static void printNumbers(int a, int b, int c, int d, int e, int f, int g, int h) {
		a = a / 200;
		b = b / 100;
		c = c / 50;
		d = d / 20;
		e = e / 10;
		f = f / 5;
		g = g / 2;
		System.out.println("1p: " + h + ", 2p:" + g + ", 5p: " + f + ", 10p:" + e + ", 20p: " + d + ", 50p:" + c + ", £1: " + b + ", £2: " + a);
	}
}
