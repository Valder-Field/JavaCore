package com.ch05.inheritance;

import java.time.LocalDate;

class Employee {
	private final String name;
	private double salary;
	private LocalDate hireDay;
	
	/*
	public Employee() {
		this.name = "";
	}*/
	
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		this.hireDay = LocalDate.of(year, month, day);
	}


	public String getName() {
		return name;
	}


	public double getSalary() {
		System.out.println("∏∏¿‡:getSalary()");
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
