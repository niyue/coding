package com.niyue.coding.leetcode.largesthistogram;

// http://leetcode.com/onlinejudge#question_84
// An O(n^2) solution, too slow to pass large data set
public class Solution {
    public int largestRectangleArea(int[] height) {
        int largestArea = 0;
        for(int i = 0; i < height.length; i++) {
            int width = 1;
            for(int j = i - 1; j >= 0 && height[j] >= height[i]; j--) {
            	width++;
            } 
            for(int j = i + 1; j < height.length && height[j] >= height[i]; j++) {
                width++;
            }
            int area = height[i] * width;
            if(area > largestArea) {
                largestArea = area;
            }
        }
        return largestArea;
    }
}
