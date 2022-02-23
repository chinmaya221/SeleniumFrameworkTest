package com.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test6 {
	
	public static void main(String[] args) {
		
		 String citynames[]={"Boston", "Dallas", "New York", "Chicago"};
		 
		 ArrayList<String> cities = new ArrayList<>(Arrays.asList(citynames));
		 
		 cities.add("San Fransisco");
		 cities.add("San jose");
		 
		 for(String city: cities) {
			 System.out.println(city);
		 }
		
	}

}
