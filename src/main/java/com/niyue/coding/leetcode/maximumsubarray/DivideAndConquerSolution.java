package com.niyue.coding.leetcode.maximumsubarray;

// http://leetcode.com/onlinejudge#question_53
// O(nlgn), a divide and conquer solution for max sum array problem, too slow to pass the large data set
public class DivideAndConquerSolution {
	public int maxSubArray(int[] A) {
		return maxSubArray(A, 0, A.length - 1);
    }
	
	private int maxSubArray(int[] A, int start, int end) {
		int max = Integer.MIN_VALUE;
		if(start == end) {
			max = A[start];
		} else {
			int mid = start + (end - start) / 2;
			int leftMaxSum = maxSubArray(A, start, mid);
			int rightMaxSum = maxSubArray(A, mid + 1, end);
			int midMaxSum = maxCrossMid(A, mid);
			max = Math.max(Math.max(leftMaxSum, rightMaxSum), midMaxSum);
		}
		return max;
	}
	
	// left max sum and right max sum can be computed independently
	private int maxCrossMid(int[] A, int mid) {
		int leftMax = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = mid; i >= 0; i--) {
			sum += A[i];
			if(sum > leftMax) {
				leftMax = sum;
			}
		}
		
		int rightMax = Integer.MIN_VALUE;
		sum = 0;
		for(int i = mid + 1; i < A.length; i++) {
			sum += A[i];
			if(sum > rightMax) {
				rightMax = sum;
			}
		}
		return leftMax + rightMax;
	}
}
