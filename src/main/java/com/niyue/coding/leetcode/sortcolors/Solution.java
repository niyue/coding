package com.niyue.coding.leetcode.sortcolors;

// http://leetcode.com/onlinejudge#question_75
// three-way Dutch national flag sorting
public class Solution {
    public void sortColors(int[] A) {
        dutchNationalFlagSort(A, 1, 1);              
    }

    private void dutchNationalFlagSort(int[] A, int low, int high) {
        int pl = 0;
        int ph = A.length - 1;
        for(int i = 0; i <= ph;) {
            if(A[i] < low) {
                swap(A, i, pl);
                pl++;
                i++;
            } else if(A[i] > high) {
                swap(A, i, ph);
                ph--;
            } else {
                i++;
            }
        }          
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
