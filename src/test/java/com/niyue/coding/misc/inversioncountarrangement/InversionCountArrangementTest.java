package com.niyue.coding.misc.inversioncountarrangement;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.careercup.inversioncountarrangement.InversionCountArrangement;

public class InversionCountArrangementTest {

	@Test
	public void testSingleElement() {
		InversionCountArrangement ica = new InversionCountArrangement();
		List<Integer> arrangement = ica.arrange(Arrays.asList(1), Arrays.asList(0));
		assertThat(arrangement, is(Arrays.asList(1)));
	}
	
	@Test
	public void testTwoElementsWithDesendingArrangement() {
		InversionCountArrangement ica = new InversionCountArrangement();
		List<Integer> arrangement = ica.arrange(Arrays.asList(1, 2), Arrays.asList(0, 1));
		assertThat(arrangement, is(Arrays.asList(2, 1)));
	}
	
	@Test
	public void testTwoElementsWithAscendingArrangement() {
		InversionCountArrangement ica = new InversionCountArrangement();
		List<Integer> arrangement = ica.arrange(Arrays.asList(1, 2), Arrays.asList(0, 0));
		assertThat(arrangement, is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void testTwoElementsWithEqualValue() {
		InversionCountArrangement ica = new InversionCountArrangement();
		List<Integer> arrangement = ica.arrange(Arrays.asList(1, 1), Arrays.asList(0, 0));
		assertThat(arrangement, is(Arrays.asList(1, 1)));
	}
	
	@Test
	public void testThreeElements() {
		InversionCountArrangement ica = new InversionCountArrangement();
		List<Integer> arrangement = ica.arrange(Arrays.asList(3, 2, 1), Arrays.asList(0, 1, 1));
		assertThat(arrangement, is(Arrays.asList(3, 1, 2)));
	}
	
	@Test
	public void testSixElements() {
		InversionCountArrangement ica = new InversionCountArrangement();
		List<Integer> arrangement = ica.arrange(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(0, 0, 2, 1, 4, 3));
		assertThat(arrangement, is(Arrays.asList(4, 6, 2, 5, 1, 3)));
	}
	
	@Test
	public void testComplexElements() {
		InversionCountArrangement ica = new InversionCountArrangement();
		List<Integer> arrangement = ica.arrange(Arrays.asList(4, 5, 6, 6, 5, 2, 2, 1), Arrays.asList(0, 0, 1, 0, 4, 4, 5, 7));
		assertThat(arrangement, is(Arrays.asList(5, 6, 5, 6, 2, 4, 2, 1)));
	}

}
