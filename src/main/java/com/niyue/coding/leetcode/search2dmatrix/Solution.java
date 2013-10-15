package com.niyue.coding.leetcode.search2dmatrix;

/*
 * http://oj.leetcode.com/problems/search-a-2d-matrix/
 * http://leetcode.com/onlinejudge#question_74
 * search a sorted 2D matrix using binary search
 * This matrix has the following properties:
 * 1) Integers in each row are sorted from left to right.
 * 2) The first integer of each row is greater than the last integer of the previous row.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        if(matrix.length > 0) {
            int xLen = matrix[0].length;
            int yLen = matrix.length;
            int start = 0;
            int end = xLen * yLen - 1;
            while(start <= end) {
                int mid = start + (end - start) / 2;
                int midX = mid % xLen;
                int midY = mid / xLen;
                int midValue = matrix[midY][midX];
                if(midValue == target) {
                    found = true;
                    break;
                } else if(midValue > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return found;
    }
}
