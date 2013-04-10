package com.niyue.coding.leetcode.removeduplicateii;

// http://leetcode.com/onlinejudge#question_80
public class Solution {
    public int removeDuplicates(int[] A) {
        int s = -1;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(i == 0 || A[i] != A[s]) {
                s++;
                count = 1;
                A[s] = A[i];
            } else if(count == 1) {
                s++;
                count = 0;   
                A[s] = A[i];
            }
        }
        return s + 1;        
    }
}
