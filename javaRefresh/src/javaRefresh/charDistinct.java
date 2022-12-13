package javaRefresh;

import java.util.HashMap;

public class charDistinct {
	public static void main(String[] args) {
		String input="hi muruga good moring";
	HashMap<Character, Integer> countChar= new HashMap<>();
	for (char c : input.toCharArray())
		countChar.merge(c, 1, Integer::sum);
	System.out.println(countChar);
	
	}
}
