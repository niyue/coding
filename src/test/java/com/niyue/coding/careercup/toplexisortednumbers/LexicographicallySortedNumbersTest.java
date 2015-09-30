package com.niyue.coding.careercup.toplexisortednumbers;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class LexicographicallySortedNumbersTest {

	@Test
	public void testOne() {
		LexicographicallySortedNumbers sort = new LexicographicallySortedNumbers();
		
		List<Integer> nums = sort.sort(1);
	
		assertThat(nums, is(Arrays.asList(1)));
	}
	
	@Test
	public void testTwo() {
		LexicographicallySortedNumbers sort = new LexicographicallySortedNumbers();
		
		List<Integer> nums = sort.sort(2);
	
		assertThat(nums, is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void testTen() {
		LexicographicallySortedNumbers sort = new LexicographicallySortedNumbers();
		
		List<Integer> nums = sort.sort(10);
	
		assertThat(nums, is(Arrays.asList(1, 10, 2, 3, 4, 5, 6, 7, 8, 9)));
	}
	
	@Test
	public void testEleven() {
		LexicographicallySortedNumbers sort = new LexicographicallySortedNumbers();
		
		List<Integer> nums = sort.sort(11);
	
		assertThat(nums, is(Arrays.asList(1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9)));
	}
	
	@Test
	public void testOneHundred() {
		LexicographicallySortedNumbers sort = new LexicographicallySortedNumbers();
		
		List<Integer> nums = sort.sort(100);
	
		assertThat(nums.subList(0, 16), 
				is(Arrays.asList(1, 10, 100, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22)));
	}
}
