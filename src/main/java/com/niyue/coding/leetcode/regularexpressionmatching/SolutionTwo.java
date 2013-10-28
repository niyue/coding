package com.niyue.coding.leetcode.regularexpressionmatching;

/*
 * http://oj.leetcode.com/problems/regular-expression-matching/
 * A solution that is more easier to understand since the logic for handling '.' and normal char is pretty similar 
 * Solution described here http://discuss.leetcode.com/questions/175/regular-expression-matching is much more simpler
 */
public class SolutionTwo {
	public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);            
    }
    
    private boolean isMatch(char[] s, int si, char[] p, int pi) {
        boolean isMatch = false;
        if(pi == p.length) {
            isMatch = si == s.length;
        } else {
            if(p[pi] == '.') {
                if(pi == p.length - 1 || p[pi + 1] != '*') {
                    isMatch = isMatch(s, si + 1, p, pi + 1);
                } else {
                    isMatch = isMatch(s, si, p, pi + 2);
                    for(int i = si; !isMatch && i < s.length; i++) {
                        isMatch = isMatch(s, i + 1, p, pi + 2);
                    }     
                }
            } else {
                if(pi == p.length - 1 || p[pi + 1] != '*') {
                	// si < s.length is needed to handle "ab"/"abc*" case
                    isMatch = si < s.length && s[si] == p[pi] && isMatch(s, si + 1, p, pi + 1);   
                } else {
                    isMatch = isMatch(s, si, p, pi + 2);
                    for(int i = si; !isMatch && i < s.length && s[i] == p[pi]; i++) {
                        isMatch = isMatch(s, i + 1, p, pi + 2);
                    }    
                }
            }
        }
        return isMatch;
    }
}
