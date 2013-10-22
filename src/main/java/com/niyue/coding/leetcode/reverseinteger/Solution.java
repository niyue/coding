package com.niyue.coding.leetcode.reverseinteger;

// http://leetcode.com/onlinejudge#question_7
public class Solution {
    public int reverse(int x) {
        String integerString = Integer.valueOf(Math.abs(x)).toString();
        String reversed = new StringBuilder(integerString).reverse().toString();
        int rx = Integer.valueOf(reversed);
        return x > 0 ? rx : -rx;
    }
}
