package com.ch05.inheritance;

public class ManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// construct a Manager object
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		
		Employee[] staff = new Employee[3];
		
		// fill the staff array with Manager and Employee objects
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
		
		
		Employee e2 = new  Manager("Test", 80000, 1987, 12, 15);
		System.out.println(e2.getSalary());
		e2 = new Employee("666", 6666, 1990, 3, 16);
		//e2.setBonus(600);
		
		//System.out.println(e2.getName());
		System.out.println("------------------");
		System.out.println(e2.getSalary());
		
		/*
		// print out information about all Employee objects
		for(Employee e : staff) {
			System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
		}
		*/
	}
}
