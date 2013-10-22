package com.niyue.coding.leetcode.removeelement;

/*
 * http://oj.leetcode.com/problems/remove-element/
 */
public class SolutionTwo {
    public int removeElement(int[] A, int elem) {
        int j = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != elem) {
                A[j] = A[i];
                j++;
            }
        }
        return j;
    }
}
