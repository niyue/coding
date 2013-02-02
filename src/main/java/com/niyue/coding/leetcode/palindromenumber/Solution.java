package com.niyue.coding.leetcode.palindromenumber;

// Determine whether an integer is a palindrome. Do this without extra space.
// http://leetcode.com/onlinejudge#question_9
public class Solution {
    public boolean isPalindrome(int x) {
        return x == reverse(x);
    }
    
    private int reverse(int x) {
        int reverse = 0;
        int remain = x;
        while(remain > 0) {
            int mod = remain % 10;
            remain = (remain - mod) / 10;
            reverse = reverse * 10 + mod;
        }
        return reverse;
    }
}
