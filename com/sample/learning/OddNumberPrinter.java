package com.sample.learning;

public class OddNumberPrinter extends Thread{

	OddEvenPrinter oddEvenPrinter;
	
	public OddNumberPrinter(OddEvenPrinter oddEvenPrinter) {
		this.oddEvenPrinter = oddEvenPrinter;
	}
	
	@Override
	public void run() {
		
		for(int i=1 ;i<=10;i=i+2) {
			oddEvenPrinter.printOdd(i);
		}
	}

	
}
