package com.niyue.coding.leetcode.countandsay;

import java.util.ArrayList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_38
public class Solution {
    public String countAndSay(int n) {
        return say(count(n));
    }
    
    private List<Integer> count(int n) {
    	List<Integer> count = new ArrayList<Integer>();
        count.add(1);
    	for(int i = 2; i <= n; i++) {
            count = countNext(count);
        }  
    	return count;
    }

    private String say(List<Integer> count) {
        StringBuilder say = new StringBuilder();
        for(int number : count) {
            say.append(number);
        }
        return say.toString();
    }

    private List<Integer> countNext(List<Integer> current) {
        List<Integer> next = new ArrayList<Integer>();
        for(int i = 0; i < current.size(); i++) {
            int c = current.get(i);
            int count = 1;
            while(i + 1 < current.size() && c == current.get(i + 1)) {
                count++;
                i++;
            }
            next.add(count);
            next.add(c);
        }
        return next;
    }
}
