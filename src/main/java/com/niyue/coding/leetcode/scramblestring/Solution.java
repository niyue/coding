package com.niyue.coding.leetcode.scramblestring;

import java.util.HashMap;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_87
// use DP, O(n^4), and add some more checking to ensure at least the child nodes have the same number for each character they have before doing the recursion
public class Solution {
    private Map<String, Boolean> result;

    public boolean isScramble(String s, String t) {
    	result = new HashMap<String, Boolean>();
        return isScramble(s.toCharArray(), 0, s.length() - 1, t.toCharArray(), 0, t.length() - 1);   
    }

    private boolean isScramble(char[] s, int ss, int se, char[] t, int ts, int te) {
        boolean isScramble = s[ss] == t[ts];
        String key = String.format("%s-%s-%s", ss, ts, se - ss);
        if(result.containsKey(key)) {
            isScramble = result.get(key);
        } else {
            for(int i = 1; i < se - ss + 1; i++) {
                isScramble = isScramble(s, ss, se, t, ts, te, i);
                if(isScramble) {
                    break;
                }
            }
            result.put(key, isScramble);
        }
        
        return isScramble;
    }

    private boolean isScramble(char[] s, int ss, int se, char[] t, int ts, int te, int i) {    
        boolean isScramble = false;
        if(ss == se) {
            isScramble = s[ss] == t[ts];
        } else {
            isScramble = 
            	isCharMatched(s, ss, t, ts, i) && 
            	isCharMatched(s, ss + i, t, ts + i, se - ss - i + 1) &&
                isScramble(s, ss, ss + i - 1, t, ts, ts + i - 1) && 
                isScramble(s, ss + i, se, t, ts + i, te) ||
                
                isCharMatched(s, ss, t, te - i + 1, i) && 
            	isCharMatched(s, ss + i, t, ts, se - ss - i + 1) &&
                isScramble(s, ss, ss + i - 1, t, te - i + 1, te) && 
                isScramble(s, ss + i, se, t, ts, te - i);
        }
        return isScramble;    
    }
    
    // for s[ss..ss+length] and t[ts..ts+length], verify if these two strings have the same number of characters for each character
    private boolean isCharMatched(char[] s, int ss, char[] t, int ts, int length) {
    	Map<Integer, Integer> charCount = new HashMap<Integer, Integer>();
    	for(int i = 0; i < length; i++) {
    		Integer charValue = (int) s[ss+i];
    		if(!charCount.containsKey(charValue)) {
    			charCount.put(charValue, 0);
    		}
    		charCount.put(charValue, charCount.get(charValue) + 1);
    	}
    	boolean matched = true;
    	for(int i = 0; i < length; i++) {
    		Integer charValue = (int) t[ts+i];
    		if(!charCount.containsKey(charValue)) {
    			matched = false;
    			break;
    		} else {
    			charCount.put(charValue, charCount.get(charValue) - 1);
    			if(charCount.get(charValue) == 0) {
    				charCount.remove(charValue);
    			}
    		}
    	}
    	return matched;
    }
}