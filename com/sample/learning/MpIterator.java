package com.sample.learning;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MpIterator {

	public static void main(String[] args) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(1, 1);
		
		 Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator(); 
         
	        while(itr.hasNext()) 
	        { 
	             Map.Entry<Integer, Integer> entry = itr.next(); 
	             System.out.println("Key = " + entry.getKey() +  
	                                 ", Value = " + entry.getValue()); 
	             map.put(2, 2);
	             
	        } 
	        
	        Iterator<Map.Entry<Integer, Integer>> itr1 = map.entrySet().iterator(); 
	         
	        while(itr1.hasNext()) 
	        { 
	             Map.Entry<Integer, Integer> entry = itr1.next(); 
	             System.out.println("Key = " + entry.getKey() +  
	                                 ", Value = " + entry.getValue()); 
	             //map.put(2, 2);
	             
	        } 
		
	}
}
