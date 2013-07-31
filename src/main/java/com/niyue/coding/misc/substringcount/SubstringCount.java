package com.niyue.coding.misc.substringcount;

// Given two strings text and pattern, count the number of times string pattern appears in string text, the characters can be overlapped
// for example, text="ababa", pattern="aba", return 2
// use KMP, O(|text| + |pattern|)
public class SubstringCount {
	public int count(String text, String pattern) {
		int[] b = preprocess(pattern);
		int count = search(text, pattern, b);
		return count;
	}
	
	private int[] preprocess(String pattern) {
		int[] b = new int[pattern.length() + 1];
		int i = 0;
		int j = -1;
		b[0] = j;
		while(i < pattern.length()) {
			while(j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
		return b;
	}
	
	private int search(String text, String pattern, int[] b) {
		int count = 0;
		int i = 0;
		int j = 0;
		while(i < text.length()) {
			while(j >= 0 && text.charAt(i) != pattern.charAt(j)) {
				j = b[j];
			}
			i++;
			j++;
			if(j == pattern.length()) {
				count++;
				j = b[j];
			}
		}
		return count;
	}
}
