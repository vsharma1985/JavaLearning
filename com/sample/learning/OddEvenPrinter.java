package com.sample.learning;

public class OddEvenPrinter {

	boolean isEvenPrinted = true;

	void printOdd(int num) {
		synchronized (this) {

			while (!isEvenPrinted) {

				try {

					wait();

				} catch (InterruptedException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

			System.out.println("Odd Number : " + num);

			notify();

			isEvenPrinted = false;

		}

	}

	void printEven(int num) {

		synchronized (this) {

			while (isEvenPrinted) {

				try {

					wait();

				} catch (InterruptedException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

			System.out.println("Even Number : " + num);

			notify();

			isEvenPrinted = true;

		}

	}
	
	public static void main(String[] args) {
		OddEvenPrinter o = new OddEvenPrinter();
		EvenNumberPrinter e = new EvenNumberPrinter(o);
		OddNumberPrinter op = new OddNumberPrinter(o);
		
		e.start();
		op.start();
		
		
	}

}
