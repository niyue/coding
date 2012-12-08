package com.niyue.coding.careercup.signaturepermutation;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.careercup.signaturepermutation.SignaturePermutation.Direction;

public class SignaturePermutationTest {
	
	@Test
	public void testParsing() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Direction> directions = sg.parse("DID");
		assertEquals(3, directions.size());
		assertEquals(Direction.D, directions.get(0));
		assertEquals(Direction.I, directions.get(1));
		assertEquals(Direction.D, directions.get(2));
	}
	
	@Test
	public void testSimpleSortLexicographically() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> numbers = sg.sortLexicographically(Arrays.asList(1, 2, 3, 4, 10));
		assertThat(numbers, is(Arrays.asList(10, 1, 2, 3, 4)));
	}
	
	@Test
	public void testSortLexicographically() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> numbers = sg.sortLexicographically(Arrays.asList(1, 2, 3, 4, 10, 11));
		assertThat(numbers, is(Arrays.asList(10, 11, 1, 2, 3, 4)));
	}
	
	@Test
	public void testAllNumbers() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> numbers = sg.allNumbers(5);
		assertThat(numbers, is(Arrays.asList(1, 2, 3, 4, 5)));
	}
	
	@Test
	public void testHighestIndexes() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Direction> directions = sg.parse("DIDDI");
		List<Integer> indexes = sg.extremeNumberIndexes(directions, Direction.I);
		assertThat(indexes, is(Arrays.asList(2, 5)));
	}
	
	@Test
	public void testLowestIndexes() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Direction> directions = sg.parse("DIIDID");
		List<Integer> indexes = sg.extremeNumberIndexes(directions, Direction.D);
		assertThat(indexes, is(Arrays.asList(1, 4, 6)));
	}
	
	@Test
	public void testLowestIndexesForDDIIDI() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Direction> directions = sg.parse("DDIIDI");
		List<Integer> indexes = sg.extremeNumberIndexes(directions, Direction.D);
		assertThat(indexes, is(Arrays.asList(2, 5)));
	}
	
	@Test
	public void testFindLexicographicallyMax() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> numbers = sg.sortLexicographically(Arrays.asList(1, 2, 3, 4, 8, 10, 11, 12));
		assertThat(sg.findLexicographicallyMax(numbers, 9), equalTo(1));
		assertThat(sg.findLexicographicallyMax(numbers, 15), equalTo(10));
	}
	
	@Test
	public void testFindLexicographicallyMin() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> numbers = sg.sortLexicographically(Arrays.asList(1, 2, 3, 4, 8, 10, 11, 12));
		assertThat(sg.findLexicographicallyMin(numbers, 7), equalTo(10));
		assertThat(sg.findLexicographicallyMin(numbers, 11), equalTo(11));
	}
	
	@Test
	public void testSmallestPermutationWithDSignature() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> permutation = sg.smallestPermutation("D");
		assertThat(permutation, is(Arrays.asList(2, 1)));
	}
	
	@Test
	public void testSmallestPermutationWithDISignature() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> permutation = sg.smallestPermutation("DI");
		assertThat(permutation, is(Arrays.asList(2, 1, 3)));
	}
	
	@Test
	public void testSmallestPermutationWithIDISignature() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> permutation = sg.smallestPermutation("IDI");
		assertThat(permutation, is(Arrays.asList(1, 3, 2, 4)));
	}
	
	@Test
	public void testSmallestPermutationWithDDIIDISignature() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> permutation = sg.smallestPermutation("DDIIDI");
		assertThat(permutation, is(Arrays.asList(3, 2, 1, 4, 6, 5, 7)));
	}
	
	@Test
	public void testSmallestPermutationComplex() throws Exception {
		SignaturePermutation sg = new SignaturePermutation();
		List<Integer> permutation = sg.smallestPermutation("IIIDDDIIDII");
		assertThat(permutation, is(Arrays.asList(1, 10, 11, 12, 4, 3, 2, 5, 7, 6, 8, 9)));
	}
}
