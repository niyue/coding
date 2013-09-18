package com.niyue.coding.leetcode.palindromenumber;

// Determine whether an integer is a palindrome. Do this without extra space.
// http://leetcode.com/onlinejudge#question_9
public class Solution {
    public boolean isPalindrome(int x) {
        int y = 0;
        int n = x;
        while(n > 0) {
            y *= 10;
            y += n % 10;
            n /= 10;
        }
        return x == y;
    }
}
