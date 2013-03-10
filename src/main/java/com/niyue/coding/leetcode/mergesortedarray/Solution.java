package com.niyue.coding.leetcode.mergesortedarray;

// http://leetcode.com/onlinejudge#question_88
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int ia = m - 1;
        int ib = n - 1;
        for(int i = m + n - 1; i >= 0; i--) {
            if(ia < 0) {
                A[i] = B[ib];
                ib--;
            } else if(ib >= 0) {
                if(A[ia] > B[ib]) {
                    A[i] = A[ia];
                    ia--;
                } else {
                    A[i] = B[ib];
                    ib--;
                }
            } else {
                break;
            }
        }        
    }
}