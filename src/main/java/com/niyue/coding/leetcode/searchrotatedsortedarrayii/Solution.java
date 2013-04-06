package com.niyue.coding.leetcode.searchrotatedsortedarrayii;

// http://leetcode.com/onlinejudge#question_81
// a slightly modified version from the solution for arrays without duplicates in it
public class Solution {
    public boolean search(int[] A, int target) {
        return search(A, 0, A.length - 1, target) != -1;
    }
    
    private int search(int[] A, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(A[mid] < target) {
                if(isLeft(A, mid)) {
                    start = mid + 1;
                } else if(isPeak(A, mid)) {
                    return -1;
                } else {
                    int left = search(A, start, mid - 1, target);
                    int right = search(A, mid + 1, end, target);
                    return left != -1 ? left : right != -1 ? right : -1;
                }
            } else if(A[mid] == target) {
                return mid;
            } else {
                if(isLeft(A, mid) || isPeak(A, mid)) {
                    int left = search(A, start, mid - 1, target);
                    int right = search(A, mid + 1, end, target);
                    return left != -1 ? left : right != -1 ? right : -1;
                } else {
                    end = mid - 1;
                }   
            }
        }
        return -1;      
    }

    private boolean isLeft(int[] A, int i) {
        return A[i] >= A[0] && A[i] > A[A.length - 1];
    }

    private boolean isPeak(int[] A, int i) {
        return A.length > 1 && (i == 0 ? A[i] > A[i + 1] :
               i == A.length - 1 ? A[i] > A[i - 1] :
               A[i] >= A[i - 1] && A[i] > A[i + 1]);
    }
}
