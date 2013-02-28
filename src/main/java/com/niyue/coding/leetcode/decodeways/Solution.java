package com.niyue.coding.leetcode.decodeways;

// http://leetcode.com/onlinejudge#question_91
// DP with O(n)
public class Solution {
    public int numDecodings(String string) {
        char[] s = string.toCharArray();
        int[] ways = new int[s.length];
        for(int i = 0; i < s.length; i++) {
            if(i == 0) {
                if(s[i] == '0') {
                    ways[s.length - 1] = 0;
                    break;
                } else {
                    ways[i] = 1;
                }
            } else if(i == 1) {
                int n = getEncodedNumber(s, i);
                if(n > 0 && n <= 10 || n == 20) {
                    ways[i] = 1;
                } else if(n % 10 == 0) {
                    ways[s.length - 1] = 0;
                    break;    
                } else if(n > 26) {
                    ways[i] = 1;  
                } else {
                    ways[i] = 2;
                }
            } else {
                int n = getEncodedNumber(s, i);
                if(n > 0 && n <= 10 || n == 20) {
                    ways[i] = ways[i - 2];
                } else if(n % 10 == 0) {
                    ways[s.length - 1] = 0;
                    break;    
                } else if(n > 26) {
                    ways[i] = ways[i - 1];  
                } else {
                    ways[i] = ways[i - 2] + ways[i - 1];
                }
            }       
        }
        return ways.length == 0 ? 0 : ways[s.length - 1];
    }
    
    private int getEncodedNumber(char[] s, int i) {
        return (s[i - 1] - '0') * 10 + (s[i] - '0');    
    }
}
