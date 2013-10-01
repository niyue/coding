package com.niyue.coding.leetcode.permutations;

import java.util.ArrayList;

/*
 * http://oj.leetcode.com/problems/permutations/
 */
public class SolutionTwo {
    private ArrayList<ArrayList<Integer>> solutions;
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        solutions = new ArrayList<ArrayList<Integer>>();
        permute(num, 0, new ArrayList<Integer>());
        return solutions;
    }
    
    private void permute(int[] num, int i, ArrayList<Integer> solution) {
        if(i == num.length) {
            solutions.add(new ArrayList<Integer>(solution));
        } else {
            for(int j = 0; j <= i; j++) {
                ArrayList<Integer> newSolution = new ArrayList<Integer>(solution);
                newSolution.add(j, num[i]);
                permute(num, i + 1, newSolution);
            }
        }
    }
}
