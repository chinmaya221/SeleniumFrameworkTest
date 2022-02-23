package com.test.interview;

public class FindVowel {
	
	public static void main(String[] args) {
		
		String str = "Hello";
		
		boolean isPresent = str.toLowerCase().matches(".*[aeiou].*");
		
		System.out.println(isPresent);
		
		
	}

}
