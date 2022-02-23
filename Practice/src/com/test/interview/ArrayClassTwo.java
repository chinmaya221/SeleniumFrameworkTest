package com.test.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayClassTwo {
	
	public static void main(String[] args) {
		
		List <String> nameList = Collections.synchronizedList(new ArrayList<>());
		
		nameList.add("java");
		nameList.add("python");
		nameList.add("Perl");
		
		System.out.println(nameList);
		
		synchronized (nameList) {
			Iterator<String> itr =  nameList.iterator(); 
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
		
		CopyOnWriteArrayList<String> copyList =  new CopyOnWriteArrayList<String>();
		copyList.add("mike");
		copyList.add("chinmay");
		copyList.add("samson");
		
		for(String s:copyList) {
			System.out.println(s);
		}
		
		
		
	}

}
