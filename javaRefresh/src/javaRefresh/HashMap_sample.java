package javaRefresh;

import java.util.HashMap;
import java.util.Iterator;

public class HashMap_sample {
	//method1
	public void basichashmap() {
		// first map
		HashMap<Integer, String> hm1 = new HashMap<>();
		hm1.put(1, "Hallem");
		hm1.put(2, "Muruga");
		hm1.put(3, "Karthi");
		hm1.put(4, "Elam");
		hm1.put(5, "Bharathi");
		hm1.put(null, "Krishnan");
		
		System.out.println("These are Has map Key and values" + hm1);
		hm1.put(5, "Sathiyan");
		System.out.println("Updated Map " + hm1);

		// second map

		HashMap<String, String> hm2 = new HashMap<>();
		hm2.put("SparingBoot", "Muruga");
		hm2.put("React", "Hallem");
		hm2.put("Angular", "Karthi");
		hm2.put("Java", "Elam");
		hm2.put("SQL", "Bharathi");
		System.out.println("These are Has map Key and values" + hm2);
		hm2.remove("SQL");
		System.out.println("Removed element from the Map " + hm1);

	}
	
	//method2
	public static void findDuplicateString(String str) {
		HashMap<String,Integer> dupstr = new HashMap<>();
		String[]  s= str.split(" ");
		for(String temstr:s)
		{
			if(dupstr.get(temstr)!=null) {
				dupstr.put(temstr, dupstr.get(temstr)+1);
				
			}else
			{
				dupstr.put(temstr,1);
			}
		}
		Iterator<String>temstr= dupstr.keySet().iterator();
		while (temstr.hasNext())
		{
		String temp =temstr.next();
		if(dupstr.get(temp)>1) {
		System.out.println("The words '"+temp+"' appired "+dupstr.get(temp)+" no of times");
		
		}
		}
	}
//
	public static void main(String[] args) {

		HashMap_sample hms = new HashMap_sample();
		hms.basichashmap();
		
		findDuplicateString("i am am tring to to learn hasmap code code code");
	}
}
