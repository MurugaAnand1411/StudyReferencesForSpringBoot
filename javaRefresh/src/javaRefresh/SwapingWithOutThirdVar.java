package javaRefresh;

import java.util.Scanner;

public class SwapingWithOutThirdVar {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("first numeber is=");
			 int x = sc.nextInt();
			 System.out.println("first numeber is=");
			 int y = sc.nextInt();
		
	
//	a=a+b;
//	b=a-b;
//	a=a-b;
	x = x ^ y;
	y= x ^ y;
	x= x ^ y;
	System.out.println("the numbers are "+x+"and "+y);
		}

		
	}
}
	 




