package com.iocor.stats;

public class MathHelper {
	public static double SquareRoot(double x) {
		return Math.pow(x, 0.5);
	}

	public static double Square(double x) {
		return Math.pow(x, 2);
	}

	public static double TrapeziumArea(double width, double a, double b) {
		return (0.5 * width * (a + b));
	}

	public static float Round(double d, int Rpl) {
		float p = (float) Math.pow(10, Rpl);
		d = d * p;
		float tmp = Math.round(d);
		return (float) tmp / p;
	}

	public static int Factorial(int x) {
		if (x == 0) {
			return 1;
		} else {
			int mul = 2;
			for (int i = 3; i <= x; i++) {
				mul *= i;
			}
			return mul;
		}

	}

	public static double Exp(double d) {
		return Math.pow(Math.E, d);
	}
}
