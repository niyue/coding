package com.niyue.coding.leetcode.search2dmatrix;

// http://leetcode.com/onlinejudge#question_74
// search a sorted 2D matrix using binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, target);           
    }

    private boolean binarySearch(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
        int len = matrix[0].length;
        int start = y1 * len + x1;
        int end = y2 * len + x2;
        boolean found = false;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int midX = mid % len;
            int midY = mid / len;
            if(target > matrix[midY][midX]) {
                start = mid + 1;
            } else if(target == matrix[midY][midX]) {
                found = true;
                break;
            } else {
                end = mid - 1;
            }
        }
        return found;
    }
}
