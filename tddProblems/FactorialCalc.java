package tddProblems;

public class FactorialCalc {

	public int calculateFactorial(int number) {
		
		if(number==0) {
			return 1;
		}
				return  number*calculateFactorial(number-1);
		
	}

}
