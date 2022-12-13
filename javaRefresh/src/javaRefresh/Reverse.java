package javaRefresh;

public class Reverse {
	public static String reverseEachChaInStr(String str)
	{
		String Strsp[]=str.split(" ");
		String reverseStr="";
		for(String s: Strsp)
		{
			StringBuilder sb=new StringBuilder(s); 
			sb.reverse();
			reverseStr +=sb.toString()+" ";  
		}
		return  reverseStr.trim();  	
	}
	
	public static void main(String[] args) {
//		int number, reverse = 0;
//
//		try (Scanner scobj = new Scanner(System.in)) {
//			System.out.println("enter the number ");
//			number = scobj.nextInt();
//		}
//		while (number != 0) {
//			reverse = 0;
//			int reminder = number % 10;
//			reverse = reverse * 10 + reminder;
//			number = number / 10;
//
//		}
//		System.out.println("The reverse nembers are" + reverse);
		  System.out.println(Reverse.reverseEachChaInStr("my name is muruga"));	
		String s2[] = "I love Java Programming".split(" ");
		String ans="";
		for(int i=s2.length-1;i>=0;i--) {
			ans += s2[i]+" ";
		}
		System.out.println(ans);
	}
}
