package com.niyue.coding.leetcode.longestcommonprefix;

// http://leetcode.com/onlinejudge#question_14
// a very straightforward solution, compare characters in first column for each string and then second column
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs.length > 0) {
            prefix = strs[0];
            for(int l = 0; l < strs[0].length(); l++) {
                for(int i = 1; i < strs.length; i++) {
                    if(l == strs[i].length() || strs[0].charAt(l) != strs[i].charAt(l)) {
                        prefix = strs[0].substring(0, l);
                        return prefix;
                    }
                }        
            }
        }
        return prefix;
    }
}
