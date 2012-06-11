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
    private Map<Integer, Integer> lowerHalfNumbers;
    private Map<Integer, Integer> higherHalfNumbers;
    private Scanner scanner;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        n = getInput();
        lowerHalf = new PriorityQueue<Integer>(n/2+1, new ReversedComparator<Integer>());
        higherHalf = new PriorityQueue<Integer>(n/2+1);
        lowerHalfNumbers = new HashMap<Integer, Integer>(n);
        higherHalfNumbers = new HashMap<Integer, Integer>(n);
        
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
        double median = operand;
        if(lowerHalf.isEmpty() && higherHalf.isEmpty()) {
            lowerHalf.add(operand);
            increase(lowerHalfNumbers, operand);
        } else if(higherHalf.isEmpty()) {
            int maxInLowerHalf = lowerHalf.peek();
            if(operand >= maxInLowerHalf) {
                higherHalf.add(operand);
                increase(higherHalfNumbers, operand);
            } else {
                lowerHalf.remove(maxInLowerHalf);
                lowerHalf.add(operand);
                higherHalf.add(maxInLowerHalf);
                decrease(lowerHalfNumbers, maxInLowerHalf);
                increase(lowerHalfNumbers, operand);
                increase(higherHalfNumbers, maxInLowerHalf);
            }
            median = (operand + maxInLowerHalf) / 2.0;
        } else {
            int maxInLowerHalf = lowerHalf.peek();
            int minInHigherHalf = higherHalf.peek();
            if(lowerHalf.size() == higherHalf.size()) {
                if(operand <= minInHigherHalf) {
                    lowerHalf.add(operand);
                    increase(lowerHalfNumbers, operand);
                } else {
                    higherHalf.remove(minInHigherHalf);
                    higherHalf.add(operand);
                    lowerHalf.add(minInHigherHalf);
                    
                    decrease(higherHalfNumbers, minInHigherHalf);
                    increase(higherHalfNumbers, operand);
                    increase(lowerHalfNumbers, minInHigherHalf);
                }
                median = lowerHalf.peek();
            } else {
                if(operand <= minInHigherHalf) {
                    lowerHalf.add(operand);
                    maxInLowerHalf = lowerHalf.peek();
                    lowerHalf.remove(maxInLowerHalf);
                    higherHalf.add(maxInLowerHalf);
                    
                    increase(lowerHalfNumbers, operand);
                    decrease(lowerHalfNumbers, maxInLowerHalf);
                    increase(higherHalfNumbers, maxInLowerHalf);
                } else {
                    higherHalf.add(operand);
                    minInHigherHalf = higherHalf.peek();
                    increase(higherHalfNumbers, operand);
                }
                median = (maxInLowerHalf + minInHigherHalf) / 2.0;
            }
        }
        return median;
    }
    
    private void increase(Map<Integer, Integer> numbers, Integer operand) {
        if(!numbers.containsKey(operand)) {
            numbers.put(operand, 0);
        }
        numbers.put(operand, numbers.get(operand) + 1);
    }
    
    private void decrease(Map<Integer, Integer> numbers, Integer number) {
        numbers.put(number, numbers.get(number) - 1);
    }
    
    private double medianAfterRemoval(int operand) {
        double median = operand;
        if(lowerHalfNumbers.containsKey(operand) && lowerHalfNumbers.get(operand) > 0) {
            lowerHalf.remove(operand);
            decrease(lowerHalfNumbers, operand);
            
            if(lowerHalf.size() < higherHalf.size()) {
                int minInHigherHalf = higherHalf.peek();
                higherHalf.remove(minInHigherHalf);
                lowerHalf.add(minInHigherHalf);
                median = minInHigherHalf;
                
                decrease(higherHalfNumbers, minInHigherHalf);
                increase(lowerHalfNumbers, minInHigherHalf);
                
            } else {
                if(lowerHalf.isEmpty()) {
                    throw new IllegalArgumentException();
                } else {
                    int maxInLowerHalf = lowerHalf.peek();
                    int minInHigherHalf = higherHalf.peek();
                    median = (maxInLowerHalf + minInHigherHalf) / 2.0;
                }
            }
        } else if(higherHalfNumbers.containsKey(operand) && higherHalfNumbers.get(operand) > 0) {
            higherHalf.remove(operand);
            decrease(higherHalfNumbers, operand);
            
            if(lowerHalf.size() - 1 > higherHalf.size()) {
                int minInHigherHalf = lowerHalf.peek();
                lowerHalf.remove(minInHigherHalf);
                higherHalf.add(minInHigherHalf);
                
                decrease(lowerHalfNumbers, minInHigherHalf);
                increase(higherHalfNumbers, minInHigherHalf);
                
                median = (lowerHalf.peek() + minInHigherHalf) / 2.0;
            } else {
                median = lowerHalf.peek();
            }
        } else {
            throw new IllegalArgumentException();
        }
        return median;
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
    
    private static class ReversedComparator<E extends Comparable<E>> implements Comparator<E> {
        public int compare(E o1, E o2) {
            return o1.compareTo(o2) * -1;
        }
    }
}
