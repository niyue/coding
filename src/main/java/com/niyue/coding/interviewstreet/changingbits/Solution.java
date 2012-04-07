package com.niyue.coding.interviewstreet.changingbits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Solution {
    private int N, Q;
    private int[] A, B;
    private Scanner scanner = new Scanner(System.in);
    private List<Set<Integer>> equalBits;
    private int noOfPartitions;
    
    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }
 
    public void solve() {
        getInput();
        for(int i=0;i<Q;i++) {
            String op = scanner.next();
            char opCode = op.charAt(op.length() - 1);
            int bit = scanner.nextInt();
            if(opCode == 'c') {
                System.out.print(calc(A, B, bit));
            }
            else {
                int[] number = opCode == 'a' ? A : B;
                int bitSet = scanner.nextInt();
                if(number[bit] != bitSet) {
                    number[bit] = bitSet;
                    int partition = bit / noOfPartitions;
                    if(A[bit] == B[bit]) {
                        equalBits.get(partition).add(bit);
                    }
                    else {
                        equalBits.get(partition).remove(bit);
                    }
                }
            }
        }
    }
    
    private int calc(int[] a, int[] b, int bit) {
        int higherSum = bit == N ? 0 : a[bit] + b[bit];
        Integer equalBit = searchLowerEqualBits(bit);
        if(equalBit != null) {
            if(a[equalBit] == 1) {
                higherSum++;
            }
        }
        return higherSum & 1;
    }
    
    private Integer searchLowerEqualBits(int bit) {
        int partition = bit / noOfPartitions;
        Integer maxLowerEqualBit = null;
        for(int i=partition;i>=0;i--) {
            Set<Integer> equalBitsInPartition = equalBits.get(i);
            if(!equalBitsInPartition.isEmpty()) {
                for(Integer equalBit : equalBitsInPartition) {
                    if(equalBit < bit) {
                        if(maxLowerEqualBit == null || equalBit > maxLowerEqualBit) {
                            maxLowerEqualBit = equalBit;
                        }
                    }
                }
                break;
            }
        }
        return maxLowerEqualBit;
    }
    
    private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        A = asBinary(a);
        B = asBinary(b);
        noOfPartitions = ((int)Math.sqrt(N)) + 1;
        equalBits = findEqualBits(A, B);
    }
    
    private int[] asBinary(String number) {
        int[] binary = new int[N];
        for(int i=0;i<number.length();i++) {
            binary[N-1-i] = number.charAt(i) - '0';
        }
        return binary;
    }
    
    private List<Set<Integer>> findEqualBits(int[] a, int[] b) {
        List<Set<Integer>> bits = new ArrayList<Set<Integer>>(noOfPartitions);
        int partitionSize = noOfPartitions;
        for(int i=0;i<noOfPartitions;i++) {
            bits.add(new HashSet<Integer>(partitionSize));
        }
        for(int i=0;i<N;i++) {
            if(a[i] == b[i]) {
                int partition = i / partitionSize;
                bits.get(partition).add(i);
            }
        }
        return bits;
    }
}