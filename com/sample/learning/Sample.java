package com.sample.learning;

public class Sample {

	public int find(int num)
	{
		int count =0;
		if(num<10) {
			return 0;
		}
		
		if(num==10) {
			return num;
		}
		
		else {
			
		}
		 while (num!=0) {
			
			 num =num/10;
			 ++count;
		 }
		System.out.println(count);
		int d =0;
		for (int i =0;i<=count;i++) {
			
			d =10*10;
			
		}
		
		return 10^count;
	}
	
	public static void main(String[] args) {
		
		Sample s  = new Sample();
		int a =s.find(12345);
		System.out.println(a);
	}
}
