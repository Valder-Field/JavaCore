package com.ch06.methodReference;

import javax.swing.Timer;

public class methodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t = new Timer(1000, System.out::println);
	}

}

class Greeter{
	public void greet() {
		System.out.println("Hello, world!");
	}
}

class TimedGreeter extends Greeter{
	public void greet() {
		// Timer t = new Timer(1000, super::greet);
		// t.start();
	}
}