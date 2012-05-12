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
    private int N;
    private long K;
    private Set<Long> computedNumbers = new HashSet<Long>();

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        Set<Long> numbers = getInput();
        int squareRootOfK = (int) Math.sqrt(K);
        // compute all primes less than squareRootOfK which potentially might be prime factors of K
        List<Long> primes = primeSieve(squareRootOfK);
        Map<Long, Integer> primeFactorsCount = primeFactorsCount(K, primes);
        // there might be at most one prime factor of K which is larger than squareRootOfK
        long equivalentK = equivalentNumber(primeFactorsCount);
        if(equivalentK != K) {
            primeFactorsCount.put(K/equivalentK, 1);
        }
        
        Set<Long> factors = factors(primeFactorsCount);
        Set<Long> combinedFactors = new HashSet<Long>();
        for(long number : numbers) {
            Map<Long, Integer> numberPrimeFactorsCount = primeFactorsCount(number, primeFactorsCount);
            long equivalentNumber = equivalentNumber(numberPrimeFactorsCount);
            if(!computedNumbers.contains(equivalentNumber)) {
                Set<Long> subFactors = factors(numberPrimeFactorsCount);
                combinedFactors.addAll(subFactors);
                computedNumbers.add(equivalentNumber);
            }
        }
        System.out.println(factors.size() - combinedFactors.size());
    }
    
    // all primes less than n
    private List<Long> primeSieve(int n) {
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
        
        List<Long> primes = new ArrayList<Long>();
        for(long i=2;i<=n;i++) {
            if(primeFlags[(int)i]) {
                primes.add(i);
            }
        }
        return primes;
    }
    
    private Map<Long, Integer> primeFactorsCount(long n, List<Long> primes) {
        Map<Long, Integer> primeFactorsCount = new LinkedHashMap<Long, Integer>();
        for(long prime : primes) {
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
    
    private Map<Long, Integer> primeFactorsCount(long n, Map<Long, Integer> maxPrimeFactorsCount) {
        Map<Long, Integer> primeFactorsCount = new LinkedHashMap<Long, Integer>();
        for(Entry<Long, Integer> primeFactorCount : maxPrimeFactorsCount.entrySet()) {
            long prime = primeFactorCount.getKey();
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
    
    private long equivalentNumber(Map<Long, Integer> primeFactorsCount) {
        long product = 1;
        for(Entry<Long, Integer> primeFactorCount : primeFactorsCount.entrySet()) {
            long prime = primeFactorCount.getKey();
            int count = primeFactorCount.getValue();
            product *= Math.pow(prime, count);
        }
        return product;
    }
    
    private Set<Long> factors(Map<Long, Integer> primeFactorsCount) {
        Set<Long> factors = new HashSet<Long>();
        if(!primeFactorsCount.isEmpty()) {
            for(Entry<Long, Integer> primeFactorCount : primeFactorsCount.entrySet()) {
                long prime = primeFactorCount.getKey();
                Map<Long, Integer> subPrimeFactorsCount = decreaseCount(primeFactorsCount, prime);
                Set<Long> subFactors = factors(subPrimeFactorsCount);
                factors.addAll(subFactors);
                for(Long factor : subFactors) {
                    factors.add(factor * prime);
                }
            }
        }
        else {
            factors.add(1L);
        }
        return factors;
    }
    
    private Map<Long, Integer> decreaseCount(Map<Long, Integer> primeFactorsCount, long prime) {
        int count = primeFactorsCount.get(prime);
        Map<Long, Integer> subPrimeFactorsCount = new LinkedHashMap<Long, Integer>(primeFactorsCount);
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
        K = scanner.nextLong();
        Set<Long> inputNumbers = new HashSet<Long>(N);
        for (int i = 0; i < N; i++) {
            inputNumbers.add(scanner.nextLong());
        }
        return inputNumbers;
    }
}
