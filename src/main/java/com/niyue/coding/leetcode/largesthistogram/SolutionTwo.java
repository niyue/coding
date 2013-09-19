package com.niyue.coding.leetcode.largesthistogram;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * A much simpler implementation for this problem, modified from http://discuss.leetcode.com/questions/259/largest-rectangle-in-histogram/789
 * Use a stack, for each index in the array
 * 	1) if its height is bigger than the top of the stack, push it into the stack
 * 	2) else we need to pop items from the stack until the current height is larger than the top of the stack
 * 		during popping each item out of the stack
 * 			its previous item in the stack is the nearest height smaller than it
 * 			and the current height is popped item's next height smaller
 * 			and this forms a rectangle area, calculate its are and compare it with max
 * This algorithm is O(n) because each item will be pushed into and popped out of the stack at most once.    
 */
public class SolutionTwo {
    public int largestRectangleArea(int[] height) {
        List<Integer> heights = convert(height);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.size(); i++) {
            int newHeight = heights.get(i);
            while(!stack.isEmpty() && heights.get(stack.peekFirst()) > newHeight) {
                int topHeight = heights.get(stack.pollFirst());
                int prev = stack.isEmpty() ? -1 : stack.peekFirst();
                int width = i - prev - 1;
                int area = topHeight * width;
                if(area > max) {
                    max = area;
                }
            }
            stack.offerFirst(i);
        }
        return max;
    }
    
    private List<Integer> convert(int[] height) {
        List<Integer> heights = new ArrayList<Integer>();
        for(int h : height) {
            heights.add(h);
        }
        heights.add(0);// sentinel
        return heights;
    }
}
