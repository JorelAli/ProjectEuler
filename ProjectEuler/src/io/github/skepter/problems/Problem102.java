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
		
		uptime();
	}
}
