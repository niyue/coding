package com.niyue.coding.leetcode.gasstation;

/*
 * http://oj.leetcode.com/problems/gas-station/
 * This problem is a variant problem for the max sum array problem
 * http://en.wikipedia.org/wiki/Maximum_subarray_problem
 * Compared with max sum array problem, here we need to guarantee each sum >= 0 instead of sum > max
 * The difficulties compared to max sum array problem is the route is circular, and this can be solved by appending the same gas/cost into route
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] route = makeRoute(gas, cost);
        int clockwiseStart = canCompleteSingleDirection(route);
        int counterClockwiseStart = canCompleteSingleDirection(reverse(route));
        return clockwiseStart != -1 
                    ? clockwiseStart 
                    : counterClockwiseStart == -1 
                        ? -1
                        : gas.length - 1 - counterClockwiseStart;
    }

    // route => [interleaving gas/cost, interleaving gas/cost]
    private int[] makeRoute(int[] gas, int[] cost) {
        int[] route = new int[gas.length * 4];
        for(int i = 0; i < gas.length; i++) {
            route[2 * i] = gas[i];
            route[2 * i + 1] = -1 * cost[i];
            route[gas.length * 2 + 2 * i] = gas[i];
            route[gas.length * 2 + 2 * i + 1] = -1 * cost[i];
        }
        return route;
    }
    
    private int[] reverse(int[] route) {
        for(int start = 0, end = route.length - 1; start <= end; start++, end--) {
            swap(route, start, end);
        }
        return route;
    }
    
    private void swap(int[] route, int i, int j) {
        int temp = route[i];
        route[i] = route[j];
        route[j] = temp;
    }
    
    private int canCompleteSingleDirection(int[] route) {
        int start = 0;
        int sum = 0;
        int maxStart = -1;
        for(int i = 0; i < route.length; i++) {
            if(sum < 0) {
                start = i;
                sum = 0;
            }
            sum += route[i];
            if(sum >= 0 && i - start + 1 == route.length / 2) {
                maxStart = (start % (route.length / 2)) / 2;
                break;
            }
        }    
        return maxStart;
    }
}