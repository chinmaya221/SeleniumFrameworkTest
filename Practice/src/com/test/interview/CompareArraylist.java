package com.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompareArraylist {
	
	public static void main(String[] args) {
		
		ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F"));
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("A","B","C","D","E","G"));
		
		Collections.sort(list1);
		
		Collections.sort(list2);
		
		System.out.println(list1.equals(list2));
		
		System.out.println(list1.removeAll(list2));
		
		System.out.println(list1);
		
			
		
	}

}
