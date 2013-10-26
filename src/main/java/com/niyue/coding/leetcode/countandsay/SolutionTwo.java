package com.niyue.coding.leetcode.countandsay;

import java.util.ArrayList;
import java.util.List;

public class SolutionTwo {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 2; i <= n; i++) {
            s = next(s);    
        }            
        return s;
    }
    
    private String next(String s) {
        return say(count(s));
    }
    
    private List<int[]> count(String s) {
        List<int[]> count = new ArrayList<int[]>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(count.size() == 0 || count.get(count.size() - 1)[0] != c - '0') {
                count.add(new int[] {c - '0', 1});
            } else {
                count.get(count.size() - 1)[1]++;
            }
        }
        return count;
    }
    
    private String say(List<int[]> count) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < count.size(); i++) {
            s.append(count.get(i)[1]).append(count.get(i)[0]);
        }
        return s.toString();
    }
}
