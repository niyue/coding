package com.niyue.coding.careercup.twentyfourpoints;

import java.util.ArrayList;
import java.util.List;

public class Permutation <E> {
	private List<List<E>> permutations;
	
	public List<List<E>> permute(List<E> elements) {
		permutations = new ArrayList<List<E>>();
		permute(new ArrayList<E>(elements), new ArrayList<E>());
		return permutations;
	}
	
	private void permute(List<E> elements, List<E> permutation) {
		if(elements.isEmpty()) {
			permutations.add(new ArrayList<E>(permutation));
		} else {
			for(int i = 0; i < elements.size(); i++) {
				permutation.add(elements.get(i));
				E element = elements.remove(i);
				permute(elements, permutation);
				elements.add(i, element);
				permutation.remove(permutation.size() - 1);
			}
		}
	}
	
	public List<List<E>> permute(List<E> elements, int k) {
		permutations = new ArrayList<List<E>>();
		permute(new ArrayList<E>(elements), new ArrayList<E>(), elements.size() - k);
		return permutations;
	}
	
	private void permute(List<E> elements, List<E> permutation, int x) {
		if(elements.size() == x) {
			permutations.add(new ArrayList<E>(permutation));
		} else {
			for(int i = 0; i < elements.size(); i++) {
				permutation.add(elements.get(i));
				E element = elements.remove(i);
				permute(elements, permutation, x);
				elements.add(i, element);
				permutation.remove(permutation.size() - 1);
			}
		}
	}
}
