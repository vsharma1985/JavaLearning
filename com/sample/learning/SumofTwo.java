package com.sample.learning;
import java.util.HashMap;

public class SumofTwo {

	
	public static void main(String[] args) {
		
		SumofTwo s = new SumofTwo();
		int[] a = new int[]{1, 4, 45, 6, 10, 9};
		int[] b= s.twoSum(a, 16);
		System.out.println(b[0]+" "+b[1]);
		
	}

	    public int[] twoSum(int[] nums, int target) {
	        HashMap <Integer, Integer> map 
	            = new HashMap<Integer, Integer>();
	        int complement;
	        //loop to check every element in the array
	        for (int i = 0; i<nums.length; i++) {
	            complement = target - nums[i];
	            //if we already have the complement in HashMap,
	            //return an array that contains indices of them.  
	            if (map.containsKey(complement)) {
	                return new int[] {i, map.get(complement)};
	            }
	            //if its complement is not in HashMap but in the array,
	            //they will be matched when the complement is 
	            //regarded as current element.
	            //add current element into HashMap.
	            map.put(nums[i], i);
	        }
	        //Exception which says it is unavailable to find solution
	        //with these arguments.
	        throw new IllegalArgumentException("No solution");
	    
	}
}
