package com.niyue.coding.hackerrank.sherlockandpairs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i++) {
			sc.nextLine();
        	String line = sc.nextLine();
        	String[] numbers = line.split(" ");
        	countPairs(numbers);
        }
        sc.close();
    }
    
	private static void countPairs(String[] numbers) {
		Map<String, Long> map = new HashMap<String, Long>();
		for(String n : numbers) {
			if(!map.containsKey(n)) {
				map.put(n, 0L);
			}
			map.put(n, map.get(n) + 1);
		}
		long count = 0;
		for(long pairCount : map.values()) {
			if(pairCount >= 2) {
				count += pairCount * (pairCount - 1);
			}
		}
		System.out.println(count);
	}
}