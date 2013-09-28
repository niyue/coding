package com.niyue.coding.leetcode.stocki;

// http://leetcode.com/onlinejudge#question_121
// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
            if(prices[i] < min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
