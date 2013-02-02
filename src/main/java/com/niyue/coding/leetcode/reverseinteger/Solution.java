package com.niyue.coding.leetcode.reverseinteger;

// http://leetcode.com/onlinejudge#question_7
public class Solution {
    public int reverse(int x) {
        boolean positive = true;
        if(x < 0) {
            positive = false; 
            x = -1 * x;
        }
        String integerString = Integer.valueOf(x).toString();
        String reversed = new StringBuilder(integerString).reverse().toString();
        int rx = Integer.valueOf(reversed);
        return positive ? rx : rx * -1;
    }
}
