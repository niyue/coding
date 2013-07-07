package com.niyue.coding.careercup.ctrlcctrlv;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import com.niyue.coding.careercup.ctrlctrcv.CtrlcCtrlv;
import com.niyue.coding.careercup.ctrlctrcv.CtrlcCtrlv.PressingResult;

public class CtrlcCtrlvTest {

	@Test
	public void testOneStroke() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(1);
		assertThat(result.max, is(1));
		assertThat(result.keystrokes, is(Arrays.asList("A")));
	}
	
	@Test
	public void testTwoStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(2);
		assertThat(result.max, is(2));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A")));
	}
	
	@Test
	public void testThreeStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(3);
		assertThat(result.max, is(3));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A", "A")));
	}
	
	@Test
	public void testFourStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(4);
		assertThat(result.max, is(4));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A", "A", "A")));
	}
	
	@Test
	public void testFiveStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(5);
		assertThat(result.max, is(5));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A", "A", "A", "A")));
	}
	
	@Test
	public void testSixStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(6);
		assertThat(result.max, is(6));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A", "A", "A", "A", "A")));
	}
	
	@Test
	public void testSevenStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(7);
		assertThat(result.max, is(7));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A", "A", "A", "A", "A", "A")));
	}
	
	@Test
	public void testEightStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(8);
		assertThat(result.max, is(9));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A", "A", "CtrlA", "CtrlC", "CtrlV", "CtrlV", "CtrlV")));
	}
	
	@Test
	public void testNineStrokes() {
		CtrlcCtrlv cc = new CtrlcCtrlv();
		PressingResult result = cc.press(9);
		assertThat(result.max, is(12));
		assertThat(result.keystrokes, is(Arrays.asList("A", "A", "A", "A", "CtrlA", "CtrlC", "CtrlV", "CtrlV", "CtrlV")));
	}
}
