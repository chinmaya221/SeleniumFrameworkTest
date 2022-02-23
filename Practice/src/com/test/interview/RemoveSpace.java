package com.test.interview;

public class RemoveSpace {
	
	public static void main(String[] args) {
		
		String str="This is Chinmaya";
		String resverseString="";
		char[] charArray = str.toCharArray();
		
		for(int i=charArray.length-1;i>=0;i--) {
		 	
			resverseString = resverseString+charArray[i];
		}
		
		System.out.println(resverseString);
	}

}
