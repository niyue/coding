package com.niyue.coding.misc.equalproduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given some integer N, print all the solutions of A * B = C * D where A,B,C,D are all in [1...N]. 
 */
public class EqualProduct {
	public List<List<Integer>> find(int n) {
		Map<Integer, List<List<Integer>>> products = new HashMap<Integer, List<List<Integer>>>();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				int product = i * j;
				if(!products.containsKey(product)) {
					products.put(product, new ArrayList<List<Integer>>());
				}
				products.get(product).add(Arrays.asList(i, j));
			}
		}
		
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		for(int a = 1; a <= n; a++) {
			for(int b = 1; b <= n; b++) {
				int product = a * b;
				List<List<Integer>> cdProducts = products.get(product);
				for(List<Integer> cd : cdProducts) {
					int c = cd.get(0);
					int d = cd.get(1);
					solutions.add(Arrays.asList(a, b, c, d));
				}
			}
		}
		return solutions;
	}
}
