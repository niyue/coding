package com.niyue.coding.leetcode.wildcardmatching;

/*
 * http://oj.leetcode.com/problems/wildcard-matching/
 * O(|s|*|p|*|s|) top down DP solution, too slow to pass the large data set 
 */
public class SolutionTwo {
	private Boolean[][] cache;
	
	public boolean isMatch(String s, String p) {
		cache = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);        
    }
	
	private boolean isMatch(char[] s, int si, char[] p, int pi) {
        boolean isMatch = false;
        if(cache[si][pi] != null) {
            isMatch = cache[si][pi];
        } else {
            if(pi == p.length) {
                isMatch = si == s.length;
            } else {
                if(p[pi] != '*') {
                    isMatch = si < s.length && (p[pi] == '?' || s[si] == p[pi]) && isMatch(s, si + 1, p, pi + 1);
                } else {
                    isMatch = isMatch(s, si, p, pi + 1);
                    for(int i = si; !isMatch && i < s.length; i++) {
                        isMatch = isMatch(s, i + 1, p, pi + 1);
                    }
                }
            }   
            cache[si][pi] = isMatch;
        }
        
        return isMatch;
    }
}
