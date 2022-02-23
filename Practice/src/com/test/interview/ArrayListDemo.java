package com.test.interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListDemo {
	
	
	public static void main(String[] args) {
		
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Java");
		list1.add("python");
		list1.add("Rubby");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("JS");
		list2.add("C#");
		
		list1.addAll(list2);
		
		System.out.println(list1);
		
		String Names[] = {"mike","john","lisa","Ron","Ron"};
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(Names));
		
		System.out.println(list);
		
		String arrayOfnames [] = list.toArray(new String[6]);
		
		System.out.println(list1.indexOf("Rubby"));
		
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		numbers.removeIf(num -> num%2 > 0);
		System.out.println(numbers);
		
		ArrayList<String> retainList = new ArrayList<String>(Arrays.asList(Names));
		
		retainList.retainAll(Collections.singleton("Ron"));
		System.out.println(retainList);
	  
	}

}
