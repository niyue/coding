package com.niyue.coding.interviewstreet.meetingpoint;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int N;
    private int[] x;
    private int[] y;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();
        int minX = minPoint(x);
        int minY = minPoint(y);
        int[] nearestPoint = nearestPoint(x, y, minX, minY);
        long distanceSum = distanceSum(x, y, nearestPoint[0], nearestPoint[1]);
        System.out.println(manhattanDistanceToChebyshevDistance(distanceSum));
    }
    
    int minPoint(int[] values) {
    	int n = values.length;
    	int[] points = Arrays.copyOf(values, n);
    	Arrays.sort(points);
    	long[] leftToRightSum = new long[n];
    	long[] rightToLeftSum = new long[n];
    	leftToRightSum[0] = points[0];
    	rightToLeftSum[n-1] = points[n-1];
    	for(int i=1;i<n;i++) {
    		leftToRightSum[i] = leftToRightSum[i-1] + points[i];
    	}
    	for(int i=n-2;i>=0;i--) {
    		rightToLeftSum[i] = rightToLeftSum[i+1] + points[i];
    	}
    	int minIndex = 0;
    	long min = Long.MAX_VALUE;
    	for(int i=0;i<n;i++) {
    		long leftSum = i == 0 ? 0 : leftToRightSum[i-1];
    		long rightSum = i == n-1 ? 0 : rightToLeftSum[i+1];
    		long sum = (i * points[i] - leftSum) + (rightSum - points[i] * (n-i-1));
    		if(sum < min) {
    			min = sum;
    			minIndex = i;
    		}
    	}
    	return points[minIndex];
    }
    
    int[] nearestPoint(int[] x, int[] y, int minX, int minY) {
    	int n = x.length;
    	int[] nearestPoint = new int[2];
    	int minDistance = Integer.MAX_VALUE;
    	for(int i=0;i<n;i++) {
    		int distance = manhattanDistance(x[i], y[i], minX, minY);
    		if(distance < minDistance) {
    			minDistance = distance;
    			nearestPoint[0] = x[i];
    			nearestPoint[1] = y[i];
    		}
    	}
    	return nearestPoint;
    }
    
    private long distanceSum(int[] x, int[] y, int minX, int minY) {
    	int n = x.length;
    	long distanceSum = 0;
    	for(int i=0;i<n;i++) {
    		int distance = manhattanDistance(x[i], y[i], minX, minY);
    		distanceSum += distance;
    	}
    	return distanceSum;
    }
    
    private int manhattanDistance(int x1, int y1, int x2, int y2) {
    	return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    
    private long manhattanDistanceToChebyshevDistance(long manhattanDistance) {
    	return manhattanDistance / 2;
    }

    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        x = new int[N];
        y = new int[N];
        for (int i = 0; i < N; i++) {
        	int xi = scanner.nextInt();
        	int yi = scanner.nextInt();
        	// transform coordinates so that Chebyshev distance is converted to Manhattan distance 
        	x[i] = xi + yi;
        	y[i] = yi - xi;
        }
    }
}
