package com.niyue.coding.leetcode.palindromepartitionii;

/*
 * minCut(i) = min(each (i, end) is palindrome, mc(end + 1)) + 1
 * Bottom up DP with O(n^2) time complexity and space comlexity 
 */
public class SolutionTwo {
    private int N;
    public int minCut(String s) {
        N = s.length();
        boolean[][] palindromes = allPalindromes(s);
        return minCut(0, palindromes);
    }
    
    private int minCut(int start, boolean[][] palindromes) {
        int[] cuts = new int[N + 1];
        cuts[N] = -1; // NOTE: cuts[N] is set to -1 because a palindrome itself like "aba" requires 0 cut, so that -1 + 1 will be zero
        for(int i = N - 1; i >= 0; i--) {
            int minCut = Integer.MAX_VALUE;
            for(int j = i; j < N; j++) {
                if(palindromes[i][j]) {
                    if(cuts[j + 1] + 1 < minCut) {
                        minCut = cuts[j + 1] + 1;
                    }
                }
            }
            cuts[i] = minCut;
        }
        return cuts[0];
    }
    
    private boolean[][] allPalindromes(String s) {
        boolean[][] palindromes = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int start = i, end = i; start >= 0 && end < s.length(); start--, end++) {
        		if(s.charAt(start) == s.charAt(end)) {
            	    palindromes[start][end] = true;
            	} else {
            	    break;
            	}
            }
            for(int start = i, end = i + 1; start >= 0 && end < s.length(); start--, end++) {
        		if(s.charAt(start) == s.charAt(end)) {
            	    palindromes[start][end] = true;
            	} else {
            	    break;
            	}
            }
        }
        return palindromes;
    }
}
