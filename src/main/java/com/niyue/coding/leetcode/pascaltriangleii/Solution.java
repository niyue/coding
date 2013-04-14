package com.niyue.coding.leetcode.pascaltriangleii;

import java.util.ArrayList;
import java.util.Collections;

// http://leetcode.com/onlinejudge#question_119
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> current = new ArrayList<Integer>(Collections.singletonList(1));
        for(int i = 0; i < rowIndex; i++) {
            current = next(current);
        }
        return current;
    }

    private ArrayList<Integer> next(ArrayList<Integer> prev) {
        ArrayList<Integer> next = new ArrayList<Integer>(prev.size() + 1);
        for(int i = 0; i <= prev.size(); i++) {
            next.add(i == 0 || i == prev.size() ? 1 : prev.get(i - 1) + prev.get(i));
        }
        return next;
    }
}
