package com.niyue.coding.leetcode.searchinsertpoint;

import java.util.Arrays;

/*
 * http://oj.leetcode.com/problems/search-insert-position/
 */
public class SolutionTwo {
    public int searchInsert(int[] A, int target) {
        int pos = Arrays.binarySearch(A, target);
        // Arrays.binarySearch returns (- insertion point - 1) when not found
        return pos >= 0 ? pos : -(pos + 1);
    }
}
