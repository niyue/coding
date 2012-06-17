package com.niyue.coding.interviewstreet.permutationgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private Map<Long, Boolean> result = new HashMap<Long, Boolean>();
    
    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t=0;t<T;t++) {
            int N = scanner.nextInt();
            List<Integer> numbers = new ArrayList<Integer>(N);
            for(int i=0;i<N;i++) {
                numbers.add(scanner.nextInt());
            }
            boolean isFirstLose = isFirstLose(N, numbers);
            print(isFirstLose);
        }
    }
    
    private boolean isFirstLose(int n, List<Integer> numbers) {
        boolean isFirstLose = true;
        Boolean retrievedResult = retrieveResult(n, numbers);
        if(retrievedResult != null) { 
            isFirstLose = retrievedResult;
        } else {
            if(!isWin(numbers)) {
                for(int i=0;i<n;i++) {
                    List<Integer> remainingNumbers = removeNumber(numbers, i);
                    boolean willMoveIthWin = isFirstLose(n-1, remainingNumbers);
                    if(willMoveIthWin) {
                        isFirstLose = false;
                        break;
                    }
                }
            }
            
            if(n < 10) {
                long fingerPrint = fingerPrint(numbers);
                result.put(fingerPrint, isFirstLose);
            }
        }
        return isFirstLose;
    }
    
    private Boolean retrieveResult(int n, List<Integer> numbers) {
        Boolean isFirstLose = null;
        if(n < 10) {
            long fingerPrint = fingerPrint(numbers);
            if(result.containsKey(fingerPrint)) {
                isFirstLose = result.get(fingerPrint);
            }
        }
        return isFirstLose;
    }
    
    private long fingerPrint(List<Integer> numbers) {
        long fingerPrint = 0;
        for(int number : numbers) {
            fingerPrint += fingerPrint * 10 + number;
        }
        return fingerPrint;
    }
    
    private List<Integer> removeNumber(List<Integer> numbers, int i) {
        List<Integer> remainingNumbers = new ArrayList<Integer>(numbers.size()-1);
        int removedNumber = numbers.get(i);
        for(int l=0;l<numbers.size();l++) {
            if(l != i) {
                int addedNumber = numbers.get(l);
                if(addedNumber > removedNumber) {
                    addedNumber--;
                }
                remainingNumbers.add(addedNumber);
            }
        }
        return remainingNumbers;
    }
    
    private boolean isWin(List<Integer> numbers) {
        boolean isWin = true;
        int previous = -1;
        for(int number : numbers) {
            if(number < previous) {
                isWin = false;
                break;
            }
            previous = number;
        }
        return isWin;
    }
    
    private void print(boolean isFirstLose) {
        System.out.println(isFirstLose ? "Bob" : "Alice");
    }
}
