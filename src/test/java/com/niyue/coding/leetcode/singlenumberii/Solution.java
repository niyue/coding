package com.niyue.coding.leetcode.singlenumberii;

/*
 * http://oj.leetcode.com/problems/single-number-ii/
 * Same problem as careercup.tripletimes
 */
public class Solution {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for(int n : A) {
            two |= one & n;
            one ^= n;
            three = one & two;
            one = one & (~three);
            two = two & (~three);
        }
        return one;
    }
}
