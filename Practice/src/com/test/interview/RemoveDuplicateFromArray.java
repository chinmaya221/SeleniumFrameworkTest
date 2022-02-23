package com.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateFromArray {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5));
		
		LinkedHashSet<Integer> hasSet = new LinkedHashSet<>(list);
		
		ArrayList<Integer> listWithoutDuplicate = new ArrayList<>(hasSet);
		
		System.out.println(listWithoutDuplicate);
		
		// using java8 - stream
		ArrayList<Integer> streamObj = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5));
		
		List<Integer> removedObj =  streamObj.stream().distinct().collect(Collectors.toList());
		
		System.out.println(removedObj);
	}

}
