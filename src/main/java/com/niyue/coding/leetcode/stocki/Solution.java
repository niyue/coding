package com.niyue.coding.leetcode.stocki;

// http://leetcode.com/onlinejudge#question_121
// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
        int[] minPrices = leftMinPrices(prices);
        int[] maxPrices = rightMaxPrices(prices);
        int maxProfit = 0;
        for(int i = 0;i < prices.length - 1;i++) {
            int profit = maxPrices[i + 1] - minPrices[i];
            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
    
    private int[] leftMinPrices(int[] prices) {
        int[] minPrices = new int[prices.length];
        for(int i = 0;i < prices.length;i++) {
            int minPrice = i == 0 ? prices[0] : Math.min(minPrices[i - 1], prices[i]);
            minPrices[i] = minPrice;
        }
        return minPrices;
    }
    
    private int[] rightMaxPrices(int[] prices) {
        int[] maxPrices = new int[prices.length];
        int lastPriceIndex = prices.length - 1;
        for(int i = lastPriceIndex;i >= 0;i--) {
            int maxPrice = i == lastPriceIndex 
                ? prices[lastPriceIndex] 
                : Math.max(maxPrices[i + 1], prices[i]);
            maxPrices[i] = maxPrice;
        }
        return maxPrices;
    }
    
}
