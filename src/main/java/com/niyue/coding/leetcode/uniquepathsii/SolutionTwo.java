package com.niyue.coding.leetcode.uniquepathsii;

/*
 * http://oj.leetcode.com/problems/unique-paths-ii/
 * Same O(m * n) DP solution with original implementation, but much shorter
 */
public class SolutionTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];                
        paths[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
        for(int x = n - 2; x >= 0; x--) {
            paths[m - 1][x] = obstacleGrid[m - 1][x] == 1 ? 0 : paths[m - 1][x + 1];
        }
        for(int y = m - 2; y >= 0; y--) {
            paths[y][n - 1] = obstacleGrid[y][n - 1] == 1 ? 0 : paths[y + 1][n - 1];
        }
        for(int y = m - 2; y >= 0; y--) {
            for(int x = n - 2; x >= 0; x--) {
                paths[y][x] = obstacleGrid[y][x] == 1 ? 0 : paths[y + 1][x] + paths[y][x + 1];
            }
        }
        return paths[0][0];
    }
}
