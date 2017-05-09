package io.github.skepter.Testing;

import ch.aplu.turtle.Turtle;

public class DrawingTorricelli {

	/* Problem 143 */
	public static void main(String[] args) {
		int intAngle = 180 - 60;
		int size = 100;
		Turtle turtle = new Turtle();

		turtle.forward(size);
		turtle.left(intAngle);
		turtle.forward(size);
		turtle.left(intAngle);
		turtle.forward(size);
		turtle.left(intAngle);
		turtle.forward(size);
		//		turtle.forward(size / 2);
		//		turtle.left(90);
		//		turtle.forward(size / 2);
		java.awt.geom.Point2D.Double pos1 = turtle.getPos();
		turtle.penUp();
		for (int i = 0; i < 300; i++) {
			turtle.forward(1);
			turtle.left(1);
		}
		turtle.penDown();
		java.awt.geom.Point2D.Double pos2 = turtle.getPos();

		turtle.right(90);
		turtle.forward(distance(pos1, pos2));

		for (int i = 0; i < 360; i++) {
			turtle.forward(1);
			turtle.left(1);
		}
	}

	public static double distance(java.awt.geom.Point2D.Double pos1, java.awt.geom.Point2D.Double pos2) {
		double x = (pos2.getX() - pos1.getX()) * (pos2.getX() - pos1.getX());
		double y = (pos2.getY() - pos1.getY()) * (pos2.getY() - pos1.getY());
		return Math.sqrt(x + y);
	}
}
