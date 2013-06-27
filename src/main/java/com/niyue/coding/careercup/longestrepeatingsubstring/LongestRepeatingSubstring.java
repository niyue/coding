package com.niyue.coding.careercup.longestrepeatingsubstring;

// http://www.careercup.com/question?id=13227715
// O(n^2) solution to find the longest repeating substring using partial match function in KMP
// basically, for each starting index possible, compute the partial match array for string[startIndex, end]
// for each partial match array, find the max length width border
public class LongestRepeatingSubstring {
	public String search(String s) {
		int longestStart = 0;
		int longestEnd = -1;
		int maxLen = 0;
		for(int j = 0; j < s.length(); j++) {
			if(maxLen < s.length() - j) {
				int[] b = partialMatch(s.substring(j).toCharArray());
				for(int i = b.length - 1; i > 0; i--) {
					if(b[i] > maxLen) {
						longestStart = j;
						longestEnd = j + b[i];
						maxLen = b[i];
					}
				}
			} else {
				break;
			}
		}
		return s.substring(longestStart, longestEnd);
	}
	
	private int[] partialMatch(char[] chars) {
		int i = 0;
		int j = -1;
		int[] b = new int[chars.length + 1];
		b[0] = j;
		while(i < chars.length) {
			while(j >= 0 && chars[i] != chars[j]) {
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
		return b;
	}
}
