package com.niyue.coding.misc.circulararraydetection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CircularArrayDetectionTest {

	@Test
	public void testOneNull() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {null});
		assertThat(hasCircle, is(false));
	}
	
	@Test
	public void testSelfCircle() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {0});
		assertThat(hasCircle, is(true));
	}
	
	@Test
	public void testTwoElementsWithoutCircle() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {1, null});
		assertThat(hasCircle, is(false));
	}
	
	@Test
	public void testTwoElementsWithCircle() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {1, 0});
		assertThat(hasCircle, is(true));
	}
	
	@Test
	public void testThreeElementsWithoutCircle() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {2, 2, null});
		assertThat(hasCircle, is(false));
	}

	@Test
	public void testThreeElementsWithCircle() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {1, 2, 0});
		assertThat(hasCircle, is(true));
	}
	
	@Test
	public void testArrayWithTwoCircles() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {1, null, 3, 2, 5, 6, 4});
		assertThat(hasCircle, is(true));
	}
	
	@Test
	public void testArrayCircleWithTail() {
		CircularArrayDetection array = new CircularArrayDetection();
		boolean hasCircle = array.hasCircle(new Integer[] {1, null, 3, 4, 5, 6, 4});
		assertThat(hasCircle, is(true));
	}
}
