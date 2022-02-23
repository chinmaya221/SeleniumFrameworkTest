package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
	
	
	public static void numberOfWordsInString(String str) {
	
		//beer
	
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		char strChar[] = str.toCharArray();
		
		for(char c:strChar)
		{
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		
		for(Map.Entry entry:map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Eneter your word : ");
		String str = br.readLine();
		numberOfWordsInString(str);
		
		
	}

}
