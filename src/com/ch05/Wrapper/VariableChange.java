package com.ch05.Wrapper;

public class VariableChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double m = max(3.1, 40.4, -5);
		System.out.println(m);
		
		System.out.printf("%d %s",
				new Object[] {new Integer(3), "widgets"});
		System.out.println();
		System.out.printf("%d %s", 3, "widgets");
		System.out.println();
		System.out.printf("%d %s", Integer.valueOf(3), "widgets");
	}

	public static double max(double... values) {
		double largest = Double.NEGATIVE_INFINITY;
		System.out.println(largest);
		for(double v : values) {
			if (v > largest) {
				largest = v;
			}
		}
		return largest;
	}
}
