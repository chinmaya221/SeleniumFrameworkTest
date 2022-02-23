package com.test.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPrograms {
	
	
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Eneter your String:");
		String str = br.readLine();
		String reverserString = reverserStringMethod(str);
		
		System.out.print("Reverser of your String is "+reverserString);
		
		br.close();
		
		
	}

	private static String reverserStringMethod(String str) {
		
		char strChars[] = str.toCharArray();
		String reverserString=" ";
		
		for(int i=strChars.length-1;i>=0;i--) {
		    
			reverserString=reverserString+strChars[i];
			
		}
		
		
		return reverserString;
	}

}
