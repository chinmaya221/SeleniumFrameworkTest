package com.test.interview;

public class CalculateNumberOfUppercase {
	
	
	public static void main(String[] args) {
		
		String str = "My Name is Chinmaya";
		
		String upper = "";
		String lower = "";
		
		for(int i =0;i<str.length();i++) {
			
			char ch = str.charAt(i);
			
			if(ch>=65 && ch<=95) {
				upper=upper+ch;
			}
			else {
				lower = lower+ch;
			}
			
			
		}
		System.out.println("Upper characters are: "+upper+" "+"Lower characters are: "+lower);
		
		
	}

}
