package com.test.interview;

public class PrimeNumber {
	
	public static void main(String[] args) {
		
		System.out.println(isPrime(10));
		System.out.print(isPrime(34));
		
	}

	private static boolean isPrime(int i) {
		
		if(i==0 || i==1) {
			return false;
		}
		else if(i==2) {
			return true;
		}
		else {
			for(int j=2; j<=i/2;j++) {
				if(i%j==0) {
					return false;
				}
			}
		}
		
		return true;
	}

}
