package tddProblems;

public class PalindromeChecker {

	public boolean isPalindrome(String string) {
		
		
		if(!string.isEmpty()) {
			
			StringBuffer revStr = new StringBuffer(string);
			
			if(string.equals(revStr.reverse().toString())) {
				return true;
			}
		}
		
		return false;
		
		
	}

}
