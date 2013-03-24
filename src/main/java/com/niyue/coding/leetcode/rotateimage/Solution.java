package com.niyue.coding.leetcode.rotateimage;

// http://leetcode.com/onlinejudge#question_48
public class Solution {
    public void rotate(int[][] matrix) {
        int width = matrix.length;
        if(width > 0) {
            int level = (width + 1) / 2;
            for(int i = 0; i < level; i++) {
                rotate(matrix, i);
            }
        }        
    }

    private void rotate(int[][] matrix, int L) {
        int W = matrix.length - L * 2 - 1;
        for(int i = 0; i < W; i++) {
            int topLeft = matrix[L][L + i];
            matrix[L][L + i] = matrix[L + W - i][L];
            matrix[L + W - i][L] = matrix[L + W][L + W - i];
            matrix[L + W][L + W - i] = matrix[L + i][L + W];
            matrix[L + i][L + W] = topLeft;
        }
    }
}
