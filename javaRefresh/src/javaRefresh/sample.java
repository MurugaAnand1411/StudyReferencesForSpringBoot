package javaRefresh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class sample {	
	
	  interface Addition {
	      int add(int a, int b);
	   }
	   public static Addition getAddition() {
	      return (a, b) -> a + b; // lambda expression return statement
	   }
	  
	
  

public static void main(String[] args) {
	ArrayList<Integer> ial= new ArrayList<Integer>();
	ial.add(5);
	ial.add(10);
	ial.add(12);
	ial.add(15);
	ial.add(6);
	ial.add(20);
	ial.add(25);
	ial.add(30);
	System.out.println(ial);
	
	
	List<Integer> addedmap
    = ial.stream()
          .map(i -> i - 5)
          .collect(Collectors.toList());
	System.out.println(addedmap);
	  System.out.println("The addition of a and b is: " + getAddition().add(20, 50));
	  
}
	    
}



		
		

	
