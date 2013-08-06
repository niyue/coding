package com.niyue.coding.misc.validparenthesis;

/*
 * Check if a given string contains valid parenthesis in it.
 * Loop is not allowed in the implementation, only recusion is allowed.
 * "()" yes
 * ")(" no
 * "(abcd(e)" no
 * "(a)(b)" yes
 * 
 * Use a variable to keep the number of open parenthesis
 */
public class ValidParenthesis {
	private boolean isValid = true;
	
	public boolean isValid(String expression) {
		isValid(expression, 0, 0);
		return isValid;
	}
	
	private void isValid(String expression, int start, int open) {
		if(start < expression.length()) {
			if(expression.charAt(start) == '(') {
				isValid(expression, start + 1, open + 1);
			} else if(expression.charAt(start) == ')') {
				if(open > 0) {
					isValid(expression, start + 1, open - 1);
				} else {
					isValid = false;
					return;
				}
			} else {
				isValid(expression, start + 1, open);
			}
		}
	}
}
