package io.github.skepter.problems;

import io.github.skepter.utils.LoadingBar;
import io.github.skepter.utils.RT;
import io.github.skepter.utils.Utils;

public class Problem504 extends RT {

	/*
	 * Let ABCD be a quadrilateral whose vertices are lattice points lying on
	 * the coordinate axes as follows:
	 * 
	 * A(a, 0), B(0, b), C(−c, 0), D(0, −d), where 1 ≤ a, b, c, d ≤ m and a, b,
	 * c, d, m are integers.
	 * 
	 * It can be shown that for m = 4 there are exactly 256 valid ways to
	 * construct ABCD. Of these 256 quadrilaterals, 42 of them strictly contain
	 * a square number of lattice points.
	 * 
	 * How many quadrilaterals ABCD strictly contain a square number of lattice
	 * points for m = 100?
	 * 
	 * Okay, status update: After some maths, this is going to take ages (hours)
	 */
	public static void main(final String[] args) {
		/*
		 * Suppose m = n.
		 * The number of quarilaterals = n^4
		 */
		
		Utils.assert_(new Quad(1, 1, 1, 1).contains(0, 0));
		
		
		int m = 100;
		LoadingBar bar = new LoadingBar("Problem 504", m);
		int square = 0;
		for(int a = 1; a <= m; a++) {
			bar.updateBar(a);
			for(int b = 1; b <= m; b++) {
				for(int c = 1; c <= m; c++) {
					for(int d = 1; d <= m; d++) {
						Quad quad = new Quad(a, b, c, d);
						//List of points from (-4, -4) to (4, 4)
						//(-m, -m) to (m, m)
						int count = 0;
						for(int x = -m; x <= m; x++) {
							for(int y = -m; y <= m; y++) {
								if(quad.contains(x, y)) {
									count++;
								}
							}
						}
						if(Utils.isInteger(Math.sqrt(count))) {
							square++;
						}
					}
				}
			}
		}
		System.out.println(square);
		//Utils.assert_(square == 42);
		
		uptime();
	}
	
	
	//https://www.desmos.com/calculator/4gldcisifb
	static class Quad {
		
		private float a, b, c, d;
		
		public Quad(float a, float b, float c, float d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		
		public boolean contains(float x, float y) {
			return satisfiesAB(x, y) && satisfiesBC(x, y) && satisfiesCD(x, y) && satisfiesDA(x, y);
		}
		
		//Purple line
		private boolean satisfiesAB(float x, float y) {
			return y < (-b / a) * x + b;
		}
		
		//Red line		
		private boolean satisfiesBC(float x, float y) {
			return y < (b / c) * x + b;
		}
		
		//Black line
		private boolean satisfiesCD(float x, float y) {
			return y > (d / -c) * x - d;
		}
		
		//Green line
		private boolean satisfiesDA(float x, float y) {
			return y > (d / a) * x - d;
		}
	}
}
