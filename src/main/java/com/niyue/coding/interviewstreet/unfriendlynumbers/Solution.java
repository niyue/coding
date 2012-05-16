package com.niyue.coding.interviewstreet.unfriendlynumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    private int N;
    private long K;
    private Map<Long, Set<Long>> childFactorsMap = new HashMap<Long, Set<Long>>();

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        List<Long> unfriendlyNumbers = getInput();
        Map<Long, Integer> primeFactorsCount = factorize(K);
        
        Set<Long> unfriendlyEquivalentNumbers = new HashSet<Long>();
        Map<Long, Map<Long, Integer>> unfriendlyPrimeFactorsCount = new HashMap<Long, Map<Long, Integer>>();
        for(long unfriendlyNumber : unfriendlyNumbers) {
            Map<Long, Integer> numberPrimeFactorsCount = primeFactorsCount(unfriendlyNumber, primeFactorsCount);
            long equivalentNumber = equivalentNumber(numberPrimeFactorsCount);
            unfriendlyEquivalentNumbers.add(equivalentNumber);
            unfriendlyPrimeFactorsCount.put(equivalentNumber, numberPrimeFactorsCount);
        }
        
        Set<Long> combinedFactors = new HashSet<Long>();
        for(long number : unfriendlyEquivalentNumbers) {
            Map<Long, Integer> numberPrimeFactorsCount = unfriendlyPrimeFactorsCount.get(number);
            Set<Long> subFactors = factors(number, numberPrimeFactorsCount);
            combinedFactors.addAll(subFactors);
        }
        
        int totalCombinations = factorsCombinations(primeFactorsCount);
        
        System.out.println(totalCombinations - combinedFactors.size());
    }
    
    private int factorsCombinations(Map<Long, Integer> primeFactorsCount) {
        int combinations = 1;
        for(Entry<Long, Integer> primeFactorCount : primeFactorsCount.entrySet()) {
            int count = primeFactorCount.getValue();
            combinations *= count + 1;
        }
        return combinations;
    }
    
    private Map<Long, Integer> factorize(long k) {
        int smallK = (int) Math.sqrt(Math.sqrt(k));
        List<Long> primes = primeSieve(smallK);
        Map<Long, Integer> partialPrimeFactors = primeFactorsCount(k, primes);
        long partialEquivalentNumber = equivalentNumber(partialPrimeFactors);
        long partialK = k / partialEquivalentNumber;
        Map<Long, Integer> anotherPartialPrimeFactors = integerFactorization(partialK);
        partialPrimeFactors.putAll(anotherPartialPrimeFactors);
        return partialPrimeFactors;
    }
    
    private Map<Long, Integer> integerFactorization(long k) {
        int squareRootOfK = (int) Math.sqrt(k);
        // compute all primes less than squareRootOfK which potentially might be prime factors of K
        List<Long> primes = primeSieve(squareRootOfK);
        Map<Long, Integer> primeFactorsCount = primeFactorsCount(k, primes);
        // there might be at most one prime factor of K which is larger than squareRootOfK
        long equivalentK = equivalentNumber(primeFactorsCount);
        if(equivalentK != k) {
            primeFactorsCount.put(k/equivalentK, 1);
        }
        return primeFactorsCount;
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
    
    private Set<Long> factors(long equivalentNumber, Map<Long, Integer> primeFactorsCount) {
        Set<Long> factors = new HashSet<Long>();
        
        if(childFactorsMap.containsKey(equivalentNumber)) {
            factors = childFactorsMap.get(equivalentNumber);
        }
        else {
            if(equivalentNumber == 1) {
                factors.add(1L);
            }
            else {
                for(Entry<Long, Integer> primeCount : primeFactorsCount.entrySet()) {
                    long prime = primeCount.getKey();
                    int count = primeCount.getValue();
                    if(count > 0) {
                        primeFactorsCount.put(prime, count - 1);
                        Set<Long> subFactors = factors(equivalentNumber / prime, primeFactorsCount);
                        factors.addAll(subFactors);
                        for(Long factor : subFactors) {
                            long largeFactor = factor * prime; 
                            factors.add(largeFactor);
                        }
                        primeFactorsCount.put(prime, count);
                    }
                }
            }
            childFactorsMap.put(equivalentNumber, factors);
        }
        return factors;
    }
    
    private List<Long> getInput() {
        List<Long> inputNumbers = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024 * 10);
            String firstLine = br.readLine();
            String[] nnk = firstLine.split(" ");
            N = Integer.parseInt(nnk[0]);
            K = Long.parseLong(nnk[1]);
            
            inputNumbers = new ArrayList<Long>(N);
            String[] numbers = br.readLine().split(" ");
            for (int i = 0; i < numbers.length; i++) {
                inputNumbers.add(Long.parseLong(numbers[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputNumbers;
    }
}
