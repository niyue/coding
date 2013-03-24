package com.niyue.coding.leetcode.maximumsubarray;

// http://leetcode.com/onlinejudge#question_53
// standard max sum subarray problem
public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum > maxSum) {
                maxSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }        
        return maxSum;
    }
}
