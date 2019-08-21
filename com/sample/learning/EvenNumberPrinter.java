package com.sample.learning;

public class EvenNumberPrinter extends Thread {
	
	OddEvenPrinter oddEvenPrinter;
	
	public EvenNumberPrinter(OddEvenPrinter oddEvenPrinter) {
		this.oddEvenPrinter = oddEvenPrinter;
		
	}
	
	@Override
	public void run() {
		
		for(int i=2 ;i<=10;i=i+2) {
			oddEvenPrinter.printEven(i);
		}
	}

	
	
}
