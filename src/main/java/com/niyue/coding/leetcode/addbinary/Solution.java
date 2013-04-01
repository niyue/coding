package com.niyue.coding.leetcode.addbinary;


// http://leetcode.com/onlinejudge#question_67
// add two binary numbers, one submission to pass all tests
public class Solution {
    public String addBinary(String a, String b) {
        char[] one = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
        char[] two = a.length() >= b.length() ? b.toCharArray() : a.toCharArray();
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i = one.length - 1; i >= 0; i--) {
            int j = i + two.length - one.length;
            int sum = (one[i] - '0') + (j < 0 ? 0 : two[j] - '0') + carry;
            result.append(sum % 2);
            carry = sum >> 1;
        }
        if(carry > 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
}
