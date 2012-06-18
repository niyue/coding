package com.niyue.coding.interviewstreet.billboards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private int N, K;
    private Map<Integer, Map<Integer, Long>> result = new HashMap<Integer, Map<Integer, Long>>();

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        List<Integer> profits = getInput();
        long maxProfit = maxProfit(profits, 0, K);
        System.out.println(maxProfit);
    }
    
    private long maxProfit(List<Integer> profits, int current, int remainingBillboards) {
        long maxProfit = 0;
        if(current < N) {
            if(result.containsKey(current) && result.get(current).containsKey(remainingBillboards)) {
                maxProfit = result.get(current).get(remainingBillboards);
            } else {
                int currentProfit = profits.get(current);
                long profitWithCurrent = 0;
                if(remainingBillboards > 0) {
                    profitWithCurrent = maxProfit(profits, current+1, remainingBillboards-1) + currentProfit;
                }
                long profitWithoutCurrent = maxProfit(profits, current+1, K);
                maxProfit = Math.max(profitWithCurrent, profitWithoutCurrent);
                if(!result.containsKey(current)) {
                    result.put(current, new HashMap<Integer, Long>());
                }
                result.get(current).put(remainingBillboards, maxProfit);
            }
        }
        return maxProfit;
    }

    private List<Integer> getInput() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        List<Integer> profits = new ArrayList<Integer>(N);
        
        for(int i=0;i<N;i++) {
            int profit = Integer.parseInt(scanner.next());
            profits.add(profit);
        }
        return profits;
    }
}
