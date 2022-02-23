package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test4 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<=6; i++) {
			
			list.add(i);
			
		}
		
	    Integer Numbers[] = new Integer[list.size()];
	    for(int j=0;j<list.size();j++) {
	    	Numbers[j] = list.get(j);
	    }
	    
	    for(Integer arrayNumber: Numbers) {
	    	System.out.println(arrayNumber);
	    }
	    
	    
	    Integer arrayOfNumbers[] = list.toArray(new Integer[list.size()]);
	    
	    for(Integer arrayOfNumber: arrayOfNumbers) {
	    	System.out.println(arrayOfNumber);
	    }
		
	}

}
