package com.niyue.coding.interviewstreet.gridwalking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private int N, M;
    private int[] currentPosition;
    private int[] dimentionMax;
    private Map<Long, Map<Integer, Long>> results;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        int T = scanner.nextInt();
        for(int t=0;t<T;t++) {
            results = new HashMap<Long, Map<Integer, Long>>();
            getInput();
            long ways = ways(currentPosition, M);
            System.out.println(ways);
        }
    }
    
    private long ways(int[] currentPosition, int remainingSteps) {
        long ways = 0;
        if(remainingSteps > 0) {
            long positionHash = positionHash(currentPosition);
            if(results.containsKey(positionHash) && results.get(positionHash).containsKey(remainingSteps)) {
                ways = results.get(positionHash).get(remainingSteps);
            } else {
                for(int d=0;d<N;d++) {
                    int currentPositionInD = currentPosition[d];
                    if(currentPosition[d] + 1 <= dimentionMax[d]) {
                        currentPosition[d] = currentPositionInD + 1;
                        ways += ways(currentPosition, remainingSteps - 1);
                        currentPosition[d] = currentPositionInD;
                    }
                    if(currentPosition[d] - 1 > 0) {
                        currentPosition[d] = currentPositionInD - 1;
                        ways += ways(currentPosition, remainingSteps - 1);
                        currentPosition[d] = currentPositionInD;
                    }
                    ways = ways % 1000000007;
                }
                if(!results.containsKey(positionHash)) {
                    results.put(positionHash, new HashMap<Integer, Long>());
                }
                results.get(positionHash).put(remainingSteps, ways);
            }
        } else {
            ways = 1;
        }
        return ways;
    }
    
    private long positionHash(int[] currentPosition) {
        long hash = 1;
        for(int position : currentPosition) {
            hash *= position;
        }
        return hash;
    }

    private void getInput() {
        N = scanner.nextInt();
        M = scanner.nextInt();
        currentPosition = new int[N];
        dimentionMax = new int[N];
        for(int i=0;i<N;i++) {
            currentPosition[i] = scanner.nextInt();
        }
        for(int i=0;i<N;i++) {
            dimentionMax[i] = scanner.nextInt();
        }
    }
}
