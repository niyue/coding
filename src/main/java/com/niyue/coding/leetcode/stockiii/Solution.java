package com.niyue.coding.leetcode.stockiii;

// http://leetcode.com/onlinejudge#question_123
// maxProfitWithAtMostTwoTransactions = assume the first transaction is done in prices[i], Math.max(for i = 0...n-1, [maxProfitFromStart(i) + maxProfitToEnd(i + 1)])
// maxProfitsFromStart and maxProfitsToEnd can be computed up front 
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] leftProfits = leftProfits(prices);
        int[] rightProfits = rightProfits(prices);
        for(int i = 0; i < prices.length; i++) {
            int leftProfit = leftProfits[i];
            int rightProfit = i == prices.length - 1 ? 0 : rightProfits[i + 1];
            if(leftProfit + rightProfit > max) {
                max = leftProfit + rightProfit;
            }
        }
        return max;
    }
    
    private int[] leftProfits(int[] prices) {
        int[] profits = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > min) {
                profits[i] = Math.max(prices[i] - min, profits[i - 1]);
            } else {
                min = prices[i];
                profits[i] = i == 0 ? 0 : profits[i - 1];
            }
        }
        return profits;
    }
    
    private int[] rightProfits(int[] prices) {
        int[] profits = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--) {
            if(prices[i] < max) {
                profits[i] = Math.max(max - prices[i], profits[i + 1]);
            } else {
                max = prices[i];
                profits[i] = i == prices.length - 1 ? 0 : profits[i + 1];
            }
        }
        return profits;
    }
}
