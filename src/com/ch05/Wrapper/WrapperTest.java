package com.ch05.Wrapper;

import java.util.ArrayList;import com.ch05.HashCode.HashCode;

public class WrapperTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.valueOf(3));
		int n = list.get(0).intValue();
		
		Integer a = 1000;
		Integer b = 1000;
		System.out.println(a == b);
		
		
		// System.out.println(1 == 1);
		// System.out.println(1.HashCode);
		
		// 混合运算自动装箱
		Integer n2 = 1;
		Double x2 = 2.0;
		System.out.println(n2 * x2);
		
		int x = Integer.parseInt("123");
		System.out.println(x);
		
	}
}
