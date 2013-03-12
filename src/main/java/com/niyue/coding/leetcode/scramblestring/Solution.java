package com.niyue.coding.leetcode.scramblestring;

import java.util.HashMap;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_87
// use DP, O(n*n*m) where n is the length of the first string and m is the length of the second string, but it is still too slow to pass the large data set
public class Solution {
    private Map<String, Boolean> result;

    public boolean isScramble(String s, String t) {
    	result = new HashMap<String, Boolean>();
        return isScramble(s.toCharArray(), 0, s.length() - 1, t.toCharArray(), 0, t.length() - 1);   
    }

    private boolean isScramble(char[] s, int ss, int se, char[] t, int ts, int te) {
        boolean isScramble = s[ss] == t[ts];
        String key = String.format("%s-%s-%s", ss, se, ts);
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
                isScramble(s, ss, ss + i - 1, t, ts, ts + i - 1) && 
                isScramble(s, ss + i, se, t, ts + i, te) ||
                isScramble(s, ss, ss + i - 1, t, te - i + 1, te) && 
                isScramble(s, ss + i, se, t, ts, te - i);
        }
        return isScramble;    
    }
}