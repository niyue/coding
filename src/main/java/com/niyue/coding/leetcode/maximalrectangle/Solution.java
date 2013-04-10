package com.niyue.coding.leetcode.maximalrectangle;

// http://leetcode.com/onlinejudge#question_85
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                int area = visit(matrix, i, j);
                if(area > max) {
                    max = area;
                }
            }
        }               
        return max;
    }

    private int visit(char[][] matrix, int x, int y) {
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != '1') {
            return 0;
        } else {
            matrix[x][y] = 'x';
            return 1 + visit(matrix, x - 1, y) +
                       visit(matrix, x, y - 1) +
                       visit(matrix, x + 1, y) + 
                       visit(matrix, x, y + 1);
        }
    }
}
