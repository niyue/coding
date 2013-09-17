package com.niyue.coding.leetcode.editdistance;

/*
 * http://oj.leetcode.com/problems/edit-distance/
 * Bottom up DP solution for the edit distance problem. O(n^2).
 * Declare a two dimensional array with one extra length to eliminate many edge case checking.
 * Base case: f(i, 0) = i, f(0, j) = j
 */
public class SolutionTwo {
    private char[] A;
    private char[] B;
    
    public int minDistance(String word1, String word2) {
        this.A = word1.toCharArray();
        this.B = word2.toCharArray();
        return editDistance(A.length, B.length);
    }
    
    private int editDistance(int lengthA, int lengthB) {
        int[][] distances = new int[lengthA + 1][lengthB + 1];
        
        for(int i = 0; i <= lengthA; i++) {
            distances[i][0] = i;
        }
        
        for(int j = 0; j <= lengthB; j++) {
            distances[0][j] = j;
        }
        
        for(int i = 1; i <= lengthA; i++) {
            for(int j = 1; j <= lengthB; j++) {
                if(A[i - 1] == B[j - 1]) {
                    distances[i][j] = distances[i - 1][j - 1];    
                } else {
                    distances[i][j] = Math.min(
                        Math.min(distances[i - 1][j], distances[i][j - 1]), distances[i - 1][j - 1]
                    ) + 1;
                }
            }
        }
        return distances[lengthA][lengthB];
    }
}
