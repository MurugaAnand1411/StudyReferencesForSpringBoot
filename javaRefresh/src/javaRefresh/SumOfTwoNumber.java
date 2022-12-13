package javaRefresh;

import java.util.Scanner;

public class SumOfTwoNumber {
	public static void main(String[] args) {
		int x,y,s;
		 try (Scanner sc = new Scanner(System.in)) {
			System.out.println("first numeber is=");
			 x=sc.nextInt();
			 System.out.println("second numeber is=");
			 y=sc.nextInt();
		}
			s= sum(x,y);
		 System.out.println("sum of two numer is ="+s);
		}


	public static int sum(int a,int b) {
		
		int c =a+b;
		return c;
	}

}
