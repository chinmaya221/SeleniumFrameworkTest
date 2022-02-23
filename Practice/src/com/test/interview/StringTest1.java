package com.test.interview;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class StringTest1 {
	
	public static void main(String[] args) {
		
		String str = "The first second was alright but the second second was tough.";
		
		System.out.println("Original String - "+str);
		
		String[] strArray = str.split("\\s+");
		
		LinkedHashSet<String> list = new LinkedHashSet<String>(Arrays.asList(strArray));
		
		StringBuilder strBuilder = new StringBuilder();
		int index=0;
		
		for(String s:list) {
			if(index > 0) 
				strBuilder.append(" ");
			
			    strBuilder.append(s);
			    index++;
		}
		
		str = strBuilder.toString();
		
		System.out.println("String after removing duplicate words: ");
		System.out.println(str);
		
		
		
	}

}
