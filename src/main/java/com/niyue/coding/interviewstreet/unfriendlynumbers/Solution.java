package com.niyue.coding.interviewstreet.unfriendlynumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int N, K;
    private Set<Integer> computedNumbers = new HashSet<Integer>();

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        Set<Long> numbers = getInput();
        List<Integer> primes = primeSieve(K);
        Map<Integer, Integer> primeFactorsCount = primeFactorsCount(K, primes);
        Set<Integer> factors = factors(primeFactorsCount);
        Set<Integer> combinedFactors = new HashSet<Integer>();
        for(long number : numbers) {
            Map<Integer, Integer> numberPrimeFactorsCount = primeFactorsCount(number, primeFactorsCount);
            int equivalentNumber = equivalentNumber(numberPrimeFactorsCount);
            if(!computedNumbers.contains(equivalentNumber)) {
                Set<Integer> subFactors = factors(numberPrimeFactorsCount);
                combinedFactors.addAll(subFactors);
                computedNumbers.add(equivalentNumber);
            }
        }
        System.out.println(factors.size() - combinedFactors.size());
    }
    
    // all primes less than n
    private List<Integer> primeSieve(int n) {
        boolean[] primeFlags = new boolean[n+1];
        Arrays.fill(primeFlags, true);
        
        int squareRoot = (int) Math.sqrt(n);
        for(int i=2;i<=squareRoot;i++) {
            if(primeFlags[i]) {
                for(int j=2;j<=n/i;j++) {
                    primeFlags[i*j] = false;
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
    
    private Map<Integer, Integer> primeFactorsCount(int n, List<Integer> primes) {
        Map<Integer, Integer> primeFactorsCount = new LinkedHashMap<Integer, Integer>();
        for(int prime : primes) {
            while(n % prime == 0) {
                if(!primeFactorsCount.containsKey(prime)) {
                    primeFactorsCount.put(prime, 0);
                }
                int count = primeFactorsCount.get(prime) + 1;
                primeFactorsCount.put(prime, count);
                n = n / prime;
            }
            if(n == 1) {
                break;
            }
        }
        return primeFactorsCount;
    }
    
    private Map<Integer, Integer> primeFactorsCount(long n, Map<Integer, Integer> maxPrimeFactorsCount) {
        Map<Integer, Integer> primeFactorsCount = new LinkedHashMap<Integer, Integer>();
        for(Entry<Integer, Integer> primeFactorCount : maxPrimeFactorsCount.entrySet()) {
            int prime = primeFactorCount.getKey();
            while(n % prime == 0) {
                if(!primeFactorsCount.containsKey(prime)) {
                    primeFactorsCount.put(prime, 0);
                }
                int count = primeFactorsCount.get(prime) + 1;
                primeFactorsCount.put(prime, count);
                n = n / prime;
                if(count == maxPrimeFactorsCount.get(prime)) {
                    break;
                }
            }
            if(n == 1) {
                break;
            }
        }
        return primeFactorsCount;
    }
    
    private int equivalentNumber(Map<Integer, Integer> primeFactorsCount) {
        int product = 1;
        for(Entry<Integer, Integer> primeFactorCount : primeFactorsCount.entrySet()) {
            int prime = primeFactorCount.getKey();
            int count = primeFactorCount.getValue();
            product *= Math.pow(prime, count);
        }
        return product;
    }
    
    private Set<Integer> factors(Map<Integer, Integer> primeFactorsCount) {
        Set<Integer> factors = new HashSet<Integer>();
        if(!primeFactorsCount.isEmpty()) {
            for(Entry<Integer, Integer> primeFactorCount : primeFactorsCount.entrySet()) {
                int prime = primeFactorCount.getKey();
                Map<Integer, Integer> subPrimeFactorsCount = decreaseCount(primeFactorsCount, prime);
                Set<Integer> subFactors = factors(subPrimeFactorsCount);
                factors.addAll(subFactors);
                for(Integer factor : subFactors) {
                    factors.add(factor * prime);
                }
            }
        }
        else {
            factors.add(1);
        }
        return factors;
    }
    
    private Map<Integer, Integer> decreaseCount(Map<Integer, Integer> primeFactorsCount, int prime) {
        int count = primeFactorsCount.get(prime);
        Map<Integer, Integer> subPrimeFactorsCount = new LinkedHashMap<Integer, Integer>(primeFactorsCount);
        if(count > 1) {
            subPrimeFactorsCount.put(prime, count - 1);
        }
        else {
            subPrimeFactorsCount.remove(prime);
        }
        return subPrimeFactorsCount;
    }
    
    private Set<Long> getInput() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        Set<Long> inputNumbers = new HashSet<Long>(N);
        for (int i = 0; i < N; i++) {
            inputNumbers.add(scanner.nextLong());
        }
        return inputNumbers;
    }
}
