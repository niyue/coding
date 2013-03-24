package com.niyue.coding.leetcode.graycode;

import java.util.ArrayList;

// http://leetcode.com/onlinejudge#question_89
// generate gray code sequence
// the Nth gray code = N ^ (N >> 1)
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        long total = (long) Math.pow(2, n);
        ArrayList<Integer> grayCodes = new ArrayList<Integer>();
        for(long i = 0; i < total; i++) {
            int code = (int) (i ^ (i >> 1));
            grayCodes.add(code);
        }
        return grayCodes;
    }
}
