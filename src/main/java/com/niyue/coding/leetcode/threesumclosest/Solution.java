package com.niyue.coding.leetcode.threesumclosest;

import java.util.Arrays;

// http://leetcode.com/onlinejudge#question_16
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = 0;
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++) {
            int targetTwoSum = target - num[i];
            int start = i + 1;
            int end = num.length - 1;
            while(start < end) {
                int currentTwoSum = num[start] + num[end];
                int gap = Math.abs(currentTwoSum - targetTwoSum);
                if(gap < closest) {
                    closest = gap;
                    result = num[i] + currentTwoSum;
                }
                if(currentTwoSum == targetTwoSum) {
                    return result;
                } else if(currentTwoSum < targetTwoSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }   
        return result;     
    }
}
