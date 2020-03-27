package com.ch02.Welcome;

public class Welcome
{
   public static void main(String[] args)
   {
      String greeting = "Welcome to Core Java!";
      System.out.println(greeting);
	  System.out.println(greeting.length());
      for (int i = 0; i < greeting.length(); i++)
         System.out.print("=");
      System.out.println();
   }
}
