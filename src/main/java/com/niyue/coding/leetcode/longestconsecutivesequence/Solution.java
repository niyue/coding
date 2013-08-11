package com.niyue.coding.leetcode.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

// http://leetcode.com/onlinejudge#question_128
// Put all numbers into a hash set, and check a continuous number sequence from two directions and use a Set to memorize the visited numbers
public class Solution {
    
    public int longestConsecutive(int[] num) {
        Set<Integer> numbers = new HashSet<Integer>();
        for(int i : num) numbers.add(i);
        
        int maxLength = 0;
        for(int number : num) {
            if(numbers.contains(number)) {
            	numbers.remove(number);
                int length = 1;
                for(int n = number - 1; numbers.contains(n); n--) {
                    length++;
                    numbers.remove(n);
                }
                
                for(int n = number + 1; numbers.contains(n); n++) {
                    length++;
                    numbers.remove(n);
                } 
                if(length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
}
