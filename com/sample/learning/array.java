package com.sample.learning;
import java.util.Arrays;

public class array {

	public int solution(int A[]) {
		int r =0;
		Arrays.sort(A);
		for(int i=0;i<=A.length-1;i++){// iterate until  penultimate element
	        if(A[i]>0 && A[i+1]!=(A[i]+1)){
	            r= A[i]+1;
	        }
		}
		//return ;
		return r;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,3,2,4,6}; 
		array a = new array();
		a.solution(arr);
	}
}
