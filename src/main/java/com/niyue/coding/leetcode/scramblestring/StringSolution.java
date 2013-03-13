package com.niyue.coding.leetcode.scramblestring;

// http://leetcode.com/onlinejudge#question_87
// not use DP at all, and this solution is too slow to pass the large data set
public class StringSolution {
	public boolean isScramble(String s, String t) {
        boolean isScramble = s.charAt(0) == t.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            isScramble = isScramble(s, t, i);
            if(isScramble) {
                break;
            }
        }
        return isScramble;
    }

    private boolean isScramble(String s, String t, int i) {
        boolean isScramble = false;
        if(s.length() == 1) {
            isScramble = s.equals(t);
        } else {
            isScramble = 
                isScramble(s.substring(0, i), t.substring(0, i)) && 
                isScramble(s.substring(i), t.substring(i)) ||
                isScramble(s.substring(0, i), t.substring(t.length() - i)) && 
                isScramble(s.substring(i), t.substring(0, t.length() - i));
        }
        return isScramble;
    }
}
