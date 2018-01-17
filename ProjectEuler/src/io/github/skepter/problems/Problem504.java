package io.github.skepter.problems;

import io.github.skepter.utils.RT;

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
	 */
	public static void main(final String[] args) {
		/*
		 * Suppose m = n.
		 * The number of quarilaterals = n^4
		 */
		uptime();
	}
	
	class Quad {
		
		private int a, b, c, d;
		
		public Quad(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		
		public boolean contains(int x, int y) {
			/*
			 * Using gradients and inequalities... oh geez
			 */
			return false;
		}
	}
}
