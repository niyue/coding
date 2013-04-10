package com.niyue.coding.leetcode.maximalrectangle;

// http://leetcode.com/onlinejudge#question_85
// An O(n^3) solution to this problem, which is too slow to pass the large data set
public class Solution {
    private int[][] count;
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length > 0) {
        	count = continuousOneCells(matrix);
        	
        	for(int i = 0; i < matrix.length; i++) {
        		for(int j = 0; j < matrix[i].length; j++) {
        			int maxAreaForCell = maxArea(matrix, j, i);
        			if(maxAreaForCell > max) {
        				max = maxAreaForCell;
        			}
        		}
        	}        
        	
        }
        return max;
    }

    private int maxArea(char[][] matrix, int x, int y) {
        int width = Integer.MAX_VALUE;
        int max = 0;
        for(int i = y; i < matrix.length; i++) {
            int height = i + 1 - y;
            width = Math.min(count[i][x], width);
            int area = height * width;
            if(area > max) {
                max = area;
            }
        }    
        return max;
    }

    private int[][] continuousOneCells(char[][] matrix) {
        int[][] count = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            count[i][matrix[i].length - 1] = matrix[i][matrix[i].length - 1] == '1' ? 1 : 0;
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = matrix[i].length - 2; j >= 0; j--) {
                count[i][j] = matrix[i][j] == '1' ? 1 + count[i][j + 1] : 0;
            }
        } 
        return count;
    }
}
