package com.ch05.methods;

import java.lang.reflect.Method;

public class MethodTableTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		// get method pointers to the square and sqrt methods
		Method square = MethodTableTest.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		
		// print tables of x- and y-values
		printTable(1, 10, 10, square);
		printTable(1, 10, 10, sqrt);
	}
	
	/**
	 * Returns the square of a number
	 */
	public static double square(double x) {
		return x * x;
	}
	
	/**
	 * Prints a table with x- and y-values for a method
	 */
	public static void printTable(double from, double to, int n, Method f) {
		// print out the method as table header
		System.out.println("f = " + f);
		
		double dx = (to - from) / (n - 1);
		
		for(double x = from; x <= to; x += dx) {
			try {
				// 回调方法使用
				double y = (Double) f.invoke(null, x);
				System.out.printf("%10.4f | %10.4f%n", x, y);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
