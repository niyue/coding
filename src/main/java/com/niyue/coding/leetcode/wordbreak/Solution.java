package com.niyue.coding.leetcode.wordbreak;

import java.util.Set;

/*
 * seg(i) denotes if s[i, end] is segmentable
 * seg(i) = for any k between i..end, dict.contains(s[i, k]) && seg(k + 1)
 * O(n^3) solution using DP
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] segmentable = new boolean[s.length() + 1];        
        segmentable[s.length()] = true;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int k = i; k < s.length(); k++) {
                String word = s.substring(i, k + 1);    
                if(segmentable[k + 1] && dict.contains(word)) {
                    segmentable[i] = true;
                    break; 
                }    
            }
        }
        return segmentable[0];
    }
}