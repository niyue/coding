package com.niyue.coding.leetcode.pascaltriangle;

import java.util.ArrayList;

// http://oj.leetcode.com/problems/pascals-triangle/
// 9 minutes
public class SolutionTwo {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i < numRows; i++) {
            row = next(row);
            solution.add(row);    
        }
        
        return solution;
    }
    
    private ArrayList<Integer> next(ArrayList<Integer> row) {
        ArrayList<Integer> next = new ArrayList<Integer>();
        int prev = 0;
        for(int i = 0; i < row.size(); i++) {
            next.add(prev + row.get(i));
            prev = row.get(i);
        }
        next.add(1);
        return next;
    }
}
