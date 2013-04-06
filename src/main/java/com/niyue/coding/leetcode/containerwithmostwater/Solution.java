package com.niyue.coding.leetcode.containerwithmostwater;

import java.util.ArrayList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_11
// O(nlgn) solution
public class Solution {
    public int maxArea(int[] height) {
        int[] left = mostDistantLeftMax(height);
        int[] right = mostDistantRightMax(height);
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {
            int current = height[i];
            if(left[i] >= 0) {
                int area = current * (i - left[i]);
                if(area > maxArea) {
                    maxArea = area;
                }
            }

            if(right[i] >= 0) {
                int area = current * (right[i] - i);
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }       
        return maxArea;     
    }

    private int[] mostDistantLeftMax(int[] height) {
        int[] mostDistantLeftMax = new int[height.length];
        List<Integer> maxIndexes = new ArrayList<Integer>();
        List<Integer> maxValues = new ArrayList<Integer>();
        for(int i = 0; i < height.length; i++) {
            int maxValueIndex  = binarySearch(maxValues, height[i]);
            mostDistantLeftMax[i] = maxValueIndex >= 0 ? maxIndexes.get(maxValueIndex) : -1;
            if(maxIndexes.isEmpty() || !maxIndexes.isEmpty() && height[i] > height[maxIndexes.get(maxIndexes.size() - 1)]) {
                maxIndexes.add(i);
                maxValues.add(height[i]);
            }
        }
        return mostDistantLeftMax;
    }

    private int[] mostDistantRightMax(int[] height) {
        int[] mostDistantRightMax = new int[height.length];
        List<Integer> maxIndexes = new ArrayList<Integer>();
        List<Integer> maxValues = new ArrayList<Integer>();
        for(int i = height.length - 1; i >= 0; i--) {
            int maxValueIndex  = binarySearch(maxValues, height[i]);
            mostDistantRightMax[i] = maxValueIndex >= 0 ? maxIndexes.get(maxValueIndex) : -1;
            if(maxIndexes.isEmpty() || !maxIndexes.isEmpty() && height[i] > height[maxIndexes.get(maxIndexes.size() - 1)]) {
                maxIndexes.add(i);
                maxValues.add(height[i]);
            }
        }
        return mostDistantRightMax;
    }
    
    private int binarySearch(List<Integer> values, int target) {
    	int start = 0;
    	int end = values.size() - 1;
    	int index = -1;
    	while(start <= end) {
    		int mid = start + (end - start) / 2;
    		if(values.get(mid) < target) {
    			start = mid + 1;
    		} else {
    			index = mid;
    			end = mid - 1;
    		}
    	}
    	return index;
    }
}
