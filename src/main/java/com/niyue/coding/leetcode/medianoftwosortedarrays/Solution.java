package com.niyue.coding.leetcode.medianoftwosortedarrays;

/* A very ugly solution that contains too many branches to solve different edge cases and more important, it has some edge cases unsolved yet, 2026/2058 tests passed
 * A solution in MIT handout should be used, which seems more clean
 * http://www2.myoops.org/course_material/mit/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf
 * 
 * http://stackoverflow.com/questions/4607945/how-to-find-the-kth-smallest-element-in-the-union-of-two-sorted-arrays
 * http://stackoverflow.com/questions/4686823/given-2-sorted-arrays-of-integers-find-the-nth-largest-number-in-sublinear-time
 * Implement the solution by following the idea in MIT handout above 
 * 1) Turn this problem (finding median of two sorted arrays) into find kth number in two sorted arrays (k is from 1 to total length of two)
 * 2) To find kth number in A and B, binary search array A[l, r]
 * 		2.1) A[mid] is in ka = (mid + 1)th position in array A, so to find kth element, its position in B should be kb = (k - ka)
 * 		2.2) A[mid] should be between B[kb - 1] and B[kb] to satisfy 2.1, in this case, kth = A[mid]
 * 		2.3) if A[mid] < B[kb - 1], search right half
 * 		2.4) if A[mid] > B[kb - 1], search left half
 * 3) if kth element is not found in array A, swap A and B and binary search array B[l, r] instead
 * 
 * This problem cost me more than 16 hours to solve in total :(
 */  
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	int total = A.length + B.length;
    	double median = 0;
    	if(total % 2 == 0) {
    		int first = findKth(A, B, total / 2);
    		int second = findKth(A, B, total / 2 + 1);
    		median = (first + second) / 2.0;
    	} else {
    		median = findKth(A, B, total / 2 + 1);
    	}
    	return median;
    }
    
    private int findKth(int[] A, int[] B, int k) {
    	return findKth(A, B, 0, A.length - 1, k);
    }
    
    private int findKth(int[] A, int[] B, int l, int r, int k) {
    	int kth = 0;
    	if(l > r) {
    		kth = findKth(B, A, 0, B.length - 1, k); // kth element is not in array A, search array B instead
    	} else {
    		int mid = l + (r - l) / 2;
    		int ka = mid + 1;
    		int kb = k - ka;
    		if(kb == 0 && (B.length == 0 || A[mid] <= B[0]) || 						// if kb should be the 0th element in B
    		   kb == B.length && A[mid] >= B[kb - 1] || 							// if kb should be the B.length element in B
    		   kb > 0 && kb < B.length && A[mid] >= B[kb - 1] && A[mid] <= B[kb]) {	// if kb is in the range, and can be placed in expected position, kth is found
    			kth = A[mid];
    		} else if(kb > B.length || 										// if kb is too large, search the right half to make kb smaller
    				  kb > 0 && kb <= B.length && A[mid] < B[kb - 1]) {		// if kb is in the range, but A[mid] < B[kb - 1], search the right half
    			kth = findKth(A, B, mid + 1, r, k);
    		} else {
    			kth = findKth(A, B, l, mid - 1, k);
    		}
    	}
    	return kth;
    }
}
