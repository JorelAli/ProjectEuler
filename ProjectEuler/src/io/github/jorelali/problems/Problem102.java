package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem102 extends RT {

	static class Coordinates {
		
		int x;
		int y;
		
		Coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
//		public int dotProduct(Coordinates c) {
//			return (x * c.x) + (y * c.y); 
//		}
	}
	
	/* https://projecteuler.net/problem=102
	 * https://www.desmos.com/calculator/3zs5msyta2
	 * 
	 * Uses Barycentric coordinate method
	 * Program took 118 milliseconds */
	public static void main(final String[] args) {
		
		Coordinates a = new Coordinates(-340, 495);
		Coordinates b = new Coordinates(-153, -910);
		Coordinates c = new Coordinates(-835, -947);
		//assert containsOrigin(a, b, c);
		
//		//two negative, one positive
//		System.out.println("a . b " + a.dotProduct(b));
//		System.out.println("b . c " + b.dotProduct(c));
//		System.out.println("a . c " + a.dotProduct(c));
//		
		a = new Coordinates(-175, 41);
		b = new Coordinates(-421, -714);
		c = new Coordinates(574, -645);
//		
		//assert !containsOrigin(a, b, c);
//		
//		//all positive
//		System.out.println("a . b " + a.dotProduct(b));
//		System.out.println("b . c " + b.dotProduct(c));
//		System.out.println("a . c " + a.dotProduct(c));
//		
//		a = new Coordinates(-547,712);
//		b = new Coordinates(-352,579);
//		c = new Coordinates(951,-786);
//		
//		//expect value, except fails -> implies dot product fails
//		System.out.println("a . b " + a.dotProduct(b));
//		System.out.println("b . c " + b.dotProduct(c));
//		System.out.println("a . c " + a.dotProduct(c));
		
		//https://en.wikipedia.org/wiki/Barycentric_coordinate_system#Conversion_between_barycentric_and_Cartesian_coordinates
		
		/*
		 * A(x1 - x3) + B(x2 - x3) + x3 - 0 = 0
		 * A(y1 - y3) + B(y2 - y3) + y3 - 0 = 0
		 */
		
		
		int count = 0;
		for(String str : Utils.readFromFile("p102_triangles.txt")) {
			String[] coords = str.split(",");
			a = new Coordinates(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
			b = new Coordinates(Integer.parseInt(coords[2]), Integer.parseInt(coords[3]));
			c = new Coordinates(Integer.parseInt(coords[4]), Integer.parseInt(coords[5]));
			if(containsOrigin(a, b, c)) {
				count++;
				System.out.println(a.toString() + ", " + b.toString() + ", " + c.toString());
			}
		}
		System.out.println(count);
		
		
		uptime();
	}
	
	public static boolean containsOrigin(Coordinates a, Coordinates b, Coordinates c) {
		//System.out.println(solveA(a, b, c) + solveB(a, b, c) + solveC(a, b, c));
		if(solveA(a, b, c) > 1 || solveB(a, b, c) > 1 || solveC(a, b, c) > 1) {
			return false;
		}
		if(solveA(a, b, c) < 0 || solveB(a, b, c) < 0 || solveC(a, b, c) < 0) {
			return false;
		}
		return true;
		
	}
	
	public static double solveA(Coordinates c1, Coordinates c2, Coordinates c3) {
		//x == y == 0
		double top = (c2.y - c3.y) * (0 - c3.x) + (c3.x - c2.x) * (0 - c3.y);
		double bottom = (c2.y - c3.y) * (c1.x - c3.x) + (c3.x - c2.x) * (c1.y - c3.y);
		return top / bottom;
	}
	
	public static double solveB(Coordinates c1, Coordinates c2, Coordinates c3) {
		//x == y == 0
		double top = (c3.y - c1.y) * (0 - c3.x) + (c1.x - c3.x) * (0 - c3.y);
		double bottom = (c2.y - c3.y) * (c1.x - c3.x) + (c3.x - c2.x) * (c1.y - c3.y);
		return top / bottom;
	}
	
	public static double solveC(Coordinates c1, Coordinates c2, Coordinates c3) {
		return 1 - solveA(c1, c2, c3) - solveB(c1, c2, c3);
	}
}
