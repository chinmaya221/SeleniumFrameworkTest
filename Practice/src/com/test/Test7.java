package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test7 {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "Value1");
		map.put(2, "value2");
		map.put(3, "valu3");
		map.put(4, "value4");
		
		for(Integer key: map.keySet()) {
			
			System.out.println("For the key :"+key+" "+"This is the value: "+map.get(key));
		}
		
		Set<Integer> keyset = map.keySet();
		Iterator<Integer> itr = keyset.iterator();
		while(itr.hasNext()) {
			System.out.println("Key is : "+itr.next()+"and value is: "+map.get(itr.next()));
		}
		
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		for(Map.Entry entry:entrySet) {
			System.out.println("Key :"+entry.getKey()+"Value :"+map.get(entry.getValue()));
		}
		
		
	}

}
