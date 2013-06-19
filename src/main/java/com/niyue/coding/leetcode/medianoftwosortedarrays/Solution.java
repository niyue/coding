package com.niyue.coding.leetcode.medianoftwosortedarrays;


public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        return findMedian(A, 0, A.length - 1, B, 0, B.length - 1);
    }
    
    private double findMedian(int[] A, int startA, int endA, int[] B, int startB, int endB) {
        double median = 0;
        int lengthA = endA - startA + 1;
        int lengthB = endB - startB + 1;
        int midA = startA + (endA - startA) / 2;
        int midB = startB + (endB - startB) / 2;
        if(lengthA == 1 && lengthB == 1) {
            median = (A[midA] + B[midB]) / 2.0;
        } else if(lengthA == 0) {
            median = median(B, startB, endB);
        } else if(lengthB == 0) {
            median = median(A, startA, endA);
        } else {
            if(A[midA] == B[midB]) {
            	boolean hasOddLength = lengthA % 2 != 0 || lengthB % 2 != 0;
            	if(hasOddLength) {
            		median = A[midA];
            	} else {
            		median = (A[midA] + Math.min(A[midA + 1], B[midB + 1])) / 2.0;
            	}
            } else if(A[midA] < B[midB]) {
            	int firstHalfLengthA = (lengthA - 1) / 2;
            	int secondHalfLengthB = (lengthB + 1) / 2;
        		if(firstHalfLengthA < secondHalfLengthB) {
        			median = findMedian(A, midA, endA, B, startB, endB - firstHalfLengthA);    
        		} else {
        			median = findMedian(A, startA + secondHalfLengthB, endA, B, startB, midB);
        		}
            } else {
            	int firstHalfLengthB = (lengthB - 1) / 2;
            	int secondHalfLengthA = (lengthA + 1) / 2;
            	if(firstHalfLengthB < secondHalfLengthA) {
            		median = findMedian(A, startA, endA - firstHalfLengthB, B, midB, endB);    
            	} else {
            		median = findMedian(A, startA, midA, B, startB + secondHalfLengthA, endB);
            	}
            }    
        }
       
        return median;
    }    

    private double median(int[] X, int start, int end) {
        boolean isEven = (end - start + 1) % 2 == 0;
        int mid = start + (end - start) / 2;
        double median = 0;
        if(isEven) {
            median = (X[mid] + X[mid + 1]) / 2.0;
        } else {
            median = X[mid];
        }
        return median;
    }
}
