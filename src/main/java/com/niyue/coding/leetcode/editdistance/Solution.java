package com.niyue.coding.leetcode.editdistance;

// http://leetcode.com/onlinejudge#question_72
// top down approach DP, O(n^2)
public class Solution {
    private Integer[][] result;
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        result = new Integer[w1.length][w2.length];
        return minDistance(w1, w2, w1.length - 1, w2.length - 1);
    }

    private int minDistance(char[] w1, char[] w2, int i1, int i2) {
        int min = 0;
        if(i1 == i2 && i1 == -1) {
            min = 0;
        } else if(i1 == -1) {
            min = i2 + 1;
        } else if(i2 == -1) {
            min = i1 + 1;
        } else {
            if(result[i1][i2] == null) {
                if(w1[i1] == w2[i2]) {
                    min = minDistance(w1, w2, i1 - 1, i2 - 1);
                } else {
                    int insertMin = minDistance(w1, w2, i1, i2 - 1) + 1;
                    int deleteMin = minDistance(w1, w2, i1 - 1, i2) + 1;
                    int replaceMin = minDistance(w1, w2, i1 - 1, i2 - 1) + 1;
                    min = Math.min(Math.min(insertMin, deleteMin), replaceMin);
                }    
                result[i1][i2] = min;
            } else {
                min = result[i1][i2];
            }
        } 
        return min;
    }
}
