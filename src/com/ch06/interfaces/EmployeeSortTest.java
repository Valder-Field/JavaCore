package com.ch06.interfaces;

import java.util.Arrays;

public class EmployeeSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);
		
		Arrays.sort(staff);
		
		// print out information about all Employee objects
		for(Employee e : staff) {
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
		}
		
		if(staff[0] instanceof Comparable) {
			System.out.println("true");
		}
		
		System.out.println(new A().SPEED_LIMIT);
		
		Comparable<Employee> x = new Employee("s", 666);
	}
}

interface Moveable{
	void move(double x, double y);
}

interface Powered extends Moveable{
	double SPEED_LIMIT = 95; // a public static final constant
	double milesPerGallon();
}

class A implements Powered{

	@Override
	public void move(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double milesPerGallon() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
