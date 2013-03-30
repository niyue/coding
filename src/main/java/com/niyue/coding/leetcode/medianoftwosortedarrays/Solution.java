package com.niyue.coding.leetcode.medianoftwosortedarrays;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        return median(A, 0, A.length - 1, B, 0, B.length - 1);           
    }

    private double median(int[] A, int startA, int endA, int B[], int startB, int endB) {
        int midA = startA + (endA - startA) / 2;
        int midB = startB + (endB - startB) / 2;
        double median = 0;
        if(startA > endA) {
            median = median(B, startB, endB);
        } else if(startB > endB) {
            median = median(A, startA, endA);
        } else if(startA == endA || startB == endB) {
            median = (A[midA] + B[midB]) / 2.0;
        } else {
            if(A[midA] >= B[midB]) {
                median = median(A, startA, midA, B, midB, endB);
            } else {
                median = median(A, midA, endA, B, startB, midB);
            }
        }
        return median;
    }

    private double median(int[] C, int start, int end) {
        int mid = start + (end - start) / 2;
        return (end - start) % 2 == 0 ? C[mid] : (C[mid] + C[mid + 1]) / 2.0;
    }
}
