package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {
	
	
	public static String reversedString(String str) {
		//my name is chinmaya
		
		String strArray[] = str.split(" ");
		String reverse="";
		
		for(int i =strArray.length-1;i>=0;i--) {
		   
			reverse = reverse+strArray[i]+" ";
			
		}
		
		System.out.println(reverse);
		
		
		
		
		return reverse;
		
	}
	
	public static String reverseChar(String str) {
		
		char strChar[] = str.toCharArray();
		String reversedChar="";
		
		for(int i=strChar.length-1; i>=0;i--) {
			
			reversedChar=reversedChar+strChar[i];
		}
		
		return reversedChar;
		
	}
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Eneter your string :");
		String str = br.readLine();
		System.out.println("Reversed string is "+reverseChar(str));
		br.close();
		
	}

}
