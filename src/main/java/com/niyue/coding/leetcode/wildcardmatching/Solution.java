package com.niyue.coding.leetcode.wildcardmatching;

// http://leetcode.com/onlinejudge#question_44
// wildcard matching using recursion and back tracking, but is too slow to pass the large data set
public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    private boolean isMatch(char[] s, int si, char[] p, int pi) {
        boolean isMatch = false;
        if(pi == p.length) {
            isMatch = si == s.length;
        } else {
            if(p[pi] == '?') {
                isMatch = isMatch(s, si + 1, p, pi + 1);
            } else if(p[pi] == '*') {
                for(int i = 0; i <= s.length - si; i++) {
                    if(isMatch(s, si + i, p, pi + 1)) {
                        isMatch = true;
                        break;
                    }
                }
            } else {
                if(si < s.length) {
                    isMatch = s[si] == p[pi] ? isMatch(s, si + 1, p, pi + 1) : false;
                }
            }
        }
        return isMatch;
    }
}
