package com.niyue.coding.leetcode.sqrt;

// http://leetcode.com/onlinejudge#question_69
// Use binary search to get the square root of a number
public class Solution {
    public int sqrt(int x) {
        if(x == 0 || x == 1) {
            return x;   
        }
        int sqrt = binarySearch(1, x / 2, x);
        return sqrt;
    }
    
    private int binarySearch(int start, int end, long x) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * (long) mid;
            if(square == x) {
                return mid;
            } else if(square < x) {
                start = mid + 1;
            } else {
               end = mid - 1;
            }
        }
        return start - 1;
    }
}
