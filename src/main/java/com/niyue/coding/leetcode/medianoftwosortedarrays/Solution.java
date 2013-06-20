package com.niyue.coding.leetcode.medianoftwosortedarrays;

// A very ugly solution that contains too many branches to solve different edge cases and more important, it has some edge cases unsolved yet, 2026/2058 tests passed
// A solution in MIT handout should be used, which seems more clean
// http://www2.myoops.org/course_material/mit/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf 
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
            	int secondHalfLengthB = lengthB / 2;
            	boolean isEven = (lengthA + lengthB) % 2 == 0;
            	if(lengthA == 1) {
            		if(isEven) {
            			median = (Math.max(B[midB - 1], A[midA]) + B[midB]) / 2.0;
            		} else {
            			median = B[midB];
            		}
            	} else if(lengthA == 2) {
            		if(isEven) {
            			if(A[midA + 1] <= B[midB]) {
            				if(midB > 0) {
            					median = (Math.max(B[midB - 1], A[midA + 1]) + B[midB]) / 2.0;
            				} else {
            					median = (A[midA + 1] + B[midB]) / 2.0;
            				}
            			} else {
            				median = (Math.min(B[midB + 1], A[midA + 1]) + B[midB]) / 2.0;
            			}
            		} else {
            			if(A[midA + 1] <= B[midB]) {
            				if(midB == 0) {
            					median = A[midA + 1];
            				} else {
            					median = Math.max(A[midA + 1], B[midB - 1]);
            				}
            			} else {
            				median = B[midB];
            			}
            		}
            	} else if(lengthB == 1) {
            		if(isEven) {
            			median = (Math.min(B[midB], A[midA + 1]) + A[midA]) / 2.0;
            		} else {
            			median = Math.min(B[midB], A[midA + 1]);
            		}
            	} else if(lengthB == 2) {
            		if(isEven) {
            			if(B[midB] <= A[midA + 1] && B[midB + 1] <= A[midA + 1]) {
            				median = (B[midB] + B[midB + 1]) / 2.0;
            			} else if(A[midA + 1] <= B[midB] && A[midA + 2] <= B[midB]) {
            				median = (A[midA + 1] + A[midA + 2]) / 2.0;
            			} else {
            				median = (B[midB] + A[midA + 1]) / 2.0;
            			}
            		} else {
            			median = Math.min(B[midB], A[midA + 1]);
            		}
            	} else {
            		if(firstHalfLengthA < secondHalfLengthB) {
            			median = findMedian(A, midA, endA, B, startB, endB - firstHalfLengthA);    
            		} else {
            			median = findMedian(A, startA + secondHalfLengthB, endA, B, startB, midB);
            		}
            	}
            } else {
            	median = findMedian(B, startB, endB, A, startA, endA);
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
