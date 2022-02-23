package com.test.interview;

public class FindGreaterNumberWithOutIfCondition {
	
	public static void main(String[] args) {
		
		int i=10;
		int j=20;
		int l=30;
		
		int k = i>j?(j>l?j:l):(l>j?l:j);
		
		System.out.println(k);
		
		
	}

}
