package com.niyue.coding.leetcode.graycode;

import java.util.ArrayList;

// http://leetcode.com/onlinejudge#question_89
// generate gray code sequence
// the Nth gray code = N ^ (N >> 1)
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> codes = new ArrayList<Integer>();
        int size = 1 << n;
        for(int i = 0; i < size; i++) {
            codes.add(i ^ (i >> 1));
        }
        return codes;
    }
}
