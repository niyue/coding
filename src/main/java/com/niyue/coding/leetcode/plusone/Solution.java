package com.niyue.coding.leetcode.plusone;

// http://leetcode.com/onlinejudge#question_66
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if(digits[i] == 10) {
                carry = 1;
                digits[i] = 0;
            } else {
                carry = 0;
            }
        }        
        
        return carry == 1 ? oneMoreDigit(digits) : digits;
    }

    private int[] oneMoreDigit(int[] digits) {
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for(int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
