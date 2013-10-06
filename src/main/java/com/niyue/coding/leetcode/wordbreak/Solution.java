package com.niyue.coding.leetcode.wordbreak;

import java.util.Set;

/*
 * seg(i, j) denotes if s[i, j] is segmentable
 * seg(i, j) = for any k between i..j, dict.contains(s[i, k]) && seg[k + 1, j]
 * O(n^4) solution using DP
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[][] segmentable = new boolean[s.length() + 1][s.length() + 1];        
        segmentable[s.length()][s.length()] = true;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = s.length(); j >= i; j--) {
                for(int k = i; k < j; k++) {
                    String word = s.substring(i, k + 1);    
                    if(segmentable[k + 1][j] && dict.contains(word)) {
                        segmentable[i][j] = true;
                        break; 
                    }    
                }
            }
        }
        return segmentable[0][s.length()];
    }
}