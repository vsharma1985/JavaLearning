package com.sample.learning;
class GfG{
	public static String convertFive(int n){
		 String str = Integer.toString(n);
	     
	     for(int i=0;i<str.length();i++) {
	    	 if(str.contains("0")) {
	    	 str =str.replace("0", "5");
	    	 }
	    	 
	     }
	     
	     return str;
	
     
}
	
	public static void main(String[] args) {
		
		System.out.println(convertFive(87989));
	}
}