package io.github.skepter.problems;

import io.github.skepter.utils.RT;

public class Problem102 extends RT {

	static class Coordinates {
		int x;
		int y;
		Coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int dotProduct(Coordinates c) {
			return (x * c.x) + (y * c.y); 
		}
	}
	
	/**/
	public static void main(final String[] args) {
//		Coordinates a = new Coordinates(-340, 495);
//		Coordinates b = new Coordinates(-153, -910);
//		Coordinates c = new Coordinates(-835, -947);
//		
//		//two negative, one positive
//		System.out.println("a . b " + a.dotProduct(b));
//		System.out.println("b . c " + b.dotProduct(c));
//		System.out.println("a . c " + a.dotProduct(c));
//		
//		a = new Coordinates(-175, 41);
//		b = new Coordinates(-421, -714);
//		c = new Coordinates(-574, -645);
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
		
		
		uptime();
	}
	
	public double solveA(Coordinates c1, Coordinates c2, Coordinates c3) {
		//x == y == 0
		double top = (c2.y - c3.y) * (0 - c3.x) + (c3.x - c2.x) * (0 - c3.y);
		double bottom = (c2.y - c3.y) * (c1.x - c3.x) + (c3.x - c2.x) * (c1.y - c3.y);
		return top / bottom;
	}
	
	public double solveB(Coordinates c1, Coordinates c2, Coordinates c3) {
		//x == y == 0
		double top = (c3.y - c1.y) * (0 - c3.x) + (c1.x - c3.x) * (0 - c3.y);
		double bottom = (c2.y - c3.y) * (c1.x - c3.x) + (c3.x - c2.x) * (c1.y - c3.y);
		return top / bottom;
	}
}
