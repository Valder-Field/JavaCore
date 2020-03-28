package com.ch03.FirstSample;

public class Constant2 {
	public static final double CM_PER_INCH = 2.54;
	public static void main(String[] args) {
		double paperWidth = 8.5;
		double paperHeight = 11;
		System.out.println("Paper size in centimeters: " + paperWidth * 
				CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
		
		System.out.println(8 + 8);
		//System.out.println(8 / 0);
		System.out.println(8.0 / 0);
		
		int n = 123456789;
		float f = n;
		System.out.println(n);
		System.out.println(f);
		
		double x = 9.997;
		int nx = (int) x;
		System.out.println(x);
		System.out.println(nx);
		System.out.println((byte)300);
		
		int xx = 1;
		System.out.println(xx += 3.5);
		System.out.println(Size.EXTRA_LARGE);
		
		String greeting = "hello";
		System.out.println(greeting.substring(0, 3));
		
		System.out.println("The answer is " + 33);
		String all = String.join("/", "S", "M", "L", "XL");
		System.out.println(all);
		
		String greeting1 = "hello";
		String greeting2 = greeting1.substring(0, 3) + "p!";
		System.out.println(greeting == greeting1);
		System.out.println(greeting1 == greeting2);
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1 == s2);
		
		System.out.println("".equals(""));
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("hello");
		stringBuilder.append(" world!");
		System.out.println(stringBuilder);
	}
}

enum Size{
	SMALL,
	MEDIUM,
	LARGE,
	EXTRA_LARGE
}
