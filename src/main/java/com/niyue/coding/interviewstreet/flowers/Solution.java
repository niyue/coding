package com.niyue.coding.interviewstreet.flowers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private int N, K;
    private Queue<Integer> C;
    private Scanner scanner;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();
        long cost = 0;
        int flowers = 0;
        while(!C.isEmpty()) {
            int ci = C.poll();
            int x = flowers / K;
            long money = (x + 1) * ci;
            cost += money;
            flowers++;
        }
        System.out.println(cost);
    }
    
    private void getInput() {
        scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        C = new PriorityQueue<Integer>(N, new ReversedComparator<Integer>());
        for(int i=0;i<N;i++) {
            C.offer(scanner.nextInt());
        }
    }
    
    private static class ReversedComparator<E extends Comparable<E>> implements Comparator<E> {
        public int compare(E o1, E o2) {
            return o1.compareTo(o2) * -1;
        }
    }
}
