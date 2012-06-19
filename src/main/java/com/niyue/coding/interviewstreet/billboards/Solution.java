package com.niyue.coding.interviewstreet.billboards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private int N, K;
    private long MAX_PROFIT = 0;
    private Map<Integer, Map<Integer, Long>> result = new HashMap<Integer, Map<Integer, Long>>();
    private List<Long> remainingProfits;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() throws NumberFormatException, IOException {
        List<Integer> profits = getInput();
        maxProfit(profits, 0, K, 0);
        System.out.println(MAX_PROFIT);
    }
    
    private long maxProfit(List<Integer> profits, int current, int remainingBillboards, long profitSum) {
        long maxProfit = 0;
        if(current < N) {
            if(hasResult(current, remainingBillboards)) {
                maxProfit = result.get(current).get(remainingBillboards);
            } else {
                long remainingProfit = remainingProfits.get(current);
                if(current + remainingBillboards >= N) {
                    maxProfit = remainingProfit;
                    cacheResult(current, remainingBillboards, maxProfit);
                } else {
                    if(profitSum + remainingProfit > MAX_PROFIT) {
                        int currentProfit = profits.get(current);
                        long profitWithCurrent = 0;
                        if(remainingBillboards > 0) {
                            profitWithCurrent = maxProfit(profits, current+1, remainingBillboards-1, profitSum + currentProfit) + currentProfit;
                        }
                        long profitWithoutCurrent = maxProfit(profits, current+1, K, profitSum);
                        maxProfit = Math.max(profitWithCurrent, profitWithoutCurrent);
                        cacheResult(current, remainingBillboards, maxProfit);
                    }
                }
            }
        }
        return maxProfit;
    }
    
    private boolean hasResult(int current, int remainingBillboards) {
        return result.containsKey(current) && result.get(current).containsKey(remainingBillboards);
    }
    
    private void cacheResult(int current, int remainingBillboards, long maxProfit) {
        if(!result.containsKey(current)) {
            result.put(current, new HashMap<Integer, Long>());
        }
        result.get(current).put(remainingBillboards, maxProfit);
        if(MAX_PROFIT < maxProfit) {
            MAX_PROFIT = maxProfit;
        }
    }
    
    private List<Integer> getInput() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 102400);
        String firstLine = br.readLine();
        String[] nnk = firstLine.split(" ");
        N = Integer.parseInt(nnk[0]);
        K = Integer.parseInt(nnk[1]);
        
        List<Integer> profits = new ArrayList<Integer>(N);
        long totalProfit = 0;
        for(int i=0;i<N;i++) {
            int profit = Integer.parseInt(br.readLine());
            profits.add(profit);
            totalProfit += profit;
        }
        
        remainingProfits = new ArrayList<Long>(N);
        for(int i=0;i<N;i++) {
            remainingProfits.add(totalProfit);
            totalProfit -= profits.get(i);
        }
        return profits;
    }
}
