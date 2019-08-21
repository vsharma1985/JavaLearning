package tddProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {

	@Test
	void testifInstanceIsNotNull() {
		PalindromeChecker checker = new PalindromeChecker();
		
		assertNotNull(checker);
	}
	@Test
	void testIfStringIsPalindrom() {
		PalindromeChecker checker = new PalindromeChecker();
		boolean value =checker.isPalindrome("MOM");
		assertEquals(Boolean.TRUE,value);
	}
	@Test
	void testIfStringIsNOTPalindrom() {
		PalindromeChecker checker = new PalindromeChecker();
		boolean value =checker.isPalindrome("BALF");
		assertEquals(Boolean.FALSE,value);
	}

	@Test
	void testIfStringIsEmptyPalindrom() {
		PalindromeChecker checker = new PalindromeChecker();
		boolean value =checker.isPalindrome("");
		assertEquals(Boolean.FALSE,value);
	}
}
