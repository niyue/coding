package com.niyue.coding.careercup.longestcommonseq;


// longest common subsequence problem
// bottom up approach DP to calculate the length of LCS
public class LongestCommonSeq {
	public String lcs(String s1, String s2) {
		return lcs(s1.toCharArray(), s2.toCharArray());
	}
	
	private String lcs(char[] s1, char[] s2) {
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
		StringBuilder seq = new StringBuilder();
		int x = s1.length - 1;
		int y = s2.length - 1;
		while(x >= 0 && y >= 0 && lcs[x][y] > 0) {
			if(x == 0) {
				seq.append(s1[x]);
				break;
			} else if(y == 0) {
				seq.append(s2[y]);
				break;
			}
			if(lcs[x][y] == lcs[x - 1][y]) {
				x--;
			} else if(lcs[x][y] == lcs[x][y - 1]) {
				y--;
			} else {
				seq.append(s1[x]);
				x--;
				y--;
			}
		}
		return seq.reverse().toString();
	}
}
