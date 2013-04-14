package com.niyue.coding.leetcode.pascaltriangle;

import java.util.ArrayList;
import java.util.Collections;

// http://leetcode.com/onlinejudge#question_118
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows > 0) {
            result.add(new ArrayList<Integer>(Collections.singletonList(1)));

            for(int i = 1; i < numRows; i++) {
                ArrayList<Integer> prev = result.get(i - 1);
                result.add(next(prev));
            }
        }
        return result;
    }

    private ArrayList<Integer> next(ArrayList<Integer> prev) {
        ArrayList<Integer> next = new ArrayList<Integer>();
        for(int i = 0; i <= prev.size(); i++) {
            if(i == 0 || i == prev.size()) {
                next.add(1);
            } else {
                next.add(prev.get(i - 1) + prev.get(i));
            }
        }
        return next;
    }
}
