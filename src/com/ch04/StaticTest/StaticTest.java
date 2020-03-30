package com.ch04.StaticTest;

public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Tom", 40000);
		staff[0].setId();
		staff[1] = new Employee("Dick", 60000);
		staff[1].setId();
		staff[2] = new Employee("Harry", 60000);
		staff[2].setId();
		
		//print out information about all Employee Objects
		for(Employee e : staff) {
			e.getId();
			System.out.println("name= " + e.getName() + ",id= "
					+ e.getId() + ",salary=" + e.getSalary());
		}
		
		int n = Employee.getNextId(); //call static method
		System.out.println("Next available id=" + n);
	}

}

class Employee{
	private static int nextId = 1;
	
	private String name;
	private double salary;
	private int id;
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
		id = 0;
	}
	
	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Employee.nextId = nextId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId;
		nextId++; //用于计数员工数
	}

	public static void main(String[] args) { //unit test
		Employee e = new Employee("harry", 50000);
		System.out.println(e.getName() + " " + e.getSalary());
	}
	
}
