package com.niyue.coding.misc.arrayshuffle;

import static org.junit.Assert.assertThat;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class ArrayShuffleTest {

	@Test
	public void test12() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 2});
		assertThat(result, is(new int[]{1, 2}));
	}
	
	@Test
	public void test1234() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 2, 3, 4});
		assertThat(result, is(new int[]{1, 3, 2, 4}));
	}
	
	@Test
	public void test123456() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 3, 5, 2, 4, 6});
		assertThat(result, is(new int[]{1, 2, 3, 4, 5, 6}));
	}
	
	@Test
	public void test12345678() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 3, 5, 7, 2, 4, 6, 8});
		assertThat(result, is(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
	}
	
	@Test
	public void test1234567890() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 0});
		assertThat(result, is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
	}
	
	@Test
	public void test12345678901112() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 3, 5, 7, 9, 11, 2, 4, 6, 8, 10, 12});
		assertThat(result, is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
	}
	
	@Test
	public void test123456789011121314() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 3, 5, 7, 9, 11, 13, 2, 4, 6, 8, 10, 12, 14});
		assertThat(result, is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}));
	}
	
	@Test
	public void test1234567890111213141516() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 2, 4, 6, 8, 10, 12, 14, 16});
		assertThat(result, is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}));
	}
	
	@Test
	public void test12345678901112131415161718() {
		ArrayShuffle as = new ArrayShuffle();
		int[] result = as.shuffle(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17, 2, 4, 6, 8, 10, 12, 14, 16, 18});
		assertThat(result, is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}));
	}
}
