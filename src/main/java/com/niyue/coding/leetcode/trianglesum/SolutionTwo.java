package com.niyue.coding.leetcode.trianglesum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://oj.leetcode.com/problems/triangle/
// f(y, x) = v[y][x] + min(f(y + 1, x), f(y + 1, x + 1))
public class SolutionTwo {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        List<Integer> minSum = new ArrayList<Integer>(Collections.nCopies(triangle.size() + 1, 0));
        for(int y = triangle.size() - 1; y >= 0; y--) {
            ArrayList<Integer> row = triangle.get(y);
            List<Integer> nextMinSum = new ArrayList<Integer>();
            for(int x = 0; x <= y; x++) {
                int v = row.get(x);            
                nextMinSum.add(v + Math.min(minSum.get(x), minSum.get(x + 1)));    
            }
            minSum = nextMinSum;
        }
        return minSum.get(0);
    }
}
