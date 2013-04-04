package com.niyue.coding.leetcode.alphanumericpalindrome;

// http://leetcode.com/onlinejudge#question_125
public class Solution {
	public boolean isPalindrome(String s) {
		String string = s.toLowerCase();
		string = alphaNumerize(string);
		int length = string.length();
		if (length < 2) {
			return true;
		}
		int left = 0;
		int right = 0;
		if (isOdd(length)) {
			left = length / 2 - 1;
			right = (length + 1) / 2;
		} else {
			left = length / 2 - 1;
			right = length / 2;
		}
		while (left >= 0) {
			char leftChar = string.charAt(left);
			char rightChar = string.charAt(right);
			if (leftChar != rightChar) {
				return false;
			}
			left--;
			right++;
		}
		return true;
	}

	private boolean isOdd(int length) {
		return length % 2 != 0;
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
