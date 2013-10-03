package com.niyue.coding.leetcode.singlenumber;

/*
 * http://oj.leetcode.com/problems/single-number/
 */
public class Solution {
    public int singleNumber(int[] A) {
        int num = 0;
        for(int n : A) {
            num ^= n;
        }
        return num;
    }
}
