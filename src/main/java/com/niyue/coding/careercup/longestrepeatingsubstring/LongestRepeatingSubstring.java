package com.niyue.coding.careercup.longestrepeatingsubstring;

// http://www.careercup.com/question?id=13227715
public class LongestRepeatingSubstring {
	public String search(String s) {
		int[] b = partialMatch(s.toCharArray());
		int longest = 0;
		for(int i = b.length - 1; i > 0; i--) {
			if(i % 2 == 0 && b[i] >= i / 2) {
				longest = i;
				break;
			}
		}
		return s.substring(0, longest);
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
