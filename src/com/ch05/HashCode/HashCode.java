package com.ch05.HashCode;

public  class HashCode {
	public static void main(String[] args) {
		
		String s = "OK";
		StringBuilder sb = new StringBuilder(s);
		System.out.println("String: " + s.hashCode() + " StringBuilder: " + sb.hashCode());
		
		String t = new String("OK");
		StringBuilder tb = new StringBuilder(t);
		System.out.println("String: " + t.hashCode() + " StringBuilder: " + tb.hashCode());
	
	}
}
