package com.niyue.coding.leetcode.rotateimage;

/*
 * Rotate matrix to 90/180/270 degrees
 * http://www.careercup.com/question?id=14891673
 * In place matrix transpose
 * http://www.careercup.com/question?id=12339553
 */
public class MatrixRotation {
	public void rotate(int[][] matrix) {
        for(int y = 0; y < matrix.length; y++) {
            for(int x = 0; x < y; x++) {
                swap(matrix, x, y, y, x);    
            }
        }        

        for(int y = 0; y < matrix.length; y++) {
            for(int x = 0; x < matrix[y].length / 2; x++) {
                swap(matrix, x, y, matrix[y].length - 1 - x, y);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[y1][x1];
        matrix[y1][x1] = matrix[y2][x2];
        matrix[y2][x2] = temp;
    }
}
