package com.ch06.clone;

public class CloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Employee original = new Employee("John Q. public", 50000);
			original.setHireDay(2000, 1, 1);
			Employee copy = original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 12, 21);
			System.out.println("original=" + original);
			System.out.println("copy=" + copy);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
