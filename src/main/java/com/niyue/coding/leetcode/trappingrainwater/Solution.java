package com.niyue.coding.leetcode.trappingrainwater;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int trap(int[] A) {
        int[] leftBigger = leftNearestBigger(A);
        int[] rightBigger = rightNearestBigger(A);
        int water = 0;
        for(int i = 1; i < A.length - 1; i++) {
            int left = leftBigger[i];
            int right = rightBigger[i];
            if(left != -1 && right != -1) {
                int width = right - left - 1;
                int height = Math.min(A[left], A[right]) - A[i];
                water += width * height;
                System.out.println(width * height);
            }
        }        
        return water;
    }

    private int[] leftNearestBigger(int[] A) {
        int[] leftBigger = new int[A.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < A.length; i++) {
            while(!stack.isEmpty()) {
                if(A[i] >= A[stack.peekFirst()]) {
                    stack.removeFirst();
                } else {
                    leftBigger[i] = stack.peekFirst();
                    break;
                }
            }           
            if(stack.isEmpty()) {
                leftBigger[i] = -1;
            }
            stack.addFirst(i);
        }
        return leftBigger;
    }

    private int[] rightNearestBigger(int[] A) {
        int[] rightBigger = new int[A.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = A.length - 1; i >= 0; i--) {
            while(!stack.isEmpty()) {
                if(A[i] >= A[stack.peekFirst()]) {
                    stack.removeFirst();
                } else {
                    rightBigger[i] = stack.peekFirst();
                    break;
                }
            }           
            if(stack.isEmpty()) {
                rightBigger[i] = -1;
            }
            stack.addFirst(i);
        }
        return rightBigger;
    }
}
