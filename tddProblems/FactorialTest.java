package tddProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	void testIfInstanceNotNull() {
		FactorialCalc fact = new FactorialCalc();
		assertNotNull(fact);
		
	}
	
	@Test
	void testIfNumberisZero() {
		FactorialCalc fact = new FactorialCalc();
		int result = fact.calculateFactorial(0);
		assertEquals(1, result);;
		
	}
	
	
	@Test
	void testIfNumberisNotZero() {
		FactorialCalc fact = new FactorialCalc();
		int result = fact.calculateFactorial(4);
		assertEquals(24, result);;
		
	}

}
