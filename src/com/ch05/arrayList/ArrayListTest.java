package com.ch05.arrayList;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
		
		// reflection test
		// method1: create class object by instance
		Employee e = new Employee("zhangsan", 66666, 1999, 6, 6);
		Class  c1 = e.getClass();
		System.out.println(c1.getName() + " " + e.getName());
	
		// method2: create class object by Class.forName(str);
		String className = "java.util.Random";
		Class c2 = Class.forName(className);
		System.out.println(c2.getName());
		
		// method3: create class object by Class.class
		Class c3 = Random.class;
		Class c4 = int.class;
		Class c5 = Double[].class;
		System.out.println(c3.getName());
		System.out.println(c4.getName());
		System.out.println(c5.getName());
	
		// one Class, one Class Object
		System.out.println(e.getClass() == Employee.class);
		
		// create instance
		// System.out.println(e.getClass().newInstance());
		String s = "java.util.Random";
		Object m = Class.forName(s).newInstance();
		System.out.println(m.getClass());
		
		Class<Random> c6 = Random.class;
	}

}
