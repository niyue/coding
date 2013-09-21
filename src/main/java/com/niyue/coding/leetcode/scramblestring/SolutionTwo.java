package com.niyue.coding.leetcode.scramblestring;

/*
 *  http://oj.leetcode.com/problems/scramble-string/
 *  A much simpler solution, O(n^4) bottom up DP
 *  f(i, j, k) denotes from index i in S1, index j in S2, a substring with length k:
 *  if S1[i, i + k - 1] is scramble string of S2[j, j + k - 1]
 *  
 *  length k substring can be separated into two substrings, with length l and length k - l
 *  
 *  DP recurrence formula:
 *  f(i, j, k) = 
 *  	for l each 1...k
 *  		f(i, j, l) && f(i + l, j + l, k - l) ||
 *  		f(i, j + k - l, l) && f(i + l, j, k - l)
 */
public class SolutionTwo {
    private String s1;
    private String s2;
    private int N;
    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.N = s1.length();
        return isScramble();
    }
    
    private boolean isScramble() {
        boolean[][][] scramble = new boolean[N][N][N + 1];      
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                scramble[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int i = N - 1; i >= 0; i--) {
            for(int j = N - 1; j >= 0; j--) {
                for(int k = 2; k <= N - i && k <= N - j; k++) {
                    boolean isScramble = false;
                    for(int l = 1; l < k; l++) {
                        if(scramble[i][j][l] && scramble[i + l][j + l][k - l] ||
                           scramble[i][j + k - l][l] && scramble[i + l][j][k - l])    {
                            isScramble = true;
                            break;
                        }
                    }
                    scramble[i][j][k] = isScramble;
                }
            }
        }
        return scramble[0][0][N];
    }
}
