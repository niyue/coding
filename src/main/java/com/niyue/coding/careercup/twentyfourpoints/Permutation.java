package com.niyue.coding.careercup.twentyfourpoints;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	private List<List<Integer>> permutations;
	
	public List<List<Integer>> permute(List<Integer> numbers) {
		permutations = new ArrayList<List<Integer>>();
		permute(new ArrayList<Integer>(numbers), new ArrayList<Integer>());
		return permutations;
	}
	
	private void permute(List<Integer> numbers, List<Integer> permutation) {
		if(numbers.isEmpty()) {
			permutations.add(new ArrayList<Integer>(permutation));
		} else {
			for(int i = 0; i < numbers.size(); i++) {
				permutation.add(numbers.get(i));
				int number = numbers.remove(i);
				permute(numbers, permutation);
				numbers.add(i, number);
				permutation.remove(permutation.size() - 1);
			}
		}
	}
}
