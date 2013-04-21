package com.niyue.coding.leetcode.wildcardmatching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://leetcode.com/onlinejudge#question_44
// follow the solution http://discuss.leetcode.com/questions/222/wildcard-matching/435 to solve the large data set
public class Solution {
    public boolean isMatch(String s, String p) {
    	List<Character> pattern = removeContinousStars(p.toCharArray());
    	boolean isMatch = false;
    	// this is a must to pass large data set with a case that s and p each is 30k size 
    	if(s.length() >= pattern.size() - Collections.frequency(pattern, '*')) { 
    		isMatch = isMatch(s.toCharArray(), asArray(pattern));
    	}
    	return isMatch;
    }
    
    private boolean isMatch(char[] s, char[] p) {
    	boolean[] prev = null;
    	boolean[] current = null;
    	for(int pi = p.length; pi >= 0; pi--) {
    		current = new boolean[s.length + 1];
    		for(int si = s.length; si >= 0; si--) {
    			if(pi == p.length) {
    				current[si] = si == s.length;
    			} else if(si == s.length) {
    				current[si] = p[pi] == '*' && prev[si];
    			} else {
    				if(p[pi] != '*' && p[pi] != '?') {
    					current[si] = s[si] == p[pi] && prev[si + 1];
    				} else if(p[pi] == '?') {
    					current[si] = prev[si + 1];
    				} else {
    					current[si] = hasTrue(prev, si) || hasTrue(current, si + 1);
    				}
    			}
    		}
    		prev = current;
    	}
        return current[0];
    }
    
    private boolean hasTrue(boolean[] matches, int start) {
    	boolean hasTrue = false;
    	for(int i = start; i < matches.length; i++) {
    		if(matches[i]) {
    			hasTrue = true;
    			break;
    		}
    	}
    	return hasTrue;
    }
    
    private List<Character> removeContinousStars(char[] p) {
    	List<Character> pattern = new ArrayList<Character>();
    	for(int i = 0; i < p.length; i++) {
			if(p[i] != '*' || pattern.isEmpty() || pattern.get(pattern.size() - 1) != '*') {
				pattern.add(p[i]);
			}
    	}
    	return pattern;
    }
    
    private char[] asArray(List<Character> pattern) {
    	char[] pp = new char[pattern.size()];
    	for(int i = 0; i < pp.length; i++) {
    		pp[i] = pattern.get(i);
    	}
    	return pp;
    }
}