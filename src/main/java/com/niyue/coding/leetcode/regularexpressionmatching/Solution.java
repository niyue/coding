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
        if(si == s.length && pi == p.length) {
            isMatch = true;
        } else if(si == s.length && pi != p.length || si != s.length && pi == p.length) {
            isMatch = false;
        } else {
            if(p[pi] == '.') {
                isMatch = isMatch(s, si + 1, p, pi + 1);
            } else if(p[pi] == '*') {
                for(int i = 0; i <= s.length - si; i++) {
                    if(isMatch(s, si + i, p, pi + 1)) {
                        isMatch = true;
                        break;
                    }
                }
            } else {
                isMatch = s[si] == p[pi] ? isMatch(s, si + 1, p, pi + 1) : false;
            }
        }
        return isMatch;
    }
}
