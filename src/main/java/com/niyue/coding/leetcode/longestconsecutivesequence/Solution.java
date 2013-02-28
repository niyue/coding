package com.niyue.coding.leetcode.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_128
// Put all numbers into a hash set, and check a continuous number sequence from two directions and use a Set to memorize the visited numbers
public class Solution {
    private Set<Integer> visitedNumbers;
    
    public int longestConsecutive(int[] num) {
        visitedNumbers = new HashSet<Integer>();
        
        Set<Integer> numbers = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++) {
        	numbers.add(num[i]);
        }
        
        int maxLength = 0;
        for(int number : num) {
            if(isUnvisited(number)) {
                visit(number);
                int length = 1;
                for(int n = number - 1; numbers.contains(n); n--) {
                    length++;
                    visit(n);
                }
                
                for(int n = number + 1; numbers.contains(n); n++) {
                    length++;
                    visit(n);
                } 
                if(length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
    
    private boolean isUnvisited(int number) {
        return !visitedNumbers.contains(number);
    }
    
    private void visit(int number) {
        visitedNumbers.add(number);
    }
}
