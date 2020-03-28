package com.ch03.FirstSample;

import java.util.Scanner;

public class SwitchDemo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch(choice) 
		{
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
			default:
				System.out.println("default!");
		}
		
		
		String input = "test";
		switch(input.toLowerCase()) 
		{
		case "test":
			System.out.println("yes");
			break;
		}
		
		
	}
}
