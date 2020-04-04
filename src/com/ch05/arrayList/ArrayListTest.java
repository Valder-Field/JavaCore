package com.ch05.arrayList;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// fill the staff array list with three Employee objects
		ArrayList<Employee> staff = new ArrayList<>();
		
		staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
		staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
		staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
		
		// raise everyone's salary by 5%
		for(Employee e : staff) {
			e.raiseSalary(5);
		}
		
		// print out information about all Employee objects
		for(Employee e : staff) {
			System.out.println("name=" + e.getName()
			+ " ,salary=" + e.getSalary() + " ,hireDay=" + e.getHireDay());
		}
		
		Employee test = staff.get(2);
		System.out.println(test.getName());
		
		Employee[] arr = new Employee[staff.size()];
		staff.toArray(arr);
		for(Employee e : arr) {
			System.out.println("name=" + e.getName()
			+ " ,salary=" + e.getSalary() + " ,hireDay=" + e.getHireDay());
		}
	}

}
