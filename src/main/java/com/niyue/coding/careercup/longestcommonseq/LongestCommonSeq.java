package com.niyue.coding.careercup.longestcommonseq;


public class LongestCommonSeq {
	public int lcs(String s1, String s2) {
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Integer[][] result = new Integer[chars1.length][chars2.length];
		return lcs(chars1, chars2, chars1.length - 1, chars2.length - 1, result);
	}
	
	private int lcs(char[] s1, char[] s2, int end1, int end2, Integer[][] result) {
		int lcs = 0;
		if(end1 >= 0 && end2 >= 0) {
			if(result[end1][end2] == null) {
				if(s1[end1] == s2[end2]) {
					lcs = lcs(s1, s2, end1 - 1, end2 - 1, result);
				} else {
					int lcs1 = lcs(s1, s2, end1 - 1, end2, result);
					int lcs2 = lcs(s1, s2, end1, end2 - 1, result);
					lcs = Math.max(lcs1, lcs2);
				}
				result[end1][end2] = lcs;
			} else {
				lcs = result[end1][end2];
			}
		}
		return lcs;
	}
}
