package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Test {
	
	public static void main(String[] args) {
		
		Test sol = new Test();
	        
	    String str = "This is is my class test test";
	    
	    sol.duplicateOccuranceOfString(str);
		
		
	}
	
	 public String reverseWords(String Str) 
	    { 
	      Pattern pattern = Pattern.compile("\\s");
	      
	      String[] temp = pattern.split(Str);
	      
	      String result = "";
	      System.out.println(temp.length);
	      
	      for(int i=0; i< temp.length; i++) {
	    	if(i==temp.length -1) {
	    		result = temp[i]+result;
	    		System.out.println(result);
	    	}
	    	else {
	    		result = " "+temp[i]+result;
	    		System.out.println(result);
	    	}
	      }
	      
	      return result;
	        
	    } 
	 
	 
	 public String duplicateOccuranceOfString(String str) {
         
		 String [] tempString = str.split(" ");
		
		 HashMap<String, Integer> tempStringMap = new HashMap<>();
		 
		 for(String temp:tempString) {
			 
			 if(tempStringMap.get(temp) != null) {
				 tempStringMap.put(temp, tempStringMap.get(temp)+1);
			 }
			 else {
				 tempStringMap.put(temp, 1);
			 }
			 
			
		 }
		 
		 System.out.println(tempStringMap);
		 
		 
		 
		 
		 
		 
		 
		 return "";
	 }

}
