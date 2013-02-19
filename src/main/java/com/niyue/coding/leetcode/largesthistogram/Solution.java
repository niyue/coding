package com.niyue.coding.leetcode.largesthistogram;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_84
// An O(n) solution to the problem, use a stack to pre-process the histogram to get an array of nearest smaller bar for each position 
public class Solution {
    public int largestRectangleArea(int[] height) {
        int[] leftNearestSmallerBars = nearestSmallerBars(height, false);
        int[] rightNearestSmallerBars = nearestSmallerBars(height, true);
        
        int largestRectangleArea = 0;
        for(int i = 0; i < height.length; i++) {
            int leftNearestSmallerBar = leftNearestSmallerBars[i];
            int rightNearestSmallerBar = rightNearestSmallerBars[i];
            int width = rightNearestSmallerBar - leftNearestSmallerBar - 1;
            int area = height[i] * width;
            if(largestRectangleArea < area) {
                largestRectangleArea = area;
            } 
        }
        return largestRectangleArea;
    }
    
    private int[] nearestSmallerBars(int[] height, boolean reversed) {
        if(reversed) {
            height = reverse(height);
        }
        int[] nearestSmallerBars = new int[height.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < height.length; i++) {
        	int nearestSmallerBarIndex = -1;
        	while(!stack.isEmpty()) {
    			int top = stack.peekFirst();
    			if(height[top] >= height[i]) {
    				stack.removeFirst();  
    			} else {
    				nearestSmallerBarIndex = top;
    				break;
    			}
    		}
        	stack.addFirst(i);
        	
	        if(reversed) {
	            nearestSmallerBars[height.length - 1 - i] = height.length - 1 - nearestSmallerBarIndex;
	        } else {
	            nearestSmallerBars[i] = nearestSmallerBarIndex;
	        }
        }
        return nearestSmallerBars;
    }
    
    private int[] reverse(int[] height) {
        int[] reversedHeight = Arrays.copyOf(height, height.length);
        for(int i = 0; i < reversedHeight.length / 2; i++) {
            int temp = reversedHeight[i];
            reversedHeight[i] = reversedHeight[reversedHeight.length - 1 - i];
            reversedHeight[reversedHeight.length - 1 - i] = temp;
        }
        return reversedHeight;
    }  
}
