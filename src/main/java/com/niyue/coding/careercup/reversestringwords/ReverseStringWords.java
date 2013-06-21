package com.niyue.coding.careercup.reversestringwords;

// http://www.geeksforgeeks.org/reverse-words-in-a-given-string/
public class ReverseStringWords {
	public String reverse(String string) {
		String[] words = string.split(" ");
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < words.length; i++) {
			if(i > 0) {
				builder.append(" ");
			}
			builder.append(reverseWord(words[i]));
		}
		return reverseWord(builder.toString());
	}
	
	private String reverseWord(String word) {
		return new StringBuilder(word).reverse().toString();
	}
}
