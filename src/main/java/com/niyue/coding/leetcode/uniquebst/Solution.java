package com.niyue.coding.leetcode.uniquebst;

// http://leetcode.com/onlinejudge#question_96
public class Solution {
    public int numTrees(int n) {
        int count = 0;
        if(n < 2) {
            count = 1;
        } else {
            for(int i = 0; i < n; i++) {
                int leftCount = numTrees(i);
                int rightCount = numTrees(n - i - 1);
                count += leftCount * rightCount;
            }
        }   
        return count;     
    }
}
