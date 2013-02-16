package com.niyue.coding.leetcode.distinctsubsequences;

// http://leetcode.com/onlinejudge#question_115
/*
 * DP recurrence: 
 * f(S[i,n-1], T[j,m-1]) = 
 * if S[i] == T[j] // if the first character of S and T matches
 * 		f(S[i+1,n-1], T[j+1,m-1]) + f(S[i+1,n-1], T[j,m-1])
 * else 
 * 		f(S[i+1,n-1], T[j,m-1])
 * Top down recursive approach won't work because one of the test case contains a 10k length string which will cause stack over flow when using recursion in Java
 */
public class Solution {
    public int numDistinct(String S, String T) {
    	int count = 0;
    	if(S.isEmpty() || T.isEmpty()) {
    		if(S.isEmpty() && T.isEmpty()) {
    			count = 1;
    		}
    	} else {
    		int[][] result = new int[S.length()][T.length()];
    		char[] sChars = S.toCharArray();
    		char[] tChars = T.toCharArray();
    		
    		for(int si = S.length() - 1; si >= 0; si--) {
    			for(int ti = T.length() - 1; ti >= 0; ti--) {
    				if(S.length() - si >= T.length() - ti) {
    					int matchCount = 0;
    					if(sChars[si] == tChars[ti]) {
    						if(ti == T.length() - 1) {
    							matchCount = 1;
    						} else {
    							matchCount = result[si + 1][ti + 1];
    						}
    					}
    					int unmatchCount = 0;
    					if(si < S.length() - 1) {
    						unmatchCount = result[si + 1][ti];
    					}
    					count = matchCount + unmatchCount;
    				} else {
    					count = 0;
    				}
                    result[si][ti] = count;
    			}
    		}
    		count = result[0][0];
    	}
        return count;
    }
}