package com.niyue.coding.leetcode.regularexpressionmatching;

// http://leetcode.com/onlinejudge#question_10
// regular expression matching, understand the problem incorrectly and solved another problem 
// Instead of matching any number of any character, '*' matches zero or more of the preceding element
public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    private boolean isMatch(char[] s, int si, char[] p, int pi) {
        boolean isMatch = false;
        // pattern reaches its end
        if(pi == p.length) {
            isMatch = si == s.length;
        } else {
            if(pi + 1 < p.length && p[pi + 1] == '*') {
                if(p[pi] == '.') {
                    for(int i = si; i <= s.length; i++) {
                        if(isMatch(s, i, p, pi + 2)) {
                            isMatch = true;
                            break;
                        }
                    }
                } else {
                    int maxMatch = count(s, si, p[pi]);
                    for(int i = 0; i <= maxMatch; i++) {
                        if(isMatch(s, si + i, p, pi + 2)) {
                            isMatch = true;
                            break;
                        }
                    }
                }
            } else if(p[pi] == '.') {
                isMatch = isMatch(s, si + 1, p, pi + 1);
            } else {
            	// text reaches its end and the remaining pattern is not wildcard
            	if(si < s.length) {
            		isMatch = s[si] == p[pi] ? isMatch(s, si + 1, p, pi + 1) : false;
            	}
            }
        }
        return isMatch;
    }
    
    // count how many times pchar appears in s from si, namely, the maximum possible matched characters for pattern x*
    private int count(char[] s, int si, char pchar) {
    	int maxMatch = 0;
        for(int i = si; i < s.length; i++) {
            if(s[i] == pchar) {
                maxMatch++;
            } else {
                break;
            }
        }
        return maxMatch;
    }
}