package com.niyue.coding.interviewstreet.candies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int N;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        int[] ratings = getInput();
        
        int[] candies = candies(ratings);
        
        System.out.println(sum(candies));
    }
    
    /**
     * For three adjacent seats, there are nine different scenarios for their ratings (1,2,3 means their relative rating):
     * 1,2,3 | 1,2,2 | 1,2,1
     * 1,1,2 | 1,1,1 | 2,2,1
     * 2,1,2 | 2,1,1 | 3,2,1
     */
    private int[] candies(int[] ratings) {
    	List<Integer> lowestPositions = lowestPositions(ratings);
    	int[] candies = new int[N];
    	
    	for(int i : lowestPositions) {
    		candies[i] = 1;
    	}
    	
    	int lowest = 0;
    	for(int i=0;i<N;i++) {
    		int ri = i + 1;
    		if(candies[i] == 1) {
    			lowest++;
    		} else {
    			if(ratings[ri] > ratings[ri-1]) {
    				candies[i] = candies[i-1] + 1;
    				if(ratings[ri] > ratings[ri+1]) {
    					int candyByLowest = lowestPositions.get(lowest) - i + 1;
    					candies[i] = Math.max(candies[i], candyByLowest);
    				}
    			} else {
    				candies[i] = lowestPositions.get(lowest) - i + 1;
    			}
    		}
    	}
    	
    	return candies;
    }
    
    /** 
     * All lowest positions will just get 1 candy  
     */
    private List<Integer> lowestPositions(int[] ratings) {
    	List<Integer> lowestPositions = new ArrayList<Integer>();
    	for(int i=1;i<=N;i++) {
    		if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]) {
    			lowestPositions.add(i-1);
    		}
    	}
    	return lowestPositions;
    }
    
    private long sum(int[] candies) {
    	long sum = 0;
    	for(int i=0;i<N;i++) {
    		sum += candies[i];
    	}
    	return sum;
    }

    private int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[] ratings = new int[N+2];
        ratings[0] = Integer.MAX_VALUE;
        ratings[N+1] = Integer.MAX_VALUE;
        
        for(int i=1;i<=N;i++) {
        	ratings[i] = scanner.nextInt();
        }
        scanner.close();
        return ratings;
    }
}
