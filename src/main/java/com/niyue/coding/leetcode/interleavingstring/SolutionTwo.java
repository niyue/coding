package com.niyue.coding.leetcode.interleavingstring;

/*
 * http://oj.leetcode.com/problems/interleaving-string/
 * Bottom up dynamic programming solution with O(s1 * s2) time/space complexity
 */
public class SolutionTwo {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean isInterleave = false;
        if(s1.length() + s2.length() == s3.length()) {
            boolean[][] interleaving = new boolean[s1.length() + 1][s2.length() + 1];
            interleaving[0][0] = true;
 
            for(int i = 0; i <= s1.length(); i++) {
                for(int j = 0; j <= s2.length(); j++) {
                    int i3 = i + j - 1;
                    if(i > 0 && s1.charAt(i - 1) == s3.charAt(i3)) {
                        interleaving[i][j] = interleaving[i - 1][j]; 
                    }
                    if(j > 0 && s2.charAt(j - 1) == s3.charAt(i3)) {
                        interleaving[i][j] |= interleaving[i][j - 1];    
                    }    
                }
            }
            isInterleave = interleaving[s1.length()][s2.length()];
        }
        return isInterleave;
    }
}
