package com.niyue.coding.leetcode.trappingrainwater;

import java.util.Deque;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_42
public class Solution {
    public int trap(int[] A) {
        int[] leftMax = leftMax(A);
        int[] rightMax = rightMax(A);
        int water = 0;
        for(int i = 1; i < A.length - 1; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            if(left != -1 && right != -1) {
                int height = Math.min(A[left], A[right]) - A[i];
                water += height;
            }
        }        
        return water;
    }

    private int[] leftMax(int[] A) {
        int[] max = new int[A.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < A.length; i++) {
            if(stack.isEmpty() || A[i] >= A[stack.peekFirst()]) {
                stack.clear();
                stack.addFirst(i);
                max[i] = -1;
            } else {
                max[i] = stack.peekFirst();
            }
        }
        return max;
    }

    private int[] rightMax(int[] A) {
        int[] max = new int[A.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = A.length - 1; i >= 0; i--) {
            if(stack.isEmpty() || A[i] >= A[stack.peekFirst()]) {
                stack.clear();
                stack.addFirst(i);
                max[i] = -1;
            } else {
                max[i] = stack.peekFirst();
            }
        }
        return max;
    }
}
