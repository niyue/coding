package com.niyue.coding.careercup.negativeiterator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Test;

public class NegativeIteratorTest {

	@Test
	public void testOnePositive() {
		NegativeIterator iter = new NegativeIterator(
				Arrays.asList(1).iterator());
		assertFalse(iter.hasNext());
	}
	
	@Test
	public void testOneNegative() {
		NegativeIterator iter = new NegativeIterator(
				Arrays.asList(-1).iterator());
		assertTrue(iter.hasNext());
		assertEquals(Integer.valueOf(-1), iter.next());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNoSuchElement() {
		NegativeIterator iter = new NegativeIterator(
				Arrays.asList(-1).iterator());
		iter.next();
		iter.next();
	}
	
	@Test
	public void testPositiveNegative() {
		NegativeIterator iter = new NegativeIterator(
				Arrays.asList(1, -1).iterator());
		assertTrue(iter.hasNext());
		assertEquals(Integer.valueOf(-1), iter.next());
	}
	
	@Test
	public void testPositiveNegativeNegative() {
		NegativeIterator iter = new NegativeIterator(
				Arrays.asList(1, -1, -2).iterator());
		assertTrue(iter.hasNext());
		assertEquals(Integer.valueOf(-1), iter.next());
		assertTrue(iter.hasNext());
		assertEquals(Integer.valueOf(-2), iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test
	public void testMultipleHasNext() {
		NegativeIterator iter = new NegativeIterator(
				Arrays.asList(1, -1, -2).iterator());
		assertTrue(iter.hasNext());
		assertTrue(iter.hasNext());
		assertTrue(iter.hasNext());
		assertTrue(iter.hasNext());
	}
	
	@Test
	public void testLongSeq() {
		NegativeIterator iter = new NegativeIterator(
				Arrays.asList(0, 1, -1, -2, 0, -1, 0).iterator());
		assertTrue(iter.hasNext());
		assertEquals(Integer.valueOf(-1), iter.next());
		assertTrue(iter.hasNext());
		assertEquals(Integer.valueOf(-2), iter.next());
		assertTrue(iter.hasNext());
		assertEquals(Integer.valueOf(-1), iter.next());
	}
}
