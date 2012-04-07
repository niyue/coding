package com.niyue.coding.interviewstreet.changingbits;

import java.util.Scanner;

public class Solution {
    private int N, Q;
    private int[] A, B;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();
        for (int i = 0; i < Q; i++) {
            String op = scanner.next();
            char opCode = op.charAt(op.length() - 1);
            int bit = scanner.nextInt();
            if (opCode == 'c') {
                System.out.print(calc(A, B, bit));
            } else {
                int[] number = opCode == 'a' ? A : B;
                int bitSet = scanner.nextInt();
                number[bit] = bitSet;
            }
        }
    }

    private int calc(int[] a, int[] b, int bit) {
        int higherSum = bit == N ? 0 : a[bit] + b[bit];
        for (int i = bit - 1; i >= 0; i--) {
            if (a[i] == b[i]) {
                if (a[i] == 1) {
                    higherSum++;
                }
                break;
            }
        }
        return higherSum & 1;
    }

    private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        A = asBinary(a);
        B = asBinary(b);
    }

    private int[] asBinary(String number) {
        int[] binary = new int[N];
        int nMinusOne = N - 1;
        for (int i = 0; i < number.length(); i++) {
            binary[nMinusOne - i] = number.charAt(i) - '0';
        }
        return binary;
    }
}
