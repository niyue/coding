package com.niyue.coding.leetcode.nextpermutation;

import java.util.Arrays;

// http://leetcode.com/onlinejudge#question_31
// scan from the end, find the first digit that is larger than its next higher digit
// scan from the end, swap this digit with the minimum digit that is less than it in all lower digits
// sort all the lower digits
public class Solution {
    public void nextPermutation(int[] num) {
		int firstReverseIndex = firstReverseIndex(num);   
		int fromIndex = 0;
		if(firstReverseIndex != -1) {
			int minMaxIndex = minMaxIndex(num, num[firstReverseIndex]);
			swap(num, firstReverseIndex, minMaxIndex);
			fromIndex = firstReverseIndex + 1;
		}
		Arrays.sort(num, fromIndex, num.length);
    }

    private int firstReverseIndex(int[] num) {
    	int firstIndex = -1;
    	for(int i = num.length - 1; i > 0; i--) {
    		if(num[i] > num[i - 1]) {
    			firstIndex = i - 1;
    			break;
    		}
    	}
    	return firstIndex;
    }

    private int minMaxIndex(int[] num, int target) {
    	int minMaxIndex = -1;
    	for(int i = num.length - 1; i > 0; i--) {
    		if(num[i] > target) {
    			minMaxIndex = i;
    			break;
    		}
    	}
    	return minMaxIndex;	
    }

    private void swap(int[] num, int i, int j) {
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
}
