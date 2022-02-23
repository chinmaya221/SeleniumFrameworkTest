package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test8 {
	
	public static void main(String[] args) {
		
		  // Creating a HashMap of int keys and String values
	    HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	 
	    // Adding Key and Value pairs to HashMap
	    hashmap.put(22,"A");
	    hashmap.put(55,"B");
	    hashmap.put(33,"Z");
	    hashmap.put(44,"M");
	    hashmap.put(99,"I");
	    hashmap.put(88,"X");
		
	    
	    System.out.println("Before sorting : ");
	    
	    Set set = hashmap.entrySet();
	    Iterator<Map.Entry<Integer, String>> entrySet = set.iterator();
	    while(entrySet.hasNext()) {
	    	Map.Entry pair = (Map.Entry)entrySet.next();
	    	System.out.print(pair.getKey()+":");
	    	System.out.println
	    	(pair.getValue());
	    }
	    
	    System.out.println("After Sorting:");
	    
	    Map<Integer, String> map = new TreeMap<Integer, String>(hashmap);
	    Set set2 = map.entrySet();
	    Iterator itr2 = set2.iterator();
	    while(itr2.hasNext()){
	       Map.Entry pair2 = (Map.Entry)itr2.next();
	       System.out.print(pair2.getKey()+":");
	    	System.out.println(pair2.getValue());
	    }
	    
	    
	    
	    
	}

}
