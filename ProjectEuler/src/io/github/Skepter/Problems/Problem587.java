package io.github.Skepter.Problems;

import io.github.Skepter.Utils.RT;

public class Problem587 extends RT {

	/* https://projecteuler.net/problem=587
	 * 
	 * Links used:
	 * http://www.scienceforums.net/topic/84453-finding-the-area-under-a-circle-using-integrals/?p=816742
	 * https://www.mathsisfun.com/geometry/circle-sector-segment.html
	 * 
	 * Custom desmos graph by me :)
	 * https://www.desmos.com/calculator/sv4ehlogjf
	 * 
	 * 117ms */
	public static void main(final String[] args) {
//		System.out.println(solveX(2));
//		System.out.println(solveY(2));
//		System.out.println(segmentArea(1));
		for(int n = 0; n < Integer.MAX_VALUE; n++) {
			double lSection = concaveTriangleArea(1) * 2;
			double nArea = concaveTriangleArea(n);
			double percent = 100 * nArea / lSection;
			if(percent < 0.1) {
				System.out.println(n);
				break;
			}
			System.out.println(100 * nArea / lSection);
		}
		
		//System.out.println(concaveTriangleArea(2));
		uptime();
	}
	
	
	private static double concaveTriangleArea(int n) {
		/* Imagine the area of the triangle split up into two
		 * sections down the middle between the intersection
		 * of the line and the circle:
		 * 
		 * The bit on the left which is a perfect triangle
		 * The bit on the right which is a curvy triangle
		 * 
		 * 
		 */
		
		double leftTriangleArea = 0.5 * solveY(n) * solveX(n);
		double rightTriangleArea = (0.5 * solveY(n) * (1 - solveX(n))) - segmentArea(n);
		
		return leftTriangleArea + rightTriangleArea;
	}
	
	/*
	 * Finds the area of the minor segment of the circle
	 */
	private static double segmentArea(int n) {
		/*
		 * To find the area of the segment, we need to know the angle between 
		 * the two points (x, y) and (1, 0):
		 * 
		 * Using the cosine rule and knowing that
		 * a^2 = b^2 + c^2 - 2bcCos(A)
		 * And knowing that b and c = 1:
		 * the angle is arccos((a^2-2)/2), where
		 * a is the distance between (x,y) and (1,0)
		 */
		double x = solveX(n);
		double y = solveY(n);
		double a = Math.sqrt((x - 1D) * (x - 1D) + (y * y));
		double angle = Math.PI - Math.acos(((a * a) - 2D) / 2D);
		
		/*
		 * Now we can find the area of the minor segment:
		 */
		double segment = ((angle - Math.sin(angle)) / 2D); //radius is 1
		
		return segment;
	}

	//Finds the y-axis from the x-value
	private static double solveY(int n) {
		return (1D/n) * solveX(n);
	}
	 
	/*
	 * Finds the x-axis of the intersection
	 */
	private static double solveX(int n) {
		/*
		 * Basically, the two equations are (y-1)^2 + (x-1)^2=1
		 * and y = (1/n)x
		 * 
		 *  https://www.desmos.com/calculator/fjoa97kxdv
		 *  Need to solve to get the value of x using the quadratic formula
		 *  x < 1
		 *  
		 *  Therefore, rearranging, we get:
		 *  x^2(1/n^2 + 1) + x(-2-2/n) + 1 = 0
		 */
		double a = (1D/(n*n)) + 1D;
		double b = -2D -(2D/n);
		double c = 1;
		
		double x1 = (-b + Math.sqrt((b*b) - 4*a*c))/(2*a);
		double x2 = (-b - Math.sqrt((b*b) - 4*a*c))/(2*a);

		if(x1 < 1) {
			return x1;
		} else if(x2 < 1) {
			return x2;
		}
		//This should never be returned - implies error in calculation
		return -1;
		
		
	}
}
