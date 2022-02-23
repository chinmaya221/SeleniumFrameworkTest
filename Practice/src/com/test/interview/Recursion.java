package com.test.interview;

public class Recursion {
	
	public int factorialOfNumber(int i) {
		if(i==1) {
			return i;
		}
		else {
			i = i*factorialOfNumber(i-1);
			return i;
		}
	}
	
	
	public static void main(String[] args) {
		
		Recursion r = new Recursion();
		System.out.println(r.factorialOfNumber(5));
	}

}
