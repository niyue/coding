package com.niyue.coding.leetcode.zigzagconversion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// http://leetcode.com/onlinejudge#question_6
public class Solution {
    private static final int UP = -1;
    private static final int DOWN = 1;

    public String convert(String s, int nRows) {
        List<Queue<Character>> rows = new ArrayList<Queue<Character>>(nRows);
        for(int i = 0; i < nRows; i++) {
            rows.add(new ArrayDeque<Character>());
        }

        int rowId = 0;
        int direction = DOWN;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            rows.get(rowId).offer(c);
            if(nRows == 1) {
            } else if(nRows == 2) {
                rowId = rowId == 1 ? 0 : 1;
            } else if(direction == DOWN && rowId == nRows - 1) {
                direction = UP;
                rowId = nRows - 2;    
            } else if(direction == UP && rowId == 1) {
                direction = DOWN;
                rowId = 0; 
            } else {
                rowId += direction;   
            }
        }

        StringBuilder o = new StringBuilder();
        for(Queue<Character> row : rows) {
            for(Character c : row) {
                o.append(c);
            }
        }
        return o.toString();
    }
}
