package com.niyue.coding.careercup.longestcommonseq;


// longest common subsequence problem
// bottom up approach DP to calculate both the length and LCS string
public class LongestCommonSeq {
	public String lcs(String s1, String s2) {
		return lcs(s1.toCharArray(), s2.toCharArray());
	}
	
	private String lcs(char[] s1, char[] s2) {
		Char[][] lcs = new Char[s1.length][s2.length];
		for(int i = 0; i < s1.length; i++) {
			for(int j = 0; j < s2.length; j++) {
				if(i == 0 && j == 0) {
					lcs[i][j] = s1[i] == s2[j] 
							? new Char(-1, -1, s1[i], 1) 
							: new Char(-1, -1, Character.MIN_VALUE, 0);
				} else if(i == 0 || j == 0) { 
					lcs[i][j] = s1[i] == s2[j] 
							? new Char(-1, -1, s1[i], 1) 
							: i == 0 ? lcs[i][j - 1] : lcs[i - 1][j];
				} else {
					lcs[i][j] = s1[i] == s2[j] 
							? new Char(i - 1, j - 1, s1[i], lcs[i - 1][j - 1].length + 1)
							: (lcs[i - 1][j].length > lcs[i][j - 1].length 
								? new Char(i - 1, j, Character.MIN_VALUE, lcs[i - 1][j].length)
								: new Char(i, j - 1, Character.MIN_VALUE, lcs[i][j - 1].length));
				}
			}
		}
		Char current = lcs[s1.length - 1][s2.length - 1];
		StringBuilder seq = new StringBuilder();
		while(current != null && current.length > 0) {
			if(Character.MIN_VALUE != current.c) {
				seq.append(current.c);
			}
			current = current.x >= 0 && current.y >= 0 ? lcs[current.x][current.y] : null;
		}
		return seq.reverse().toString();
	}
	
	private static class Char {
		public final int x;
		public final int y;
		public final char c;
		public final int length;
		public Char(int x, int y, char c, int length) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.length = length;
		}
	}
}
