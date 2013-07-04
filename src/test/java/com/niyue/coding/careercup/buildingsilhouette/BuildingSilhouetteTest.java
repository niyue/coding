package com.niyue.coding.careercup.buildingsilhouette;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.careercup.buildingsilhouette.BuildingSilhouette;
import com.niyue.coding.careercup.buildingsilhouette.BuildingSilhouette.Skyline;

public class BuildingSilhouetteTest {

	@Test
	public void testSingleBuilding() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(s(1, 2, 5)));
		assertThat(result, is(Arrays.asList(s(1, 2, 5))));
	}
	
	@Test
	public void testTwoNonOverlappedBuildings() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(1, 2, 5),
				s(3, 4, 6)));
		assertThat(result, is(Arrays.asList(
				s(1, 2, 5),
				s(3, 4, 6))));
	}
	
	@Test
	public void testTwoContinousBuildings() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(1, 2, 5),
				s(2, 4, 6)));
		assertThat(result, is(Arrays.asList(
				s(1, 2, 5),
				s(2, 4, 6))));
	}
	
	@Test
	public void testTwoOverlappedBuildings() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(1, 3, 5),
				s(2, 4, 6)));
		assertThat(result, is(Arrays.asList(
				s(1, 2, 5),
				s(2, 4, 6))));
	}
	
	@Test
	public void testSmallerOverlappedBuildings() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(3, 5, 6),
				s(4, 6, 3)));
		assertThat(result, is(Arrays.asList(
				s(3, 5, 6),
				s(5, 6, 3))));
	}
	
	@Test
	public void testThreeOverlappedBuildings() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(1, 4, 4),
				s(3, 5, 6),
				s(4, 6, 3)));
		assertThat(result, is(Arrays.asList(
				s(1, 3, 4),
				s(3, 5, 6),
				s(5, 6, 3))));
	}
	
	@Test
	public void testTwoNonOverlappedBuildingsWithEqualHigh() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(1, 2, 5),
				s(3, 4, 5)));
		assertThat(result, is(Arrays.asList(
				s(1, 2, 5),
				s(3, 4, 5))));
	}
	
	@Test
	public void testTwoOverlappedBuildingsWithEqualHigh() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(1, 3, 5),
				s(3, 4, 5)));
		assertThat(result, is(Arrays.asList(
				s(1, 4, 5))));
	}
	
	@Test
	public void testVeryWideBuildings() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(1, 10, 9),
				s(1, 3, 5),
				s(2, 8, 5)));
		assertThat(result, is(Arrays.asList(
				s(1, 10, 9))));
	}
	
	@Test
	public void testVeryTallBuildingInTheMiddle() {
		BuildingSilhouette bs = new BuildingSilhouette();
		List<Skyline> result = bs.find(Arrays.asList(
				s(4, 7, 9),
				s(1, 8, 5)));
		assertThat(result, is(Arrays.asList(
				s(1, 4, 5),
				s(4, 7, 9),
				s(7, 8, 5))));
	}
	
	private Skyline s(int start, int end, int high) {
		Skyline s = new Skyline();
		s.start = start;
		s.end = end;
		s.high = high;
		return s;
	}
}
