package com.niyue.coding.leetcode.wildcardmatching;

import java.util.ArrayList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_44
// wildcard matching using memoization to cache the results, but ran into memory limit exceed issue
// try Map<Integer, Map<Integer, Boolean>> matched but got time limit exceeded issue
public class Solution {
	private Boolean[][] matched; 
    public boolean isMatch(String s, String p) {
    	char[] pattern = removeContinousStars(p.toCharArray());
    	matched = new Boolean[s.length() + 1][pattern.length + 1];
        return isMatch(s.toCharArray(), 0, pattern, 0);
    }
    
    private boolean isMatch(char[] s, int si, char[] p, int pi) {
    	boolean isMatch = false;
    	if(si <= s.length && pi <= p.length && matched[si][pi] != null) {
    		isMatch = matched[si][pi];
    	} else {
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
    		if(si <= s.length && pi <= p.length) {
    			matched[si][pi] = isMatch;
    		}
    	}
        return isMatch;
    }
    
    private char[] removeContinousStars(char[] p) {
    	List<Character> pattern = new ArrayList<Character>();
    	for(int i = 0; i < p.length; i++) {
			if(p[i] != '*' || pattern.isEmpty() || pattern.get(pattern.size() - 1) != '*') {
				pattern.add(p[i]);
			}
    	}
    	char[] pp = new char[pattern.size()];
    	for(int i = 0; i < pp.length; i++) {
    		pp[i] = pattern.get(i);
    	}
    	return pp;
    }
}
