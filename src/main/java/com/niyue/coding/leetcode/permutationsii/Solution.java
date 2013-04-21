package com.niyue.coding.leetcode.permutationsii;

import java.util.ArrayList;
import java.util.Arrays;

// http://leetcode.com/onlinejudge#question_47
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	Arrays.sort(num);
    	return permute(num);
    }

    private ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
    	int[] permutation = num;
    	while(permutation != null) {
    		permutations.add(asList(permutation));
    		permutation = nextPermutation(permutation);
    	}
    	return permutations;
    }

    private int[] nextPermutation(int[] permutation) {
    	boolean hasNext = false;
    	for(int i = permutation.length - 2; i >= 0; i--) {
    		if(permutation[i] < permutation[i + 1]) {
    			hasNext = true;
    			int swap = swapIndex(permutation, i);
    			swap(permutation, i, swap);
    			reverse(permutation, i + 1, permutation.length - 1);
    			break;
    		}
    	}
    	return hasNext ? permutation : null;
    }
    
    private void reverse(int[] permutation, int start, int end) {
    	for(int i = 0; i <= (end - start) / 2; i++) {
    		swap(permutation, start + i, end - i);
    	}
    }
    
    private void swap(int[] permutation, int i, int j) {
    	int temp = permutation[j];
    	permutation[j] = permutation[i];
    	permutation[i] = temp;
    }

    private int swapIndex(int[] permutation, int index) {
    	int swap = permutation.length - 1;
    	while(permutation[swap] <= permutation[index]) {
    		swap--;
    	}
    	return swap;
    }

    private ArrayList<Integer> asList(int[] num) {
    	ArrayList<Integer> numbers = new ArrayList<Integer>();
    	for(int n : num) {
    		numbers.add(n);
    	}
    	return numbers;
    }
}
