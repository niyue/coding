package com.niyue.coding.leetcode.decodeways;

/*
 * http://oj.leetcode.com/problems/decode-ways/
 * O(n) DP solution
 */
public class SolutionTwo {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[chars.length + 2];
        if(chars.length > 0) {
            count[chars.length] = 1;
            for(int i = chars.length - 1; i >= 0; i--) {
            	// count single digit way for parsing
                if(chars[i] != '0') {
                    count[i] += count[i + 1];
                }
                // count double digits way for parsing
                if(i + 1 < chars.length && chars[i] != '0') {
                    int value = (chars[i] - '0') * 10 + chars[i + 1] - '0';
                    if(value >= 10 && value <= 26) {
                        count[i] += count[i + 2];
                    }
                }
            }   
        }
        return count[0];
    }
}
