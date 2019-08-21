package com.sample.learning;

public class methodName {

	static void methodTrans(String name) {
		
		String[] strArr = name.split("_");
		String val = "";
		val  = strArr[0];
		for(int i =1;i<strArr.length;i++) {
			val =val+toProperCase(strArr[i]);
		}
		
		System.out.println(val);
	}
	
	
	static String toProperCase(String s) {
	    return s.substring(0, 1).toUpperCase() +
	               s.substring(1).toLowerCase();
	}
	
	
	public static void main(String[] args) {
		
		methodTrans("this_is_method");
	}
}
