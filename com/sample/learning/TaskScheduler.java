package com.sample.learning;

public class TaskScheduler {

	String[] result = new String[50];	
	
	public String[] processTask(String[] tasks,String[] dependencies) {
		if(tasks.length==0) {
			System.out.println(" Empty Task array");
			return result ;
			
		}
		
		else {
			System.out.println("Processing Task");
			if(dependencies.length==0) {
				
				for(int i=0;i<tasks.length;i++) {
					//System.out.println(tasks[i]);
					result[i]=tasks[i];
				}
				
			}
			
			else {
				
			}
		
		}
		return result;
		
		
	}
	
	
	public static void main(String[] args) {
		
		TaskScheduler ts = new TaskScheduler();
		
		String[] tasks = new String[] {"a","b"};
		String[] dependencies = new String[] {};
		
		String a[] = ts.processTask(tasks, dependencies);
		for(int i=0;i<a.length-1;i++) {
			System.out.print("["+a[i]+"]");	
		}
		
		
	}
}
