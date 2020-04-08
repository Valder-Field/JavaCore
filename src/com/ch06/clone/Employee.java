package com.ch06.clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
	private String name;
	private double salary;
	private Date hireDate;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		hireDate = new Date();
	}
	
	public Employee clone() throws CloneNotSupportedException{
		// call Object.clone()
		Employee cloned = (Employee)super.clone();
		
		// clone mutable fields
		cloned.hireDate = (Date)hireDate.clone();
		
		return cloned;
	}
	
	/**
	 * set the hire day to a given date.
	 */
	public void setHireDay(int year, int month, int day) {
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		hireDate.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public String toString() {
		return "Employee[name=" + name + ",salary=" + salary + ",hireDay="
				+ hireDate + "]";
	}
}
