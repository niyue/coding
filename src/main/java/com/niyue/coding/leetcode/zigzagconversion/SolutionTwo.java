package com.niyue.coding.leetcode.zigzagconversion;

/*
 * http://oj.leetcode.com/problems/zigzag-conversion/
 * the initial gap between two elements in first row is nRows + (nRows - 2)
 * Iterate each row, the gap in this row is lastRowGap - 2
 * Except last row, whose gap should be the same as initial gap instead of 0
 */
public class SolutionTwo {
    public String convert(String s, int nRows) {
        StringBuilder b = new StringBuilder();
        if(nRows == 1) {
        	b.append(s);
        } else {
        	int maxGap = nRows + (nRows - 2);
        	int gap = maxGap;
        	for(int r = 0; r < nRows; r++) {
        		if(r == nRows - 1) {
        			gap = maxGap;
        		}
        		for(int p = r; p < s.length(); p += gap) {
        			b.append(s.charAt(p));
        		}
        		gap -= 2;
        	}
        }
        return b.toString();
    }
}
