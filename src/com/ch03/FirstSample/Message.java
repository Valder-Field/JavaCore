package com.ch03.FirstSample;

public class Message {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0 || args[0].equals("-h"))
			System.out.println("Hello, ");
		else if (args[0].equals("-g")) {
			System.out.println("Goodbye, ");
		}
		
		for(int i = 1; i < args.length; i++) {
			System.out.println(" " + args[i]);
		}
		System.out.println("!");
	}

}
