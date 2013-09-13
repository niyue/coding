package com.niyue.coding.leetcode.alphanumericpalindrome;

// http://leetcode.com/onlinejudge#question_125
/*
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 */
public class Solution {
	public boolean isPalindrome(String s) {
		String string = s.toLowerCase();
		string = alphaNumerize(string);
		int length = string.length();
		
		for(int i = 0; i < length / 2; i++) {
			char leftChar = string.charAt(i);
			char rightChar = string.charAt(length - 1 - i);
			if (leftChar != rightChar) {
				return false;
			}
		}
		return true;
	}

	private String alphaNumerize(String s) {
		StringBuilder builder = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (isAlphabet(c) || isNumeric(c)) {
				builder.append(c);
			}
		}
		return builder.toString();
	}

	private boolean isAlphabet(char c) {
		int diff = c - 'a';
		return diff >= 0 && diff < 26;
	}

	private boolean isNumeric(char c) {
		int diff = c - '0';
		return diff >= 0 && diff <= 9;
	}
}
