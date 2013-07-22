package com.niyue.coding.misc.rollingmedian;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * http://stackoverflow.com/questions/9841416/find-median-in-a-fixed-size-moving-window-along-a-long-sequence-of-data
 * Given a sequence of data (it may have duplicates), a fixed-sized moving window, move the window at each iteration from the start of the data sequence, such that
 * (1) the oldest data element is removed from the window and a new data element is pushed into the window
 * (2) find the median of the data inside the window at each moving.
 */
public class RollingMedian {
	public List<Double> find(List<Integer> numbers, int k) {
		assert numbers.size() >= k;
		List<Double> medians = new ArrayList<Double>();
		List<IntegerNumber> nums = convert(numbers);
		SortedSet<IntegerNumber> left = new TreeSet<IntegerNumber>();
		SortedSet<IntegerNumber> right = new TreeSet<IntegerNumber>();
		for(int i = 0; i < k; i++) {
			if(right.isEmpty()) {
				left.add(nums.get(i));
			} else {
				slideRight(left, right, nums, i);
			}
			balance(left, right);
		}
		
		boolean isOdd = (k & 1) == 1;
		double median = median(left, right, isOdd);
		medians.add(median);
		
		for(int i = k; i < nums.size(); i++) {
			slide(left, right, nums, i, k);
			median = median(left, right, isOdd);
			medians.add(median);
		}
		return medians;
	}
	
	private double median(SortedSet<IntegerNumber> left, SortedSet<IntegerNumber> right, boolean isOdd) {
		return isOdd 
				? left.last().value
				: (left.last().value + right.first().value) / 2.0;
	}
	
	private void slide(SortedSet<IntegerNumber> left, SortedSet<IntegerNumber> right, List<IntegerNumber> nums, int i, int k) {
		removeOutOfWindow(left, right, nums, i, k);
		slideRight(left, right, nums, i);
		balance(left, right);
	}
	
	private void removeOutOfWindow(SortedSet<IntegerNumber> left, SortedSet<IntegerNumber> right, List<IntegerNumber> nums, int i, int k) {
		IntegerNumber removedNumber = nums.get(i - k);
		if(left.contains(removedNumber)) {
			left.remove(removedNumber);
		} else {
			right.remove(removedNumber);
		}
	}
	
	private void slideRight(SortedSet<IntegerNumber> left, SortedSet<IntegerNumber> right, List<IntegerNumber> nums, int i) {
		IntegerNumber current = nums.get(i);
		IntegerNumber rightFirst = right.isEmpty() ? null : right.first();
		if(rightFirst != null && current.compareTo(rightFirst) > 0) {
			right.remove(rightFirst);
			left.add(rightFirst);
			right.add(current);
		} else {
			left.add(current);
		}
	}
	
	private void balance(SortedSet<IntegerNumber> left, SortedSet<IntegerNumber> right) {
		if(left.size() > right.size() + 1) {
			IntegerNumber last = left.last();
			left.remove(last);
			right.add(last);
		}
	}
	
	private List<IntegerNumber> convert(List<Integer> numbers) {
		List<IntegerNumber> nums = new ArrayList<IntegerNumber>();
		for(int i = 0; i < numbers.size(); i++) {
			nums.add(new IntegerNumber(numbers.get(i), i));
		}
		return nums;
	}
	
	private static class IntegerNumber implements Comparable<IntegerNumber> {
		private final int value;
		private final int index;
		
		public IntegerNumber(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		@Override
		public int compareTo(IntegerNumber o) {
			if(this.value == o.value) {
				return this.index - o.index;
			}
			return this.value - o.value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IntegerNumber other = (IntegerNumber) obj;
			if (index != other.index)
				return false;
			if (value != other.value)
				return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + value;
			return result;
		}

		@Override
		public String toString() {
			return "[value=" + value + ", index=" + index + "]";
		}
	}
}
