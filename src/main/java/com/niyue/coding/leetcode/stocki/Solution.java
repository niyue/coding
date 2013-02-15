package com.niyue.coding.leetcode.stocki;

// http://leetcode.com/onlinejudge#question_121
// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length >= 2) {
            int min = prices[0];
            for(int i = 1;i < prices.length;i++) {
                int profit = prices[i] - min;
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
                if(prices[i] < min) {
                    min = prices[i];
                }
            }    
        }
        
        return maxProfit;
    }
}
