package com.sample.learning;

public class FunctionalImpl {

	public static void main(String[] args) {
		
		FunctionInterface f = (a,b) ->{
			return a+b;
		};
		int g  = f.add(4, 5);
		System.out.println(g);
		String n  = new String();
	}
}
