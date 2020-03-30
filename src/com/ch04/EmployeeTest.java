package com.ch04;

import java.time.LocalDate;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;


public class EmployeeTest {
	public static void main(String[] args) {
		// fill the staff array with three Employee objects
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

		// raise everyone's salary by 5%
		for(Employee e : staff) {
			e.raiseSalary(5);
		}
		
		// print out information about all Employee objects
		for(Employee e : staff) {
			System.out.println("name=" + e.getName()
			+ ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
		}
	}

}

class Employee {
	private final String name;
	private double salary;
	private LocalDate hireDay;
	private  int id;//ÊµÀýÓò
	
	static {
		//id = 4;
	}
	
	public Employee(String name, double salary, int year, int month, int day) {
		super();
		this.name = name;
		this.salary = salary;
		this.hireDay = LocalDate.of(year, month, day);
	}


	public String getName() {
		return name;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void setHireDay(LocalDate hireDay) {
		this.hireDay = hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = this.salary * byPercent / 100;
		this.salary += raise;
	}

}