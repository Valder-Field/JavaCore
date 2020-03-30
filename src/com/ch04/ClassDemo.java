package com.ch04;

import java.util.Date;

public class ClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new Date().toString();
		System.out.println(s);
		
		Date birthday = new Date();
		Date deadline = birthday;
		deadline = null;
	}

}
