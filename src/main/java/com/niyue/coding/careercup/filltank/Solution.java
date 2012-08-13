package com.niyue.coding.careercup.filltank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * you are given following:
 * 1. An empty tank
 * 2. Unlimited source of water.
 * 3. Some container of certain measurements and a container of 1 liter is always given.
 * Your job is to fill the tank from source of water using the containers in minimum number of steps.
 * You can't fill the container with a small amount of water than its size (filling partially is not allowed).
 * Find the number of steps and print the solution.
 * e.g. Tank Size: 80 liter
 * Containers: 1,3,5,6,25 liter
 * Solution:
 * 4
 * 5,25,25,25
 */
class Solution {
	private int N;
	
	private Map<Integer, Integer> stepsForTarget = new HashMap<Integer, Integer>();
	private Map<Integer, List<Integer>> solutions = new HashMap<Integer, List<Integer>>();
	
    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
    	int[] capacities = getInput();
    	solutions.put(0, Collections.<Integer>emptyList());
    	int steps = fill(N, capacities);
    	System.out.println(steps);
    	//System.out.println(solutions.get(N));
    }
    
    private int fill(int target, int[] capacities) {
    	if(target == 0) {
    		return 0;
    	} else if(target < 0) {
    		return Integer.MAX_VALUE;
    	} else {
    		int minSteps = Integer.MAX_VALUE;
    		if(stepsForTarget.containsKey(target)) {
    			minSteps = stepsForTarget.get(target);
    		} else {
    			for(int c : capacities) {
    				int steps = fill(target - c, capacities);
    				if(steps < minSteps) {
    					minSteps = steps;
    					List<Integer> solution = new ArrayList<Integer>(solutions.get(target - c));
    					solution.add(c);
    					solutions.put(target, solution);
    				}
    			}
    			minSteps = 1 + minSteps;
    			stepsForTarget.put(target, minSteps);
    		}
    		return minSteps;
    	}
    }
    
    private int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] capacities = new int[M];
        for(int i=0;i<M;i++) {
        	capacities[i] = scanner.nextInt();
        }
        return capacities;
    }
}
