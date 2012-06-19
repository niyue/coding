package com.niyue.coding.interviewstreet.billboards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

class Solution {
    private int N, K;
    private Map<Integer, Long> result = new HashMap<Integer, Long>();
    private List<Long> remainingProfits;
    private List<Long> startingProfits;
    private List<Integer> kMinIndexes;
    

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() throws NumberFormatException, IOException {
        List<Integer> profits = getInput();
        long maxProfit = maxProfit(profits, 0);
        System.out.println(maxProfit);
    }
    
    private long maxProfit(List<Integer> profits, int current) {
        long maxProfit = 0;
        if(current < N) {
            if(hasResult(current)) {
                maxProfit = result.get(current);
            } else {
                if(current + K >= N) {
                    maxProfit = remainingProfits.get(current);
                } else {
                    int end = Math.min(current + K, N-1);
                    int minIndex = kMinIndexes.get(current);
                    for(int i=minIndex;i<=end;i++) {
                        long profitSum = startingProfits.get(i) - startingProfits.get(current);
                        long profit = maxProfit(profits, i+1) + profitSum;
                        if(profit > maxProfit) {
                            maxProfit = profit;
                        }
                    }
                }
                cacheResult(current, maxProfit);
            }
        }
        return maxProfit;
    }
    
    private boolean hasResult(int current) {
        return result.containsKey(current);
    }
    
    private void cacheResult(int current, long maxProfit) {
        result.put(current, maxProfit);
    }
    
    private List<Integer> getInput() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 102400);
        String firstLine = br.readLine();
        String[] nnk = firstLine.split(" ");
        N = Integer.parseInt(nnk[0]);
        K = Integer.parseInt(nnk[1]);
        
        List<Integer> profits = new ArrayList<Integer>(N);
        startingProfits = new ArrayList<Long>(N+1);
        long totalProfit = 0;
        startingProfits.add(0L);
        for(int i=0;i<N;i++) {
            int profit = Integer.parseInt(br.readLine().trim());
            profits.add(profit);
            totalProfit += profit;
            startingProfits.add(totalProfit);
        }
        
        remainingProfits = new ArrayList<Long>(N);
        for(int i=0;i<N;i++) {
            remainingProfits.add(totalProfit);
            totalProfit -= profits.get(i);
        }
        
        kMinIndexes = new ArrayList<Integer>(N);
        NavigableSet<Billboard> billboards = new TreeSet<Billboard>();
        for(int i=0;i<=K;i++) {
            billboards.add(new Billboard(i, profits.get(i)));
        }
        
        for(int i=0;i<N;i++) {
            kMinIndexes.add(billboards.first().getIndex());
            billboards.remove(new Billboard(i, profits.get(i)));
            if(i+K<N) {
                billboards.add(new Billboard(i+K, profits.get(i+K)));
            }
        }
        return profits;
    }
    
    private static class Billboard implements Comparable<Billboard> {
        private final int index;
        private final int profit;
        public Billboard(int index, int profit) {
            super();
            this.index = index;
            this.profit = profit;
        }
        public int getIndex() {
            return index;
        }
        public int getProfit() {
            return profit;
        }
        
        public int compareTo(Billboard o) {
            int diff = this.getProfit() - o.getProfit();
            if(diff == 0) {
                diff = o.getIndex() - this.getIndex();
            }
            if(diff < 0) {
                diff = -1;
            } else if(diff > 0) {
                diff = 1;
            }
            return diff;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + index;
            result = prime * result + profit;
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Billboard other = (Billboard) obj;
            if (index != other.index)
                return false;
            if (profit != other.profit)
                return false;
            return true;
        }
    }
}
