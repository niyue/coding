package com.niyue.coding.leetcode.pascaltriangleii;

import java.util.ArrayList;

public class SolutionTwo {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            row = next(row);
        }
        return row;
    }
    
    private ArrayList<Integer> next(ArrayList<Integer> row) {
        ArrayList<Integer> next = new ArrayList<Integer>();
        for(int i = 0, prev = 0; i < row.size(); i++) {
            next.add(prev + row.get(i));
            prev = row.get(i);
        }
        next.add(1);
        return next;
    }
}
