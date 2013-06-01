package com.niyue.coding.careercup.longestcommonseq;


// longest common subsequence problem
// bottom up approach DP to cacluate the length of LCS
public class LongestCommonSeq {
	public int lcs(String s1, String s2) {
		return lcs(s1.toCharArray(), s2.toCharArray());
	}
	
	private int lcs(char[] s1, char[] s2) {
		int[][] lcs = new int[s1.length][s2.length];
		for(int i = 0; i < s1.length; i++) {
			for(int j = 0; j < s2.length; j++) {
				if(i == 0 && j == 0) {
					lcs[i][j] = s1[i] == s2[j] ? 1 : 0;
				} else if(i == 0 || j == 0) { 
					lcs[i][j] = s1[i] == s2[j] 
							? 1 
							: i == 0 ? lcs[i][j - 1] : lcs[i - 1][j];
				} else {
					lcs[i][j] = s1[i] == s2[j] 
							? lcs[i - 1][j - 1] + 1
							: Math.max(lcs[i - 1][j], lcs[i][j - 1]); 
				}
			}
		}
		return lcs[s1.length - 1][s2.length - 1];
	}
}
