package com.sample.learning;

public class ZerosOnesSided {

	int[] a = new int[] {1,1,1,0,0,0,0,1};
	
	public static void main(String[] args) {
		
		ZerosOnesSided z = new ZerosOnesSided();
		z.placeZerosOne();
	}
	
	public void placeZerosOne() {
		int countOne=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==1) {
				countOne++;
				
			}
		}
		
		int[] b = new int[a.length];
		
		for(int j=0;j<countOne;j++) {
			b[j]=1;
		}
		
		for(int k=countOne+1;k<b.length;k++) {
			b[k]=0;
		}
		
		for(int p=0;p<b.length;p++) {
			System.out.println(b[p]);
		}
	}
}
