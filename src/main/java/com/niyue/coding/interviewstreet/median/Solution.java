package com.niyue.coding.interviewstreet.median;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private int n;
    private PriorityQueue<Integer> lowerHalf;
    private PriorityQueue<Integer> higherHalf;
    private Scanner scanner;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        n = getInput();
        lowerHalf = new HashCountingPriorityQueue<Integer>(n/2+1, new ReversedComparator<Integer>());
        higherHalf = new HashCountingPriorityQueue<Integer>(n/2+1);
        
        for(int i=0;i<n;i++) {
            String operator = scanner.next();
            int operand = Integer.parseInt(scanner.next());
            try {
                double median = operator.equals("a")
                        ? medianAfterInsertion(operand)
                        : medianAfterRemoval(operand);
                print(median);
            } catch(IllegalArgumentException e) {
                System.out.println("Wrong!");
            }
        }
    }
    
    private double medianAfterInsertion(int operand) {
        if(lowerHalf.isEmpty()) {
            lowerHalf.offer(operand);
        } else {
            int maxInLowerHalf = lowerHalf.peek();
            if(operand <= maxInLowerHalf) {
                lowerHalf.offer(operand);
            } else {
                higherHalf.offer(operand);
            }
        }
        balance(lowerHalf, higherHalf);
        return median(lowerHalf, higherHalf);
    }
    
    private double median(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> higherHalf) {
        if(!lowerHalf.isEmpty()) {
            return lowerHalf.size() == higherHalf.size() 
                    ? average(lowerHalf.peek(), higherHalf.peek())
                    : lowerHalf.peek();
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    private void balance(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> higherHalf) {
        if(lowerHalf.size() == higherHalf.size() + 2) {
            higherHalf.offer(lowerHalf.poll());
        } else if(lowerHalf.size() == higherHalf.size() - 1) {
            lowerHalf.offer(higherHalf.poll());
        }
    }
    
    private double medianAfterRemoval(int operand) {
        if(lowerHalf.contains(operand)) {
            lowerHalf.remove(operand);
        } else if(higherHalf.contains(operand)) {
            higherHalf.remove(operand);
        } else {
            throw new IllegalArgumentException();
        }
        balance(lowerHalf, higherHalf);
        return median(lowerHalf, higherHalf);
    }
    
    private void print(double median) {
        if(median == (long) median) {
            System.out.println((long) median);
        } else {
            System.out.println(median);
        }
    }
    
    private int getInput() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    private double average(int one, int two) {
        return one / 2.0 + two / 2.0;
    }
    
    private static class ReversedComparator<E extends Comparable<E>> implements Comparator<E> {
        public int compare(E o1, E o2) {
            return o1.compareTo(o2) * -1;
        }
    }
    
    private static class HashCountingPriorityQueue<E> extends PriorityQueue<E> {
        private static final long serialVersionUID = 1L;
        private Map<E, Integer> countsMap = new HashMap<E, Integer>(); 
        
        public HashCountingPriorityQueue(int initialCapacity) {
            super(initialCapacity);
        }
        
        public HashCountingPriorityQueue(int initialCapacity, Comparator<E> comparator) {
            super(initialCapacity, comparator);
        }
        
        @Override
        public boolean offer(E e) {
            increase(e);
            return super.offer(e);
        }

        @Override
        public E poll() {
            E e = super.poll();
            decrease(e);
            return e;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean remove(Object e) {
            decrease((E) e);
            return super.remove(e);
        }
        
        @Override
        public boolean contains(Object o) {
            return countsMap.containsKey(o) && countsMap.get(o) > 0;
        }

        private void increase(E element) {
            if(!countsMap.containsKey(element)) {
                countsMap.put(element, 0);
            }
            countsMap.put(element, countsMap.get(element) + 1);
        }
        
        private void decrease(E element) {
            countsMap.put(element, countsMap.get(element) - 1);
        }
    }
}
