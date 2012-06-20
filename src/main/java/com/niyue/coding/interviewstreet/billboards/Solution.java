package com.niyue.coding.interviewstreet.billboards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

class Solution {
    private int N, K;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() throws NumberFormatException, IOException {
        List<Integer> profits = getInput();
        long[] results = new long[N+1];
        results[N] = 0;
        NavigableSet<Long> minProfits = new TreeSet<Long>();
        minProfits.add(results[N]);
        for(int i = N - 1;i >= 0;i--) {
            results[i] = minProfits.first() + profits.get(i);
            minProfits.add(results[i]);
            if(i + K + 1 <= N) {
                minProfits.remove(results[i+K+1]);
            }
        }
        System.out.println(maxProfit(profits, results));
    }
    
    private long maxProfit(List<Integer> profits, long[] minRemovedProfits) {
        return totalProfit(profits) - minRemovedProfit(minRemovedProfits);
    }
    
    private long totalProfit(List<Integer> profits) {
        long sum = 0;
        for(int profit : profits) {
            sum += profit;
        }
        return sum;
    }
    
    private long minRemovedProfit(long[] minRemovedProfits) {
        long minRemovedProfit = Long.MAX_VALUE;
        for(int i=0;i<=K;i++) {
            if(minRemovedProfits[i] < minRemovedProfit) {
                minRemovedProfit = minRemovedProfits[i];
            }
        }
        return minRemovedProfit;
    }
    
    private List<Integer> getInput() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 102400);
        String firstLine = br.readLine();
        String[] nnk = firstLine.split(" ");
        N = Integer.parseInt(nnk[0]);
        K = Integer.parseInt(nnk[1]);
        
        List<Integer> profits = new ArrayList<Integer>(N);
        for(int i=0;i<N;i++) {
            int profit = Integer.parseInt(br.readLine().trim());
            profits.add(profit);
        }
        return profits;
    }
}
