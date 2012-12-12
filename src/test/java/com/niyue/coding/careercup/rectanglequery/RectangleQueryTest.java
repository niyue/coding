package com.niyue.coding.careercup.rectanglequery;

import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import com.niyue.coding.careercup.rectanglequery.RectangleQuery.Rectangle;

public class RectangleQueryTest {

	@Test
	public void testOneRectangle() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(0, 0, 2, 2)
		);
		assertThat(rq.query(1, 1), equalTo(1));
	}
	
	@Test
	public void testOneRectangleXLargerThanMaxQuery() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(0, 0, 2, 2)
		);
		assertThat(rq.query(3, 1), equalTo(0));
	}
	
	@Test
	public void testOneRectangleXSmallerThanMinQuery() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(0, 0, 2, 2)
		);
		assertThat(rq.query(-1, 1), equalTo(0));
	}
	
	@Test
	public void testOneRectangleStartingFromMin() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(0, 0, 2, 2)
		);
		assertThat(rq.query(0, 1), equalTo(1));
	}
	
	@Test
	public void testTwoNonOverlappedRectangles() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(1, 1, 2, 2),
				new Rectangle(3, 1, 4, 3)
		);
		assertThat(rq.query(1, 1), equalTo(1));
		assertThat(rq.query(3, 1), equalTo(1));
		assertThat(rq.query(4, 2), equalTo(0));
	}
	
	@Test
	public void testTwoOverlappedRectangles() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(1, 1, 3, 3),
				new Rectangle(2, 0, 4, 2)
		);
		assertThat(rq.query(1, 1), equalTo(1));
		assertThat(rq.query(3, 1), equalTo(1));
		assertThat(rq.query(2, 1), equalTo(2));
		assertThat(rq.query(0, 2), equalTo(0));
		assertThat(rq.query(2, 0), equalTo(1));
	}
	
	@Test
	public void testEmbeddedRectangles() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(1, 1, 4, 4),
				new Rectangle(2, 2, 3, 3)
		);
		assertThat(rq.query(1, 1), equalTo(1));
		assertThat(rq.query(2, 1), equalTo(1));
		assertThat(rq.query(3, 0), equalTo(0));
		assertThat(rq.query(3, 3), equalTo(1));
		assertThat(rq.query(2, 2), equalTo(2));
		assertThat(rq.query(5, 5), equalTo(0));
	}
	
	@Test
	public void testTwoNonOverlappedRectanglesInYAxis() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(0, 0, 2, 1),
				new Rectangle(0, 2, 1, 3)
		);
		assertThat(rq.query(0, 0), equalTo(1));
		assertThat(rq.query(1, 1), equalTo(0));
		assertThat(rq.query(0, 1), equalTo(0));
		assertThat(rq.query(0, 2), equalTo(1));
	}
	
	@Test
	public void testThreeOverlappedRectangles() {
		RectangleQuery rq = new RectangleQuery(
				new Rectangle(1, 1, 4, 4),
				new Rectangle(2, 2, 6, 6),
				new Rectangle(3, 3, 5, 5)
		);
		for(int y=0;y<10;y++) {
			assertThat(rq.query(0, y), equalTo(0));
		}
		
		for(int x=0;x<10;x++) {
			assertThat(rq.query(x, 0), equalTo(0));
		}
		
		assertThat(rq.query(1, 4), equalTo(0));
		assertThat(rq.query(1, 5), equalTo(0));
		
		assertThat(rq.query(4, 1), equalTo(0));
		assertThat(rq.query(5, 1), equalTo(0));
		
		assertThat(rq.query(1, 1), equalTo(1));
		assertThat(rq.query(1, 2), equalTo(1));
		assertThat(rq.query(1, 3), equalTo(1));
		
		assertThat(rq.query(2, 1), equalTo(1));
		assertThat(rq.query(2, 4), equalTo(1));
		assertThat(rq.query(2, 5), equalTo(1));
		
		assertThat(rq.query(3, 1), equalTo(1));
		assertThat(rq.query(3, 5), equalTo(1));
		
		assertThat(rq.query(4, 2), equalTo(1));
		assertThat(rq.query(4, 5), equalTo(1));
		
		assertThat(rq.query(5, 2), equalTo(1));
		assertThat(rq.query(5, 3), equalTo(1));
		assertThat(rq.query(5, 4), equalTo(1));
		assertThat(rq.query(5, 5), equalTo(1));
		
		assertThat(rq.query(2, 2), equalTo(2));
		assertThat(rq.query(2, 3), equalTo(2));
		assertThat(rq.query(3, 2), equalTo(2));
		
		assertThat(rq.query(3, 3), equalTo(3));
	}
	
}
