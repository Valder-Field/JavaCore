package com.ch06.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparator<String> comp = new LengthComparator();
		System.out.println(comp.compare("123", "3456"));
		
		String[] str = {"123,", "332432", "1"};
		Arrays.sort(str, comp);
		for (String string : str) {
			System.out.print(string + " ");
		}
	}

}

class LengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length() - o2.length();
	}
}
