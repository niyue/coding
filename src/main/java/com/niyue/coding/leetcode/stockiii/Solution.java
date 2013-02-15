package com.niyue.coding.leetcode.stockiii;

// http://leetcode.com/onlinejudge#question_123
// maxProfitWithAtMostTwoTransactions = assume the first transaction is done in prices[i], Math.max(for i = 0...n-1, [maxProfitFromStart(i) + maxProfitToEnd(i + 1)])
// maxProfitsFromStart and maxProfitsToEnd can be computed up front 
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length > 1) {
            int[] maxProfitsFromStart = maxProfitsFromStart(prices);
            int[] maxProfitsToEnd = maxProfitsToEnd(prices);
            
            for(int i = 0; i < prices.length; i++) {
                int maxProfitFromStart = maxProfitsFromStart[i];
                int maxProfitToEnd = i == prices.length - 1 ? 0 : maxProfitsToEnd[i + 1];
                int profit = maxProfitFromStart + maxProfitToEnd;
                if(maxProfit < profit) {
                    maxProfit = profit;
                }
            }    
        }
        
        return maxProfit;
    }
    
    private int[] maxProfitsFromStart(int[] prices) {
        int[] profits = new int[prices.length];
        int maxProfit = 0;
        int minPrice = prices[0];
        profits[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if(profit > maxProfit) {
                maxProfit = profit;
            }
            profits[i] = maxProfit;
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return profits;
    }
    
    private int[] maxProfitsToEnd(int[] prices) {
        int[] profits = new int[prices.length];
        int maxProfit = 0;
        profits[prices.length - 1] = 0;
        int maxPrice = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            int profit = maxPrice - prices[i];
            if(profit > maxProfit) {
                maxProfit = profit;
            }
            profits[i] = maxProfit;
            if(prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
        }
        return profits;       
    }
}
