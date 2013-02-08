package com.niyue.coding.leetcode.stockii;

// http://leetcode.com/onlinejudge#question_122
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Solution: find all lowest prices and highest prices for profit, each high-low-high is a buy point, and each low-high-low is a sell point
 */
public class Solution {
	private int profit = 0;
	private boolean boughtStatus = false;
	private int boughtPrice = 0;
	
    public int maxProfit(int[] prices) {
    	profit = 0;
    	boughtStatus = false;
    	boughtPrice = 0;
    	
        if(prices.length > 1) {
            for(int i = 0;i < prices.length;i++) {
                if(!boughtStatus) {
                	if(lowestPrice(prices, i)) {
                		buyAtPrice(prices, i);
                	}
                } else {
                	if(highestPrice(prices, i)) {
                		sellAtPrice(prices, i);
                	}
                }                 
            }    
        }
        
        return profit;
    }
    
    private boolean lowestPrice(int[] prices, int i) {
    	return i == 0 && prices[1] > prices[0]
    		|| i > 0 && i < prices.length - 1 && prices[i + 1] > prices[i] && prices[i - 1] >= prices[i];
    }
    
    private boolean highestPrice(int[] prices, int i) {
    	return i == prices.length - 1 && prices[i - 1] < prices[i]
    		|| i < prices.length - 1 && prices[i + 1] <= prices[i] && prices[i - 1] < prices[i];
    }
    
    private void buyAtPrice(int[] prices, int i) {
    	boughtPrice = prices[i];
        boughtStatus = true;
    }
    
    private void sellAtPrice(int[] prices, int i) {
    	int soldPrice = prices[i];
        profit += soldPrice - boughtPrice;
        boughtStatus = false;
    }
}
