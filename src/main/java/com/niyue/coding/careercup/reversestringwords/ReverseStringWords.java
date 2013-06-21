package com.niyue.coding.careercup.reversestringwords;

// http://www.geeksforgeeks.org/reverse-words-in-a-given-string/
// An inplace implementation that uses a simple state machine to scan through the characters
public class ReverseStringWords {
	private final int NOT_IN_WORD = -1;
	private final int IN_WORD = 1;
	
	public String reverse(String string) {
		char[] chars = string.toCharArray();
		char[] reversedChars = reverse(chars);
		return new String(reversedChars);
	}
	
	private char[] reverse(char[] chars) {
		int start = 0;
		int end = 0;
		int status = NOT_IN_WORD;
		for(int i = 0; i < chars.length; i++) {
			if(status == NOT_IN_WORD) {
				if(!Character.isWhitespace(chars[i])) {
					status = IN_WORD;
					start = i;
				}
			} else {
				if(Character.isWhitespace(chars[i])) {
					status = NOT_IN_WORD;
					end = i - 1;
					reverse(chars, start, end);
				}
			}
		}
		
		if(status == IN_WORD) {
			reverse(chars, start, chars.length - 1);
		}
		
		return reverse(chars, 0, chars.length - 1);
	}
	
	private char[] reverse(char[] chars, int start, int end) {
		int mid = start + (end - start) / 2;
		for(int i = start; i <= mid; i++) {
			swap(chars, i, end - i + start);
		}
		return chars;
	}
	
	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
