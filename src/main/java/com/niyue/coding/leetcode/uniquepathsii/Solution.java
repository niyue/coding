package com.niyue.coding.leetcode.uniquepathsii;

// http://leetcode.com/onlinejudge#question_63
// Solved similarly with unique paths problem, using bottom up DP
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] count = new int[m][n];
        int k;
        for(k = 0; k < m; k++) {
            if(obstacleGrid[k][0] == 1) {
                break;
            }
            count[k][0] = 1;
        }
        
        for(int s = k; s < m; s++) {
            count[s][0] = 0;   
        }

        for(k = 0; k < n; k++) {
            if(obstacleGrid[0][k] == 1) {
                break;
            }
            count[0][k] = 1;
        }
        
        for(int s = k; s < n; s++) {
            count[0][s] = 0;   
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    if(obstacleGrid[i - 1][j] == 0) {
                        count[i][j] += count[i - 1][j];    
                    }
                    if(obstacleGrid[i][j - 1] == 0) {
                        count[i][j] += count[i][j - 1];    
                    }    
                }
            }
        }
        return count[m - 1][n - 1];        
    }
}
