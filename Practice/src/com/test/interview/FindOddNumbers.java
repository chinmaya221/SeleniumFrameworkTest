package com.test.interview;

import java.util.ArrayList;
import java.util.List;

public class FindOddNumbers {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(2);
		list.add(3);
		
		for(int number:list) {
			if(number%2!=0) {
				System.out.println(true);
				break;
			}
		}
		
	}

}
