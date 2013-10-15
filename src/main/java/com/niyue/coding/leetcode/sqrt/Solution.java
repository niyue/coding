package com.niyue.coding.leetcode.sqrt;

/* http://oj.leetcode.com/problems/sqrtx/
 * http://leetcode.com/onlinejudge#question_69
 * Use binary search to get the square root of a number
 */
public class Solution {
    public int sqrt(int x) {
        int start = 0;
        int end = x;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            long s = (long) mid * (long) mid;
            if(s < x) {
                start = mid + 1;
            } else if(s == x) {
                return mid;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
