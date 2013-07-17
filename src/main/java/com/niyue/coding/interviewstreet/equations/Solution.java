package com.niyue.coding.interviewstreet.equations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    // (1/x) + (1/y) = 1/N! ==> y = N! + (N!)^2/T && T = X - N!
    // positive solution iff (N!)^2/T is integer ==> T is any factor of (N!)^2
    // no of positive solutions = no of factors of (N!)^2
    // 6! = 2*3*4*5*6 = 2^4 * 3^2 * 5
    // no of factors of (6!)^2 = (4*2+1)*(2*2+1)*(1*2+1) = 135
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long size = 1;
        List<Integer> primes = primeSieve(n);
        for(int prime : primes) {
            int xi = powerSum(n, prime);
            size = size * (2 * xi + 1);
            size = size % 1000007;
        }
        scanner.close();
        System.out.println(size);
    }

    private int powerSum(int n, int base) {
        int sum = 0;
        for (long product = base; product <= n; product = product * base) {
            sum += n / product;
        }
        return sum;
    }
    
    private List<Integer> primeSieve(int n) {
        // only 2..n elements in the array are used
        boolean[] primeFlags = new boolean[n+1];
        Arrays.fill(primeFlags, true);
        
        int squareRoot = (int) Math.sqrt(n);
        for(int i=2;i<=squareRoot;i++) {
            if(primeFlags[i]) {
                int times = n / i;
                for(int j=2;j<=times;j++) {
                    primeFlags[j*i] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<Integer>();
        for(int i=2;i<=n;i++) {
            if(primeFlags[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
