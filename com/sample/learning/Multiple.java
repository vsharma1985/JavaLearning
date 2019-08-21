package com.sample.learning;

public class Multiple {

	public void  multiple(int n) {
		
		for(int i=1;i<=10;i++) {
			
			System.out.println(n+"*"+i+"="+n*i);
		}
	}
	
	public static void main(String[] args) {
		Multiple m = new Multiple();
		m.multiple(2);
	}
}
