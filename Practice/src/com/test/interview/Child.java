package com.test.interview;

public class Child extends Parent{
	
	public void addNumber(int i, int j) {
		
		int k=i+j;
		System.out.println("child class : "+k);
		
	}
	
    public void devideChild(int i, int j) {
		
		int k=j-i;
		System.out.println("child class : "+k);
		
	}
	
	public static void main(String[] args) {
		
		Child obj1 = new Child(); // all methods in both child and parent class
		Parent obj2 = new Child(); // can call only parent class methods
		Parent obj3 = new Parent();// can call only parent class methods
		obj1.addNumber(10, 20);
		obj2.addNumber(20, 30);
		obj3.addNumber(40, 50);
		obj1.devideParent(40, 50);
		
	}

}
