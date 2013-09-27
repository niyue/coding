package com.niyue.coding.leetcode.spiralmatrix;

import java.util.ArrayList;

/*
 * http://oj.leetcode.com/problems/spiral-matrix/
 * A new solution for spiral order of a matrix
 * Use two variables (m and n) to keep track of width and height of the spiral, and decrease width and height during traversing the spiral
 */
public class SolutionTwo {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> order = new ArrayList<Integer>();
        int n = matrix.length;
        if(n > 0) {
            int m = matrix[0].length;
            int size = n * m;
            
            int x = -1;
            int y = 0;
            for(int i = 1; i <= size;) {
                for(int r = 0; r < m && i <= size; r++, i++) {
                    x++;
                    order.add(matrix[y][x]);
                }
                n--;
                for(int d = 0; d < n && i <= size; d++, i++) {
                    y++;
                    order.add(matrix[y][x]);
                }
                m--;
                for(int l = 0; l < m && i <= size; l++, i++) {
                    x--;
                    order.add(matrix[y][x]);
                }
                n--;
                for(int u = 0; u < n && i <= size; u++, i++) {
                    y--;
                    order.add(matrix[y][x]);
                }
                m--;
            }   
        }
        
        return order;
    }
}