package com.test;

import java.util.HashSet;
import java.util.Iterator;

public class Test5 {
	
	public static void main(String[] args) {
		
		HashSet<String> hset = new HashSet<>();
		hset.add("mango");
		hset.add("apple");
		hset.add("banana");
		hset.add("jackfruit");
		
		
		Iterator<String> itr = hset.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		for(String fruit:hset) {
			System.out.println(fruit);
		}
		
		if(hset.contains("apple")) {
			System.out.println("Item is present");
		}
		else {
			System.out.println("Item is not present");
		}
		
	}

}
